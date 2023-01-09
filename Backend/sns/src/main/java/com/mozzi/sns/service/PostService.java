package com.mozzi.sns.service;


import com.mozzi.sns.domain.dto.Comment;
import com.mozzi.sns.domain.dto.Post;
import com.mozzi.sns.domain.entity.CommentEntity;
import com.mozzi.sns.domain.entity.LikeEntity;
import com.mozzi.sns.repository.CommentEntityRepository;
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

import java.util.Optional;


/**
 * packageName : com.mozzi.sns.service
 * fileName : PostService
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
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;
    private final LikeEntityRepository likeEntityRepository;
    private final CommentEntityRepository commentEntityRepository;


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
        postEntityRepository.save(PostEntity.of(title, content, hashtag, getUserEntity(userName)));
    }
    
    @Transactional
    public void modify(String title, String content, String hashtag, String userName, Long id){
        UserEntity userEntity = getUserEntity(userName);
        PostEntity postEntity = getPostEntity(id);

        if(postEntity.getUser() != getUserEntity(userName)) {
            throw new GlobalException(ErrorCode.INVALID_PERMISSION, String.format("%s has no permission", userEntity));
        }

        postEntity.setTitle(title);
        postEntity.setContent(content);
        postEntity.setHashtag(hashtag);
        postEntityRepository.save(postEntity);
    }

    @Transactional
    public void delete(String userName, Long id){
        UserEntity userEntity = getUserEntity(userName);
        PostEntity postEntity = getPostEntity(id);

        if(postEntity.getUser() != userEntity) {
            throw new GlobalException(ErrorCode.INVALID_PERMISSION, String.format("%s has no permission", userEntity));
        }
        postEntityRepository.deleteById(postEntity.getId());
    }

    @Transactional(readOnly = true)
    public Page<Post> postList(Pageable pageable){
        return postEntityRepository.findAll(pageable).map(Post::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<Post> myPost(String userName, Pageable pageable){
        return postEntityRepository.findAllByUser(getUserEntity(userName), pageable).map(Post::fromEntity);
    }


    @Transactional
    public void like(String userName, Long id){
        UserEntity userEntity = getUserEntity(userName);
        PostEntity postEntity = getPostEntity(id);

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
        return likeEntityRepository.countByPost(getPostEntity(id));
    }

    @Transactional
    public void createComment(Long id, String comment, String userName){
        commentEntityRepository.save(CommentEntity.of(getUserEntity(userName), getPostEntity(id), comment));
    }

    @Transactional(readOnly = true)
    public Page<Comment> getComments(Long id, Pageable pageable){
        return commentEntityRepository.findAllByPost(getPostEntity(id), pageable).map(Comment::fromEntity);
    }

    @Transactional
    public void deleteComment(Long id, Long commentId, String userName){
        // 게시글 확인
        getPostEntity(id);
        // 댓글조회
        CommentEntity commentEntity = commentEntityRepository.findById(commentId).orElseThrow(() ->
                new GlobalException(ErrorCode.COMMENT_NOT_FOUND, String.format("%s comment not found", id)));
        // 유저정보가 다를시
        if(!commentEntity.getUser().getUserName().equals(userName)){
            throw new GlobalException(ErrorCode.INVALID_PERMISSION, String.format("%s has no permission at comment %s", userName, commentEntity.getId()));
        }
        commentEntityRepository.delete(commentEntity);
    }



    private PostEntity getPostEntity(Long id){
        return postEntityRepository.findById(id).orElseThrow(() ->
                new GlobalException(ErrorCode.POST_NOT_FOUND, String.format("%s post not found", id)));
    }

    private UserEntity getUserEntity(String userName){
        return userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new GlobalException(ErrorCode.USER_NOT_FOUND, String.format("%s not found", userName)));
    }
}
