package com.mozzi.sns.config.filter;


import com.google.common.net.HttpHeaders;
import com.mozzi.sns.domain.User;
import com.mozzi.sns.service.UserService;
import com.mozzi.sns.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final String key;
    private final UserService userService;
    private static final String[] whiteList = {"/api/*/users/join", "/api/*/users/login"};


    /**
     * TODO :: 비로그인시 에러 OR 리다이렉션 처리 OR AuthenticationConfig 공통처리
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // whiteList 체크
        final String requestURI = request.getRequestURI();
        if(!whiteListMatcher(requestURI)){
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰 존재여부 체크
        final String header = request.getHeader("authorization");

        if(header == null || !header.startsWith("Bearer ")){
            log.error("Error occurs while getting user info from token");
            filterChain.doFilter(request, response);
            return;
        }

        try{
            final String token = header.split(" ")[1].trim();

            // 토큰 유효시간 체크
            if(JwtTokenUtils.isTokenExpired(token, key)){
                log.error("Expired key used");
                filterChain.doFilter(request, response);
                return;
            }

            // 유효한 유저인지 체크
            String userName = JwtTokenUtils.getUserName(token ,key);
            User user = userService.loadUserByUserName(userName);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities()
            );

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }catch (RuntimeException e){
            log.error("Error occurs while validating :: {}", e.toString());
            filterChain.doFilter(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean whiteListMatcher(String urlPath) {
        return !PatternMatchUtils.simpleMatch(whiteList, urlPath);
    }
}
