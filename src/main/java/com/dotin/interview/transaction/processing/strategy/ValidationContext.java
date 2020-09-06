package com.dotin.interview.transaction.processing.strategy;

import com.dotin.interview.transaction.processing.request.DefaultRequest;
import com.dotin.interview.transaction.processing.validator.RequestValidationStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class ValidationContext {
   private RequestValidationStrategy strategy;

    public ValidationContext(RequestValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RequestValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public void validate(DefaultRequest request) {
         strategy.validateTransaction(request);
    }
}
