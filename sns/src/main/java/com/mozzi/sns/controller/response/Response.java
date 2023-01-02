package com.mozzi.sns.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class Response<T> {

    private String resultCode;
    private T data;

    public static <T> Response<Void> error(String code){
        return new Response<>(code, null);
    }

    public static <T> Response<T> success(T data){
        return new Response<>(HttpStatus.OK.getReasonPhrase() , data);
    }

}
