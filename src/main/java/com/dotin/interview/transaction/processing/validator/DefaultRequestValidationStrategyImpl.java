package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.InvalidTransactionException;
import com.dotin.interview.transaction.processing.request.DefaultRequest;
import org.springframework.stereotype.Service;


@Service
public class DefaultRequestValidationStrategyImpl implements RequestValidationStrategy {
    GeneralValidator generalValidator;

    public DefaultRequestValidationStrategyImpl(GeneralValidator generalValidator) {
        this.generalValidator = generalValidator;
    }

    @Override
    public void validateTransaction(DefaultRequest request) {
        validateRequiredFields(request);
        generalValidator.validateCardExporter(request.getCardNumber());
        generalValidator.validatePassword(request.getCardNumber(), request.getPassword());
        generalValidator.validateWorkingDay(request.getTransactionDate());
        generalValidator.validateUniqueTransaction(request.getTransactionDate(), request.getTerminalType(), request.getFollowUpCode(), request.getCardNumber());
    }

    protected void validateRequiredFields(DefaultRequest request) {
        if(request.getPassword().isEmpty() || request.getFollowUpCode().isEmpty() || request.getTerminalType().isEmpty() ||
                request.getCardNumber().isEmpty() || request.getTransactionDate() == null){
            throw new InvalidTransactionException();
        }
    }
}
