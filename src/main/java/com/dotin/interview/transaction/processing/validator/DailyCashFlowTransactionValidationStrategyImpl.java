package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.ProcessingTransactionProblem;
import com.dotin.interview.transaction.processing.request.Request;
import org.springframework.stereotype.Service;

@Service
public class DailyCashFlowTransactionValidationStrategyImpl extends DefaultRequestValidationStrategyImpl {


    public DailyCashFlowTransactionValidationStrategyImpl(GeneralValidator generalValidator) {
        super(generalValidator);
    }

    @Override
    public void validateTransaction(Request request) {
        super.validateTransaction(request);
        validateDailyCashFlowRequiredFields(request);
    }

    private void validateDailyCashFlowRequiredFields(Request request) {
        if (request.getStartDateOfTransaction() == null || request.getEndDateOfTransaction() == null || request.getStartDateOfTransaction().after(request.getEndDateOfTransaction()))
            throw new ProcessingTransactionProblem();
    }

}
