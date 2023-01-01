package com.mozzi.sns.controller.response;

import com.mozzi.sns.domain.User;
import com.mozzi.sns.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginResponse {
    private String token;
}
