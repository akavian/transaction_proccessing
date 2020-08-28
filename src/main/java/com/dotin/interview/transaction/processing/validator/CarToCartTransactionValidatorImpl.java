package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.InsufficientAmountException;
import com.dotin.interview.transaction.processing.exception.InvalidTransactionException;
import com.dotin.interview.transaction.processing.repository.AccountRepository;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.CartToCartTransactionRequest;

public class CarToCartTransactionValidatorImpl<T extends CartToCartTransactionRequest> extends RequestValidatorImpl<T> implements FinancialRequestValidator<T>{
    AccountRepository accountRepository;

    public CarToCartTransactionValidatorImpl(CardRepository cardRepository, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        super(cardRepository, transactionRepository);
        this.accountRepository = accountRepository;
    }

    @Override
    public void validateTransaction(T request) {
        super.validateTransaction(request);
        validateAmount(request);
        validateRequiredFields(request);

    }

    @Override
    public void validateAmount(T request) {
        if(request.getAmount() > accountRepository.findByAccountNumber(cardRepository.findByCardNumber(request.getCardNumber()).getMainAccount()).getAmount()){
            throw new InsufficientAmountException();
        }
    }

    @Override
    public void validateRequiredFields(T request){
        if(request.getDestinationCardNumber().isEmpty() || request.getAmount() < 50000){
            throw new InvalidTransactionException();
        }
    }


}
