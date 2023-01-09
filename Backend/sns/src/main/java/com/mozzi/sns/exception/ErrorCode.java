package com.mozzi.sns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * packageName : com.mozzi.sns.exception
 * fileName : ErrorCode
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "User name is duplicated"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not founded"),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "Password is invalid"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR ,"Internal Server Error"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid token"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post not found"),
    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND, "Question not found"),
    INVALID_PERMISSION(HttpStatus.UNAUTHORIZED, "Permission invalid"),

    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Comment not found");

    private HttpStatus status;
    private String message;

}
