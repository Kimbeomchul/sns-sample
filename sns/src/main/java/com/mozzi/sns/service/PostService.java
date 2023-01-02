package com.mozzi.sns.service;


import com.mozzi.sns.domain.entity.PostEntity;
import com.mozzi.sns.domain.entity.UserEntity;
import com.mozzi.sns.exception.ErrorCode;
import com.mozzi.sns.exception.SnsException;
import com.mozzi.sns.repository.PostEntityRepository;
import com.mozzi.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public void create(String title, String content, String userName){

        // user find
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));
        // post save
        PostEntity postEntity = postEntityRepository.save(PostEntity.of(title, content, userEntity));
        // return

    }

}
