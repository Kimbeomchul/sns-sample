package com.mozzi.sns.controller.response;

import com.mozzi.sns.domain.dto.User;
import com.mozzi.sns.domain.UserLive;
import com.mozzi.sns.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String userName;
    private String nickname;
    private String userImage;
    private UserLive livingAt;
    private UserRole role;
    public static UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getNickname(),
                user.getUserImage(),
                user.getLivingAt(),
                user.getRole()
        );
    }
}
