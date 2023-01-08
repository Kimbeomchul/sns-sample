package com.mozzi.sns.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionCreateRequest {

    private String email;
    private String type;
    private String content;

}
