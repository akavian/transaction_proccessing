package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.request.Request;

public interface RequestValidationStrategy {

    void validateTransaction(Request request);
}
