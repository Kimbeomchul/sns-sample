package com.mozzi.sns.controller.response;

import com.mozzi.sns.domain.Comment;
import com.mozzi.sns.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;


@AllArgsConstructor
@Getter
public class CommentResponse {
    private Long id;
    private Long postId;
    private String comment;
    private String userName;
    private Timestamp registeredAt;
    private Timestamp updatedAt;

    public static CommentResponse fromComment(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getPostId(),
                comment.getComment(),
                comment.getUserName(),
                comment.getRegisteredAt(),
                comment.getUpdatedAt()
        );
    }
}
