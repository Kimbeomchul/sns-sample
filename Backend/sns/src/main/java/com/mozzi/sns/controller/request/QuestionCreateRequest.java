package com.mozzi.sns.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class QuestionCreateRequest {

    @NotNull
    private String email;
    @NotNull
    private String type;
    @NotNull
    private String content;

}
