package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.InsufficientAmountException;
import com.dotin.interview.transaction.processing.exception.InvalidTransactionException;
import com.dotin.interview.transaction.processing.repository.AccountRepository;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.DailyCashFlowTransactionRequest;
import com.dotin.interview.transaction.processing.request.Request;

import java.util.Date;

public class DailyCashFlowTransactionValidatorImpl<T extends DailyCashFlowTransactionRequest> extends RequestValidatorImpl<T> implements FinancialRequestValidator<T> {
    AccountRepository accountRepository;

    public DailyCashFlowTransactionValidatorImpl(CardRepository cardRepository, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        super(cardRepository, transactionRepository);
        this.accountRepository = accountRepository;
    }

    public void validateTransaction(T request){
        super.validateTransaction(request);
        validateRequiredFields(request);
        validateAmount(request);
    }




    @Override
    public void validateAmount(T request){
        if(accountRepository.findByAccountNumber(cardRepository.findByCardNumber(request.getCardNumber()).getMainAccount()).getAmount() < 1000){
            throw new InsufficientAmountException();
        }
    }

    @Override
    public void validateRequiredFields(T request){
        if(request.getStartDate() == null || request.getEndDate() == null || request.getStartDate().after(request.getEndDate()))
            throw new InvalidTransactionException();
    }
}
