package com.mozzi.sns.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomAuthenticationException implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(ErrorCode.INVALID_TOKEN.getStatus().value());
        StringBuffer sb = new StringBuffer();
        sb.append("{")
            .append("\"resultCode\":").append("\"").append(HttpStatus.UNAUTHORIZED.getReasonPhrase()).append("\",")
            .append("\"result\":").append("\"").append(ErrorCode.INVALID_TOKEN.getMessage()).append("\"")
            .append("}");
        response.getWriter().write(sb.toString());
    }
}
