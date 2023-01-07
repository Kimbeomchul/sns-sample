package com.mozzi.sns.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

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
     * TODO : 현재 토큰 내 회원아이디만 존재 추후 필요시 변경
     */
    public static String generateToken(String userName, String key, long expiredTimeMs){
        Claims claims = Jwts.claims();
        claims.put("userName", userName);
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
