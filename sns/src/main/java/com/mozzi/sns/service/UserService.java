package com.mozzi.sns.service;


import com.mozzi.sns.domain.User;
import com.mozzi.sns.domain.entity.UserEntity;
import com.mozzi.sns.exception.ErrorCode;
import com.mozzi.sns.exception.SnsException;
import com.mozzi.sns.repository.UserEntityRepository;
import com.mozzi.sns.util.JwtTokenUtils;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional
    public User join(String userName, String password) {

        // 회원가입 체크
        userEntityRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
        });

        // 회원가입 진행
        UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName, bCryptPasswordEncoder.encode(password)));
        return User.fromEntity(userEntity);
    }

    public String login(String userName, String password) {

        // 회원가입 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        // 비밀번호  체크
        if(!bCryptPasswordEncoder.matches(password, userEntity.getPassword())){
            throw new SnsException(ErrorCode.INVALID_PASSWORD);
        }

        // 토큰 생성
        String token = JwtTokenUtils.generateToken(userName, secretKey, expiredTimes);
        return token;
    }
}
