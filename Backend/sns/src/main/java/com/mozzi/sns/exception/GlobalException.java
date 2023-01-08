package com.mozzi.sns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName : com.mozzi.sns.exception
 * fileName : GlobalException
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
public class GlobalException extends RuntimeException{

    private ErrorCode errorCode;
    private String message;

    public GlobalException(ErrorCode errorCode){
        this.errorCode = errorCode;
        this.message = null;
    }

    @Override
    public String getMessage() {
        if(message == null) {
            return errorCode.getMessage();
        }
        return String.format("%s :: %s", errorCode.getMessage(), message);
    }
}
