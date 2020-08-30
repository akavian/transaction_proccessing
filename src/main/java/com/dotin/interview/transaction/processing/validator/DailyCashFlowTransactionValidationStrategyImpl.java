package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.InsufficientAmountException;
import com.dotin.interview.transaction.processing.exception.InvalidTransactionException;
import com.dotin.interview.transaction.processing.repository.AccountRepository;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.DailyCashFlowTransactionRequest;
import com.dotin.interview.transaction.processing.request.DefaultRequest;
import org.springframework.stereotype.Component;

@Component
public class DailyCashFlowTransactionValidationStrategyImpl<T extends DailyCashFlowTransactionRequest> extends DefaultRequestValidationStrategyImpl{
    AccountRepository accountRepository;

    public DailyCashFlowTransactionValidationStrategyImpl(CardRepository cardRepository, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        super(cardRepository, transactionRepository);
        this.accountRepository = accountRepository;
    }

    @Override
    public void validateTransaction(DefaultRequest request) {
        super.validateTransaction(request);
        validateRequiredFields(request);
        if (request instanceof DailyCashFlowTransactionRequest) {
            DailyCashFlowTransactionRequest dailyCashFlowTransactionRequest = (DailyCashFlowTransactionRequest) request;
            validateAmount(dailyCashFlowTransactionRequest);
            validateRequiredDailyCashFlowFields(dailyCashFlowTransactionRequest);
        }
    }


    private void validateRequiredDailyCashFlowFields(DailyCashFlowTransactionRequest request) {
        if (request.getStartDate() == null || request.getEndDate() == null || request.getStartDate().after(request.getEndDate()))
            throw new InvalidTransactionException();
    }

    private void validateAmount(DailyCashFlowTransactionRequest request) {
        if (accountRepository.findByAccountNumber(cardRepository.findByCardNumber(request.getCardNumber()).getMainAccount()).getAmount() < 1000) {
            throw new InsufficientAmountException();
        }
    }
}
