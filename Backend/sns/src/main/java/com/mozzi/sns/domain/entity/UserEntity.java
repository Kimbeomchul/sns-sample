package com.mozzi.sns.domain.entity;

import com.mozzi.sns.domain.UserLive;
import com.mozzi.sns.domain.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


/**
 * packageName : com.mozzi.sns.domain.entity
 * fileName : UserEntity
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

@Entity
@Table(name ="\"user\"", indexes = {
        @Index(name = "user_user_name_idx", columnList = "user_name")
})
@Getter
@SQLDelete(sql = "UPDATE \"user\" SET deleted_yn = 'Y' WHERE id = ?")
@Where(clause = "deleted_yn = 'N'")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name") @Setter
    private String userName; // 회원아이디

    @Column(name = "password") @Setter
    private String password; // 비밀번호

    @Column(name = "nickname") @Setter
    private String nickname; // 닉네임

    @ColumnDefault("defaultURL")
    @Column(name = "user_image") @Setter
    private String userImage = "defaultURL"; // 유저이미지

    @Column(name = "living_at")
    @Enumerated(EnumType.STRING)
    private UserLive livingAt = UserLive.None; // 사는곳

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER; // 유저 권한

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<PostEntity> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<LikeEntity> likes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
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

    public static UserEntity of(String userName, String password, String nickname, String userImage){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(password);
        userEntity.setNickname(nickname);
        userEntity.setUserImage(userImage);
        return userEntity;
    }
}
