package com.mozzi.sns.domain.entity;

import com.mozzi.sns.domain.PhotoType;
import com.mozzi.sns.domain.PlaceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * packageName : com.mozzi.sns.domain.entity
 * fileName : PhotoEntity
 * author : kimbeomchul
 * date : 2023/01/13
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/13 kimbeomchul 최초 생성
 */


@Entity
@Table(name = "\"photo\"")
@Getter
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PhotoType photoType = PhotoType.PLACE; // 사진 종류 default place

    @Setter
    @Column(name = "title_photo")
    private String titlePhoto; // 타이틀 사진

    @Setter
    @Column(name = "sub_photo1")
    private String subPhoto1; // 서브사진

    @Setter
    @Column(name = "sub_photo2")
    private String subPhoto2; // 서브사진

    @Setter
    @Column(name = "sub_photo3")
    private String subPhoto3; // 서브사진

    @Setter
    @Column(name = "sub_photo4")
    private String subPhoto4; // 서브사진

    @Setter
    @Column(name = "sub_photo5")
    private String subPhoto5; // 서브사진

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

    public static PhotoEntity of(PhotoType photoType, String titlePhoto, String subPhoto1, String subPhoto2, String subPhoto3, String subPhoto4, String subPhoto5){
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setPhotoType(photoType);
        photoEntity.setTitlePhoto(titlePhoto);
        photoEntity.setSubPhoto1(subPhoto1);
        photoEntity.setSubPhoto2(subPhoto2);
        photoEntity.setSubPhoto3(subPhoto3);
        photoEntity.setSubPhoto4(subPhoto4);
        photoEntity.setSubPhoto5(subPhoto5);
        return photoEntity;
    }
}
