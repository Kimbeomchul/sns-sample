package com.mozzi.sns.controller.response;

import com.mozzi.sns.domain.PlaceType;
import com.mozzi.sns.domain.dto.Place;
import com.mozzi.sns.domain.dto.Post;
import com.mozzi.sns.domain.entity.PlaceEntity;
import com.mozzi.sns.domain.entity.PlaceLikeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@AllArgsConstructor
@Getter
public class PlaceResponse {

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

    public static PlaceResponse fromPlace(Place place) {
        return new PlaceResponse(
                place.getId(),
                place.getPlaceName(),
                place.getPlacePhone(),
                place.getPlaceType(),
                place.getOpenInfo(),
                place.getLatitude(),
                place.getLongitude(),
                place.getDetail(),
                place.getRegisteredAt(),
                place.getUpdatedAt()
        );
    }
}
