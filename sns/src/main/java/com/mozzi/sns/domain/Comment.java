package com.mozzi.sns.domain;

import com.mozzi.sns.domain.entity.CommentEntity;
import com.mozzi.sns.domain.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Comment {

    private Long id;

    private Long postId;

    private String comment;

    private String userName;

    private Timestamp registeredAt;

    private Timestamp updatedAt;

    public static Comment fromEntity(CommentEntity entity) {
        return new Comment(
                entity.getId(),
                entity.getPost().getId(),
                entity.getComment(),
                entity.getUser().getUserName(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt()
        );
    }
}
