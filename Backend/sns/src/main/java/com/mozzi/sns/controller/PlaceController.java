package com.mozzi.sns.controller;

import com.mozzi.sns.controller.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/places")
@RequiredArgsConstructor
public class PlaceController {

    /**
     * TODO :: ALL PLACES
     * @return
     */
    @GetMapping
    public Response<Void> places() {
        return Response.success();
    }

}
