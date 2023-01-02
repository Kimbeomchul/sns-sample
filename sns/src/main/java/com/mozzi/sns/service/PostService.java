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


    /**
     * TODO :: 해시태그 "#" 처리
     * TODO :: 게시글 처리
     * @param title
     * @param content
     * @param hashtag
     * @param userName
     */
    @Transactional
    public void create(String title, String content, String hashtag, String userName){
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));
        postEntityRepository.save(PostEntity.of(title, content, hashtag, userEntity));
    }

}
