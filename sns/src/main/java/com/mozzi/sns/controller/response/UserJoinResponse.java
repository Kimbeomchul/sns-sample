package com.mozzi.sns.controller.response;

import com.mozzi.sns.controller.request.UserJoinRequest;
import com.mozzi.sns.domain.User;
import com.mozzi.sns.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserJoinResponse {
    private Long id;
    private String userName;
    private UserRole role;

    public static UserJoinResponse fromUser(User user){
        return new UserJoinResponse(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );
    }
}
