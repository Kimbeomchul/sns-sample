package com.mozzi.sns.controller.request;


import com.mozzi.sns.domain.PlaceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class PlaceCreateRequest {

    private String placeName; // 상점명

    private String placePhone; // 상점전화번호

    private PlaceType placeType; // 상점 종류

    private String openInfo; // 오픈/마감 시간

    private String latitude; // 위도

    private String longitude; // 경도

    private String detail; // 상세 정보
}
