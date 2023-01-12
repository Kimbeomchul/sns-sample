package com.mozzi.sns.domain.dto;

import com.mozzi.sns.domain.PlaceType;
import com.mozzi.sns.domain.entity.PlaceEntity;
import com.mozzi.sns.domain.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Place {

    private Long id;

    private String placeName; // 상점명

    private String placePhone; // 상점전화번호

    private PlaceType placeType; // 상점 종류

    private String openInfo; // 오픈/마감 시간

    private String latitude; // 위도

    private String longitude; // 경도

    private String detail; // 상세 설명

    private Timestamp registeredAt;

    private Timestamp updatedAt;


    public static Place fromEntity(PlaceEntity entity) {
        return new Place(
                entity.getId(),
                entity.getPlaceName(),
                entity.getPlacePhone(),
                entity.getPlaceType(),
                entity.getOpenInfo(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getDetail(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt()
        );
    }
}
