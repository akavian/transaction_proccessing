package com.dotin.interview.transaction.processing.controller;

import com.dotin.interview.transaction.processing.request.Request;
import com.dotin.interview.transaction.processing.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public Response exeptionD(Exception exception){
        return null;
    }

}
