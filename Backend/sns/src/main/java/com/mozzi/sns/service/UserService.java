package com.mozzi.sns.service;


import com.google.common.net.HttpHeaders;
import com.mozzi.sns.domain.SocialType;
import com.mozzi.sns.domain.dto.User;
import com.mozzi.sns.domain.entity.UserEntity;
import com.mozzi.sns.exception.ErrorCode;
import com.mozzi.sns.exception.GlobalException;
import com.mozzi.sns.repository.UserEntityRepository;
import com.mozzi.sns.util.CommonUtils;
import com.mozzi.sns.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;


/**
 * packageName : com.mozzi.sns.service
 * fileName : UserService
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimes;

    @Value("${kakao.rest-token-key}")
    private String kakaoKey;

    @Value("${naver.rest-token-client-key}")
    private String naverClientKey;

    @Value("${naver.rest-token-secret-key}")
    private String naverSecretKey;

    @Value("${server.url}")
    private String serverUrl;


    // 유저체크용
    public User loadUserByUserName(String userName) {
        return userEntityRepository.findByUserName(userName).map(User::fromEntity).orElseThrow(() ->
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));
    }

    // 회원가입
    @Transactional
    public User join(String userName, String password, String nickName) {
        // 회원가입 체크
        userEntityRepository.findByUserName(userName).ifPresent(it -> {
            throw new GlobalException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
        });

        // 닉네임체크
        if(nickName.equals("") || nickName == null){
            nickName = CommonUtils.randomNickname();
        }

        // 회원가입 진행
        UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName, bCryptPasswordEncoder.encode(password), nickName, "default", SocialType.NORMAL));
        return User.fromEntity(userEntity);
    }


    // 유저조회
    @Transactional(readOnly = true)
    public User user(String userName) {
        return User.fromEntity(userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName))));
    }

    // 로그인
    @Transactional(readOnly = true)
    public String login(String userName, String password) {

        // 회원가입 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        // 비밀번호  체크
        if(!bCryptPasswordEncoder.matches(password, userEntity.getPassword())){
            throw new GlobalException(ErrorCode.INVALID_PASSWORD);
        }
        // 토큰생성
        return JwtTokenUtils.generateToken(userName, userEntity.getNickname(), userEntity.getUserImage(),userEntity.getLivingAt(),userEntity.getSocialType(), userEntity.getRole(), userEntity.getRegisteredAt(), secretKey, expiredTimes);
    }

    // 회원탈퇴
    @Transactional
    public void withdrawal(String userName){
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));
        userEntityRepository.deleteById(userEntity.getId());
    }


    // 소셜로그인 처리 ( 네이버 )
    @Transactional
    public String naverToken(String code){
        WebClient tokenApi = WebClient.builder()
                .baseUrl("https://nid.naver.com/oauth2.0/token")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8")
                .build();

        String response = tokenApi.post()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", naverClientKey)
                        .queryParam("client_secret", naverSecretKey)
                        .queryParam("code", code)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONObject joToken = new JSONObject(response);

        WebClient userInfo = WebClient.builder()
                .baseUrl("https://openapi.naver.com/v1/nid/me")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8")
                .defaultHeader("Authorization", "Bearer " + joToken.get("access_token"))
                .build();

        String responseInfo = userInfo.post()
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONObject joInfo = new JSONObject(responseInfo);
        log.info("######## 소셜로그인 네이버 로그인시도 :: {}" , joInfo);
        // 유저가 존재하는경우
        Optional<UserEntity> id = userEntityRepository.findByUserName(joInfo.getJSONObject("response").get("id").toString());
        if(id.isEmpty()) {
            // 회원가입 진행
            UserEntity registerNaver = UserEntity.of(String.valueOf(joInfo.getJSONObject("response").get("id")), bCryptPasswordEncoder.encode("Gwacheon2NaverLogin"), CommonUtils.randomNickname(), String.valueOf(joInfo.getJSONObject("response").get("profile_image")), SocialType.NAVER);
            userEntityRepository.saveAndFlush(registerNaver);
        }

        return login(joInfo.getJSONObject("response").get("id").toString(), "Gwacheon2NaverLogin");
    }

    // 소셜로그인 처리 ( 카카오 )
    @Transactional
    public String kakaoToken(String code){
        WebClient tokenApi = WebClient.builder()
                .baseUrl("https://kauth.kakao.com/oauth/token")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8")
                .build();

        String response = tokenApi.post()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", kakaoKey)
                        .queryParam("redirect_uri", serverUrl + "/api/v1/users/auth/kakao/callback")
                        .queryParam("code", code)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONObject joToken = new JSONObject(response);

        WebClient userInfo = WebClient.builder()
                .baseUrl("https://kapi.kakao.com/v2/user/me")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8")
                .defaultHeader("Authorization", "Bearer " + joToken.get("access_token"))
                .build();

        String responseInfo = userInfo.post()
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONObject joInfo = new JSONObject(responseInfo);
        log.info("######## 소셜로그인 카카오 로그인시도 :: {}" , joInfo);
        // 유저가 존재하는경우
        Optional<UserEntity> id = userEntityRepository.findByUserName(joInfo.get("id").toString());
        if(id.isEmpty()) {
            // 회원가입 진행
            UserEntity registerKakao = UserEntity.of(String.valueOf(joInfo.get("id")), bCryptPasswordEncoder.encode("Gwacheon2KakaoLogin"), CommonUtils.randomNickname(), String.valueOf(joInfo.getJSONObject("properties").get("profile_image")),  SocialType.KAKAO);
            userEntityRepository.saveAndFlush(registerKakao);
        }
        return login(joInfo.get("id").toString(), "Gwacheon2KakaoLogin");
    }

}
