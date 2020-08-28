package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.*;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import com.dotin.interview.transaction.processing.request.Request;

import java.util.Calendar;
import java.util.Date;

public class RequestValidatorImpl<T extends Request> implements RequestValidator<T> {
    CardRepository cardRepository;
    TransactionRepository transactionRepository;

    public RequestValidatorImpl(CardRepository cardRepository, TransactionRepository transactionRepository) {
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void validateTransaction(T request){
        validatePassword(request);
        validateRequiredFields(request);
        validateCardExporter(request);
        validateUniqueTransaction(request);
        validateWorkingDay(request);
    }

    @Override
    public void validateCardExporter(T request) {
        if (!request.getCardNumber().matches("[1-9]{16}") || cardRepository.findByCardNumber(request.getCardNumber()) == null) {
            throw new InvalidCardExporter();
        }
    }

    @Override
    public void validatePassword(T request) {
        if (request.getPassword().matches("[1-9]{4}") ||
                !cardRepository.findByCardNumber(request.getCardNumber())
                .getCardPassword().equals(request.getPassword())) {
            throw new InvalidPasswordException();
        }
    }

    @Override
    public void validateWorkingDay(T request) {
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

    @Override
    public void validateUniqueTransaction(T request) {
        if(transactionRepository.findDuplicateTransaction(request.getFollowUpCode(),
                request.getCardNumber(),
                request.getTransactionDate(),
                request.getTerminalType()) != null){
            throw new DuplicateTransaction();
        }

    }

    @Override
    public void validateRequiredFields(T request) {
        if(request.getPassword().isEmpty() || request.getFollowUpCode().isEmpty() || request.getTerminalType().isEmpty() ||
                request.getCardNumber().isEmpty() || request.getTransactionDate() == null){
            throw new InvalidTransactionException();
        }
    }
}
