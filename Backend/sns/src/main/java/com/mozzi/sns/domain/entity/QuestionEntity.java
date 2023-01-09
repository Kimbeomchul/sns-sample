package com.mozzi.sns.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"question\"")
@Getter
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "email")
    private String email;

    @Setter
    @Column(name = "type")
    private String type;

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

    public static QuestionEntity of(String email,String type, String comment){
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setEmail(email);
        questionEntity.setType(type);
        questionEntity.setComment(comment);
        return questionEntity;
    }
}
