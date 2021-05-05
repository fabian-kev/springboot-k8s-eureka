package com.fabiankevin.player.playerservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> apiException(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ApiExceptionResource.builder()
                            .description(e.getMessage())
                            .build()
            );
    }
}
