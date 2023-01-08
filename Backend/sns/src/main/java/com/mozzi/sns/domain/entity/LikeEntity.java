package com.mozzi.sns.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * packageName : com.mozzi.sns.domain.entity
 * fileName : LikeEntity
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */


@Entity
@Table(name = "\"like\"", indexes = {
        @Index(name = "like_user_id_idx", columnList = "user_id"),
        @Index(name = "like_post_id_idx", columnList = "post_id")
})
@Getter
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @Setter
    @Where(clause = "deleted_yn = 'N'")
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne @Setter
    @Where(clause = "deleted_yn = 'N'")
    @JoinColumn(name = "post_id")
    private PostEntity post;
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

    public static LikeEntity of(UserEntity userEntity, PostEntity postEntity){
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setPost(postEntity);
        likeEntity.setUser(userEntity);
        return likeEntity;
    }
}
