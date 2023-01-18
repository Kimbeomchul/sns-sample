package com.mozzi.sns.controller;

import com.mozzi.sns.controller.request.UserJoinRequest;
import com.mozzi.sns.controller.request.UserLoginRequest;
import com.mozzi.sns.controller.response.Response;
import com.mozzi.sns.controller.response.UserJoinResponse;
import com.mozzi.sns.controller.response.UserLoginResponse;
import com.mozzi.sns.controller.response.UserResponse;
import com.mozzi.sns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원조회
    @GetMapping
    public Response<UserResponse> user(Authentication authentication){
        return Response.success(UserResponse.fromUser(userService.user(authentication.getName())));
    }

    // 회원가입
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@Valid @RequestBody UserJoinRequest request){
        return Response.success(UserJoinResponse.fromUser(userService.join(request.getUserName(), request.getPassword())));
    }

    // 로그인
    @PostMapping("/login")
    public Response<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest request){
        return Response.success(new UserLoginResponse(userService.login(request.getUserName(), request.getPassword())));
    }

    // 회원탈퇴
    @DeleteMapping
    public Response<Void> delete(Authentication authentication){
        userService.withdrawal(authentication.getName());
        return Response.success();
    }

    // 회원중복조회
    @GetMapping("/{id}/duplicate")
    public Response<UserResponse> duplicate(@PathVariable String id){
        return Response.success(UserResponse.fromUser(userService.user(id)));
    }

    // 소셜로그인 ( 카카오 )
    @GetMapping("/auth/kakao/callback")
    public Response<String> kakaoUser(@RequestParam("code") String code){
        return Response.success(userService.kakaoToken(code));
    }

    // 소셜로그인 ( 네이버 )
    @GetMapping("/auth/naver/callback")
    public Response<String> naverUser(@RequestParam("code") String code){
        return Response.success(userService.naverToken(code));
    }
}
