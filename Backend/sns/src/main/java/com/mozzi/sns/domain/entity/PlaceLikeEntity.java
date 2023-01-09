package com.mozzi.sns.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * packageName : com.mozzi.sns.domain.entity
 * fileName : PlaceLikeEntity
 * author : kimbeomchul
 * date : 2023/01/09
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */


@Entity
@Table(name = "\"place_like\"")
@Getter
public class PlaceLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @Setter
    @Where(clause = "deleted_yn = 'N'")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne @Setter
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @PrePersist
    void registeredAt(){
        this.registeredAt = Timestamp.from(Instant.now());
    }

    public static PlaceLikeEntity of(UserEntity userEntity, PlaceEntity placeEntity){
        PlaceLikeEntity placeLikeEntity = new PlaceLikeEntity();
        placeLikeEntity.setPlace(placeEntity);
        placeLikeEntity.setUser(userEntity);
        return placeLikeEntity;
    }
}
