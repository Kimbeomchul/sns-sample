package com.mozzi.sns.exception;


import com.mozzi.sns.SnsApplication;
import com.mozzi.sns.controller.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(SnsException.class)
    public ResponseEntity<?> applicationHandler (SnsException e){
        log.error("Error = ::: {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(Response.error(e.getErrorCode().name()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHanlder (RuntimeException e){
        log.error("Error = ::: {}", e.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Response.error(ErrorCode.INTERNAL_SERVER_ERROR.name()));
    }
}
