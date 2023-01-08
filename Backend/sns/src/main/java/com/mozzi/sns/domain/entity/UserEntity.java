package com.mozzi.sns.domain.entity;

import com.mozzi.sns.domain.UserLive;
import com.mozzi.sns.domain.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name ="\"user\"", indexes = {
        @Index(name = "user_user_name_idx", columnList = "user_name")
})
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName; // 회원아이디

    @Column(name = "password")
    private String password; // 비밀번호

    @Column(name = "nickname")
    private String nickname; // 닉네임

    @Column(name = "user_image")
    private String userImage; // 유저이미지

    @Column(name = "living_at")
    @Enumerated(EnumType.STRING)
    private UserLive livingAt = UserLive.None; // 사는곳

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER; // 유저 권한

    @Column(name = "registered_at")
    private Timestamp registeredAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

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
        if(userImage == null){
            userEntity.setUserImage("defaultURL");
        }else{
            userEntity.setUserImage(userImage);
        }
        return userEntity;
    }
}
