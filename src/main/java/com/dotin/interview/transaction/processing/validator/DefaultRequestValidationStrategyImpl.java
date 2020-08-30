package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.*;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.DefaultRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@Qualifier
public class DefaultRequestValidationStrategyImpl implements RequestValidationStrategy {
    CardRepository cardRepository;
    TransactionRepository transactionRepository;

    public DefaultRequestValidationStrategyImpl(CardRepository cardRepository, TransactionRepository transactionRepository) {
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void validateTransaction(DefaultRequest request){
        validatePassword(request);
        validateRequiredFields(request);
        validateCardExporter(request);
        validateUniqueTransaction(request);
        validateWorkingDay(request);
    }


    protected void validateCardExporter(DefaultRequest request) {
        if (!request.getCardNumber().matches("^[1-9]{16}") || cardRepository.findByCardNumber(request.getCardNumber()) == null) {
            throw new InvalidCardExporter();
        }
    }


    protected void validatePassword(DefaultRequest request) {
        if (request.getPassword().matches("^[1-9]{4}") ||
                !cardRepository.findByCardNumber(request.getCardNumber())
                .getCardPassword().equals(request.getPassword())) {
            throw new InvalidPasswordException();
        }
    }


    protected void validateWorkingDay(DefaultRequest request) {
        Calendar today = Calendar.getInstance();
        Calendar requestDay = Calendar.getInstance();
        Date todayDate = new Date();
        today.setTime(todayDate);
        requestDay.setTime(request.getTransactionDate());

        if (today.get(Calendar.YEAR) != requestDay.get(Calendar.YEAR) ||
                today.get(Calendar.DAY_OF_YEAR) != requestDay.get(Calendar.DAY_OF_YEAR)) {
            throw new InvalidWorkingDayException();
        }

    }


    protected void validateUniqueTransaction(DefaultRequest request) {
        if(transactionRepository.findDuplicateTransaction(request.getFollowUpCode(),
                request.getCardNumber(),
                request.getTransactionDate(),
                request.getTerminalType()) != null){
            throw new DuplicateTransaction();
        }

    }


    protected void validateRequiredFields(DefaultRequest request) {
        if(request.getPassword().isEmpty() || request.getFollowUpCode().isEmpty() || request.getTerminalType().isEmpty() ||
                request.getCardNumber().isEmpty() || request.getTransactionDate() == null){
            throw new InvalidTransactionException();
        }
    }
}
