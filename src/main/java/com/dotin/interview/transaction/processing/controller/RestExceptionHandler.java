package com.dotin.interview.transaction.processing.controller;

import com.dotin.interview.transaction.processing.exception.InvalidCardExporter;
import com.dotin.interview.transaction.processing.response.DefaultResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public DefaultResponse getInvalidCardExportetException(InvalidCardExporter exception, WebRequest request){
       // request.

        return null;
    }

}
