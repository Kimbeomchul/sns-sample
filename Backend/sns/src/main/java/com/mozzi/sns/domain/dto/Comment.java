package com.mozzi.sns.domain.dto;

import com.mozzi.sns.domain.entity.CommentEntity;
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
