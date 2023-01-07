package com.mozzi.sns.domain;

import com.mozzi.sns.domain.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Post {

    private Long id;
    private String title;

    private String body;

    private User user;

    private Timestamp registeredAt;

    private Timestamp updatedAt;

    private Timestamp removedAt;

    public static Post fromEntity(PostEntity entity) {
        return new Post(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                User.fromEntity(entity.getUser()),
                entity.getRegisteredAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt()
        );
    }
}
