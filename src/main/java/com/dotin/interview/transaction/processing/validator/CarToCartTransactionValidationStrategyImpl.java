package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.InsufficientAmountException;
import com.dotin.interview.transaction.processing.exception.InvalidTransactionException;
import com.dotin.interview.transaction.processing.repository.AccountRepository;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.CartToCartTransactionRequest;
import com.dotin.interview.transaction.processing.request.DefaultRequest;
import org.springframework.stereotype.Component;

@Component
public class CarToCartTransactionValidationStrategyImpl extends DefaultRequestValidationStrategyImpl {
    AccountRepository accountRepository;

    public CarToCartTransactionValidationStrategyImpl(CardRepository cardRepository, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        super(cardRepository, transactionRepository);
        this.accountRepository = accountRepository;
    }

    @Override
    public void validateTransaction(DefaultRequest request) {
        super.validateTransaction(request);
        if (request instanceof CartToCartTransactionRequest) {
            CartToCartTransactionRequest cartToCartTransactionRequest = (CartToCartTransactionRequest) request;
            validateAmount(cartToCartTransactionRequest);
            validateRequiredFields(cartToCartTransactionRequest);
        }
    }


    private void validateRequiredCartToCartTransactionRequestFields(CartToCartTransactionRequest request) {
        if (request.getDestinationCardNumber().isEmpty() || request.getAmount() < 50000) {
            throw new InvalidTransactionException();
        }
    }

    private void validateAmount(CartToCartTransactionRequest request) {
        if (request.getAmount() > accountRepository.findByAccountNumber(cardRepository.findByCardNumber(request.getCardNumber()).getMainAccount()).getAmount()) {
            throw new InsufficientAmountException();
        }
    }


}
