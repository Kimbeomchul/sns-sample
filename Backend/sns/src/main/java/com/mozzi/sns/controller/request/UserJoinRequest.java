package com.mozzi.sns.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class UserJoinRequest {
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
