package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.request.CartToCartTransactionRequest;
import com.dotin.interview.transaction.processing.request.DefaultRequest;
import org.springframework.stereotype.Service;

@Service
public class CarToCartTransactionValidationStrategyImpl extends DefaultRequestValidationStrategyImpl {
    public CarToCartTransactionValidationStrategyImpl(GeneralValidator generalValidator) {
        super(generalValidator);
    }

    public void validateTransaction(DefaultRequest request) {
        super.validateTransaction(request);
        if (request instanceof CartToCartTransactionRequest) {
            CartToCartTransactionRequest cartToCartTransactionRequest = (CartToCartTransactionRequest) request;
            generalValidator.validateHolding(cartToCartTransactionRequest.getCardNumber(), cartToCartTransactionRequest.getAmount());
        }
    }
}