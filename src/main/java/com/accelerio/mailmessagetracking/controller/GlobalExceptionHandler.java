package com.accelerio.mailmessagetracking.controller;

import com.accelerio.mailmessagetracking.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleExceptions(RuntimeException exception, WebRequest webRequest) {
        ErrorDTO error=new ErrorDTO();
        error.setMessage(exception.getMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        return entity;
    }
}
