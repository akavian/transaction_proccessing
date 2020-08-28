package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.request.Request;

public interface RequestValidator<T> {

    void validateTransaction(T request);

    void validateCardExporter(T request);

    void validatePassword(T request);
    
    void validateWorkingDay(T request);

    void validateUniqueTransaction(T request);

    void validateRequiredFields(T request);

}
