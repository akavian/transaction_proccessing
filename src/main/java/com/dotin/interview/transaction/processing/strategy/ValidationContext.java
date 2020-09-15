package com.dotin.interview.transaction.processing.strategy;

import com.dotin.interview.transaction.processing.request.Request;
import com.dotin.interview.transaction.processing.validator.RequestValidationStrategy;

public class ValidationContext {
   private RequestValidationStrategy strategy;

    public ValidationContext(RequestValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RequestValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public void validate(Request request) {
         strategy.validateTransaction(request);
    }
}
