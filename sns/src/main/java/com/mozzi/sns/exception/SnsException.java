package com.mozzi.sns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SnsException extends RuntimeException{

    private ErrorCode errorCode;
    private String message;

    public SnsException(ErrorCode errorCode){
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
