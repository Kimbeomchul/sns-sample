package com.mozzi.sns.domain.entity;

import com.mozzi.sns.domain.PlaceType;
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
 * fileName : PlaceEntity
 * author : kimbeomchul
 * date : 2023/01/09
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */


@Entity
@Table(name = "\"place\"")
@Getter
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name")
    private String placeName; // 상점명

    @Setter
    @Column(name = "phone")
    private String placePhone; // 상점전화번호

    @Setter
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PlaceType placeType; // 상점 종류

    @Setter
    @Column(name = "open_info")
    private String openInfo; // 오픈/마감 시간

    @Setter
    @Column(name = "latitude")
    private String latitude; // 위도

    @Setter
    @Column(name = "longitude")
    private String longitude; // 경도

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place", orphanRemoval = true)
    private List<PlaceLikeEntity> placeLikes;

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

    public static PlaceEntity of(String placeName, String placePhone, PlaceType placeType, String openInfo, String latitude, String longitude){
        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setPlaceName(placeName);
        placeEntity.setPlacePhone(placePhone);
        placeEntity.setPlaceType(placeType);
        placeEntity.setOpenInfo(openInfo);
        placeEntity.setLatitude(latitude);
        placeEntity.setLongitude(longitude);
        return placeEntity;
    }
}
