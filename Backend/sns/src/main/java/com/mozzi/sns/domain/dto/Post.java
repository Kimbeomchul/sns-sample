package com.mozzi.sns.domain.dto;

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
    private String category;
    private User user;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private String deletedYn;


    public static Post fromEntity(PostEntity entity) {
        return new Post(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCategory(),
                User.fromEntity(entity.getUser()),
                entity.getRegisteredAt(),
                entity.getUpdatedAt(),
                entity.getDeletedYn()
        );
    }
}
