package com.mozzi.sns.controller;

import com.mozzi.sns.controller.request.PlaceCreateRequest;
import com.mozzi.sns.controller.response.PlaceResponse;
import com.mozzi.sns.controller.response.Response;
import com.mozzi.sns.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    /**
     * 장소 조회
     */
    @GetMapping
    public Response<Page<PlaceResponse>> placeList(Pageable pageable){
        return Response.success(placeService.placeList(pageable).map(PlaceResponse::fromPlace));
    }

    /**
     * 장소 입력
     */
    @PostMapping
    public Response<Void> create(@Valid @RequestBody PlaceCreateRequest request){
        placeService.create(request.getPlaceName(), request.getPlacePhone(), request.getPlaceType(), request.getOpenInfo(),request.getLatitude(),request.getLongitude(),request.getDetail());
        return Response.success();
    }

}
