package com.mozzi.sns.controller.response;

import com.mozzi.sns.domain.Post;
import com.mozzi.sns.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;


@AllArgsConstructor
@Getter
public class QuestionResponse {
    private Long id;
    private String email;
    private String type;
    private String content;
    private String deleteYn;
    private Timestamp registeredAt;
    private Timestamp updatedAt;

    public static QuestionResponse fromPost(Question post) {
        return new QuestionResponse(
                post.getId(),
                post.getEmail(),
                post.getType(),
                post.getContent(),
                post.getDeleteYn(),
                post.getRegisteredAt(),
                post.getUpdatedAt()
        );
    }
}
