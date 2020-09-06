package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.ProcessingTransactionProblem;
import com.dotin.interview.transaction.processing.request.DailyCashFlowTransactionRequest;
import com.dotin.interview.transaction.processing.request.DefaultRequest;
import org.springframework.stereotype.Service;

@Service
public class DailyCashFlowTransactionValidationStrategyImpl extends DefaultRequestValidationStrategyImpl {


    public DailyCashFlowTransactionValidationStrategyImpl(GeneralValidator generalValidator) {
        super(generalValidator);
    }

    @Override
    public void validateTransaction(DefaultRequest request) {
        super.validateTransaction(request);
        if (request instanceof DailyCashFlowTransactionRequest) {
            DailyCashFlowTransactionRequest dailyCashFlowTransactionRequest = (DailyCashFlowTransactionRequest) request;
            validateDailyCashflowRequiredFields(dailyCashFlowTransactionRequest);
        }
    }

    private void validateDailyCashflowRequiredFields(DailyCashFlowTransactionRequest request) {
        if (request.getStartDate() == null || request.getEndDate() == null || request.getStartDate().after(request.getEndDate()))
            throw new ProcessingTransactionProblem();
    }

}
