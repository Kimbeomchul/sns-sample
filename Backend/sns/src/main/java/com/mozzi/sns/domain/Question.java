package com.mozzi.sns.domain;

import com.mozzi.sns.domain.entity.PostEntity;
import com.mozzi.sns.domain.entity.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Question {

    private Long id;
    private String email;

    private String type;

    private String content;

    private String deleteYn;

    private Timestamp registeredAt;

    private Timestamp updatedAt;

    public static Question fromEntity(QuestionEntity entity) {
        return new Question(
                entity.getId(),
                entity.getEmail(),
                entity.getType(),
                entity.getComment(),
                entity.getType(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt()
        );
    }
}
