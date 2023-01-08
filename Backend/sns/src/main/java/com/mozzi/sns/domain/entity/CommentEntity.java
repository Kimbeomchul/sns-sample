package com.mozzi.sns.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;


/**
 * packageName : com.mozzi.sns.domain.entity
 * fileName : CommentEntity
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

@Entity
@Table(name = "\"comment\"", indexes = {
        @Index(name = "comment_post_id_idx", columnList = "post_id")
})
@Getter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @Setter
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne @Setter
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Setter
    @Column(name = "comment")
    private String comment;

    @Column(name = "registered_at")
    private Timestamp registeredAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    void registeredAt(){
        this.registeredAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt(){
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static CommentEntity of(UserEntity userEntity, PostEntity postEntity, String comment){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setPost(postEntity);
        commentEntity.setUser(userEntity);
        commentEntity.setComment(comment);
        return commentEntity;
    }
}
