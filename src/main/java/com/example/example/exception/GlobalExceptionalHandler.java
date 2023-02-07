package com.example.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) throws Exception {
        var errorResponse = ErrorResponse.builder().errorMessage(ex.getMessage()).build();
        return new ResponseEntity<ErrorResponse>(errorResponse , HttpStatus.BAD_REQUEST);
    }
}
