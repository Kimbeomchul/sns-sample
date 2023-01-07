package com.mozzi.sns.controller.response;

import com.mozzi.sns.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;


@AllArgsConstructor
@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String body;
    private UserResponse user;
    private Timestamp registeredAt;
    private Timestamp updatedAt;

    public static PostResponse fromPost(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getBody(),
                UserResponse.fromUser(post.getUser()),
                post.getRegisteredAt(),
                post.getUpdatedAt()
        );
    }
}
