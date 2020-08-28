package com.dotin.interview.transaction.processing.validator;

public interface FinancialRequestValidator <T> {

    void validateAmount(T request);
}
