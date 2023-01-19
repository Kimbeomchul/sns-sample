package com.mozzi.sns.util;

import com.mozzi.sns.domain.SocialType;
import com.mozzi.sns.domain.UserLive;
import com.mozzi.sns.domain.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.Timestamp;
import java.util.Date;

/**
 * packageName : com.mozzi.sns.util
 * fileName : JwtTokenUtils
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */


@Slf4j
public class JwtTokenUtils {

    /**
     * 회원아이디 반환
     */
    public static String getUserName(String token, String key){
        return extractClaims(token, key).get("userName", String.class);
    }

    /**
     * 토큰 유효시간체크
     */
    public static boolean isTokenExpired(String token, String key){
        Date expiration = extractClaims(token, key).getExpiration();
        return expiration.before(new Date());
    }

    /**
     * 토큰 디코딩
     */
    private static Claims extractClaims(String token, String key){
        return Jwts.parserBuilder().setSigningKey(getKey(key))
                .build().parseClaimsJws(token).getBody();
    }

    /**
     * JWT 토큰생성
     */
    public static String generateToken(String userName, String nickName, String userImage, UserLive userLive, SocialType socialType, UserRole userRole, Timestamp registeredAt, String key, long expiredTimeMs){
        Claims claims = Jwts.claims();
        claims.put("userName", userName);
        claims.put("nickName", nickName);
        claims.put("userImage", userImage);
        claims.put("socialType", socialType);
        claims.put("userLive", userLive);
        claims.put("userRole", userRole);
        claims.put("registeredAt", registeredAt);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTimeMs))
                .signWith(getKey(key), SignatureAlgorithm.HS256)
                .compact();
    }

    private static Key getKey(String key) {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(bytes);
    }
}
