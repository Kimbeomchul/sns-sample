package com.mozzi.sns.service;


import com.mozzi.sns.domain.Post;
import com.mozzi.sns.domain.entity.*;
import com.mozzi.sns.exception.ErrorCode;
import com.mozzi.sns.exception.GlobalException;
import com.mozzi.sns.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionEntityRepository questionEntityRepository;


    /**
     * TODO :: 해시태그 "#" 처리
     * TODO :: 게시글 처리
     * @param email
     * @param content
     * @param type
     */
    @Transactional
    public void create(String email, String type, String content){
        questionEntityRepository.save(QuestionEntity.of(email, type, content));
    }
    
    @Transactional
    public void modify(String email, String type, String content, Long id){
        QuestionEntity questionEntity = getQuestionEntity(id);


        questionEntity.setEmail(email);
        questionEntity.setType(type);
        questionEntity.setComment(content);
        questionEntityRepository.save(questionEntity);
    }

    @Transactional
    public void delete(Long id){
        QuestionEntity questionEntity = getQuestionEntity(id);


        questionEntityRepository.delete(questionEntity);
    }

    @Transactional(readOnly = true)
    public Page<Post> postList(Pageable pageable){
        return postEntityRepository.findAll(pageable).map(Post::fromEntity);
    }

    private QuestionEntity getQuestionEntity(Long id){
        return questionEntityRepository.findById(id).orElseThrow(() ->
                new GlobalException(ErrorCode.POST_NOT_FOUND, String.format("%s post not found", id)));
    }


}
