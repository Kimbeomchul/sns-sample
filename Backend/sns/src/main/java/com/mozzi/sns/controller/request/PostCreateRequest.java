package com.mozzi.sns.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class PostCreateRequest {
    @NotNull
    private String title;
    @NotNull
    private String content;
    private String hashtag;

}
