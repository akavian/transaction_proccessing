package com.dotin.interview.transaction.processing.controller;

import com.dotin.interview.transaction.processing.response.DefaultResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public DefaultResponse exeptionD(Exception exception){
        return null;
    }

}
