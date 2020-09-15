package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.request.Request;
import org.springframework.stereotype.Service;

@Service
public class CarToCartTransactionValidationStrategyImpl extends DefaultRequestValidationStrategyImpl {

    public CarToCartTransactionValidationStrategyImpl(GeneralValidator generalValidator) {
        super(generalValidator);
    }

    public void validateTransaction(Request request) {
        super.validateTransaction(request);
        generalValidator.validateHolding(request.getCardNumber(), request.getAmount());

    }
}