package com.mozzi.sns.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * packageName : com.mozzi.sns.domain.entity
 * fileName : PostEntity
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */


@Entity
@Table(name = "\"post\"", indexes = {
        @Index(name = "post_user_id_idx", columnList = "user_id")
})
@Getter
@SQLDelete(sql = "UPDATE \"post\" SET deleted_yn = 'Y' WHERE id = ?")
@Where(clause = "deleted_yn = 'N'")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "title")
    private String title;

    @Setter
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Setter
    @Column(name = "category")
    private String category;

    @ManyToOne @Setter
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", orphanRemoval = true)
    private List<LikeEntity> likes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", orphanRemoval = true)
    private List<CommentEntity> comments;

    @Column(name = "registered_at")
    private Timestamp registeredAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_yn")
    private String deletedYn = "N";

    @PrePersist
    void registeredAt(){
        this.registeredAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt(){
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static PostEntity of(String title, String content,String category, UserEntity userEntity){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setContent(content);
        postEntity.setCategory(category);
        postEntity.setUser(userEntity);
        return postEntity;
    }
}
