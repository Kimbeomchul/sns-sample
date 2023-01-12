package com.mozzi.sns.service;


import com.mozzi.sns.domain.PlaceType;
import com.mozzi.sns.domain.dto.Place;
import com.mozzi.sns.domain.entity.*;
import com.mozzi.sns.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * packageName : com.mozzi.sns.service
 * fileName : PlaceService
 * author : myoungjinkang
 * date : 2023/01/12
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/12 myoungjinkang 최초 생성
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceEntityRepository placeEntityRepository;



    /**
     * TODO :: 장소 생성
     */
    @Transactional
    public void create(String placeName, String placePhone, PlaceType placeType, String openInfo, String latitude, String longitude, String detail){
        placeEntityRepository.save(PlaceEntity.of(placeName, placePhone, placeType, openInfo,latitude,longitude,detail));
    }

    @Transactional(readOnly = true)
    public Page<Place> placeList(Pageable pageable){
        return placeEntityRepository.findAll(pageable).map(Place::fromEntity);
    }
}
