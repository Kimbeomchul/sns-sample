package com.mozzi.sns.exception;


import com.mozzi.sns.controller.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * packageName : com.mozzi.sns.exception
 * fileName : GlobalControllerAdvice
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<?> applicationHandler (GlobalException e){
        log.error("Error = ::: {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(Response.error(e.getErrorCode().name()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validExceptionHandler(MethodArgumentNotValidException e){
        log.error("Error = ::: {}", e.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Request Not Valid"));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler (RuntimeException e){
        log.error("Error = ::: {}", e.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Response.error(ErrorCode.INTERNAL_SERVER_ERROR.name()));
    }
}
