package com.mozzi.sns.service;


import com.mozzi.sns.domain.Post;
import com.mozzi.sns.domain.entity.LikeEntity;
import com.mozzi.sns.repository.LikeEntityRepository;
import com.mozzi.sns.domain.entity.PostEntity;
import com.mozzi.sns.domain.entity.UserEntity;
import com.mozzi.sns.exception.ErrorCode;
import com.mozzi.sns.exception.GlobalException;
import com.mozzi.sns.repository.PostEntityRepository;
import com.mozzi.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;
    private final LikeEntityRepository likeEntityRepository;


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
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName))
        );
        postEntityRepository.save(PostEntity.of(title, content, hashtag, userEntity));
    }
    
    @Transactional
    public void modify(String title, String content, String hashtag, String userName, Long id){
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));

        PostEntity postEntity = postEntityRepository.findById(id).orElseThrow(() ->
                new GlobalException(ErrorCode.POST_NOT_FOUND, String.format("%s not found", id)));

        if(postEntity.getUser() != userEntity) {
            throw new GlobalException(ErrorCode.INVALID_PERMISSION, String.format("%s has no permission", userEntity));
        }

        postEntity.setTitle(title);
        postEntity.setContent(content);
        postEntity.setHashtag(hashtag);
        postEntityRepository.save(postEntity);
    }

    @Transactional
    public void delete(String userName, Long id){
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));

        PostEntity postEntity = postEntityRepository.findById(id).orElseThrow(() ->
                new GlobalException(ErrorCode.POST_NOT_FOUND, String.format("%s not found", id)));

        if(postEntity.getUser() != userEntity) {
            throw new GlobalException(ErrorCode.INVALID_PERMISSION, String.format("%s has no permission", userEntity));
        }

        postEntityRepository.delete(postEntity);
    }

    @Transactional(readOnly = true)
    public Page<Post> postList(Pageable pageable){
        return postEntityRepository.findAll(pageable).map(Post::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<Post> myPost(String userName, Pageable pageable){
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));
        return postEntityRepository.findAllByUser(userEntity, pageable).map(Post::fromEntity);
    }


    @Transactional
    public void like(String userName, Long id){
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));

        PostEntity postEntity = postEntityRepository.findById(id).orElseThrow(() ->
                new GlobalException(ErrorCode.POST_NOT_FOUND, String.format("%s not found", id)));

        // 좋아요 누른사람인지 체크
        Optional<LikeEntity> byUserAndPost = likeEntityRepository.findByUserAndPost(userEntity, postEntity);
        if(byUserAndPost.isPresent()){
            likeEntityRepository.delete(byUserAndPost.get());
        }else{
            likeEntityRepository.save(LikeEntity.of(userEntity, postEntity));
        }
    }

    @Transactional(readOnly = true)
    public Integer likeCount(Long id){
        PostEntity postEntity = postEntityRepository.findById(id).orElseThrow(() ->
                new GlobalException(ErrorCode.POST_NOT_FOUND, String.format("%s post not found", id)));

        return likeEntityRepository.countByPost(postEntity);
    }
}
