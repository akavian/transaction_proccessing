package com.dotin.interview.transaction.processing.validator;

import com.dotin.interview.transaction.processing.exception.*;
import com.dotin.interview.transaction.processing.repository.CardRepository;
import com.dotin.interview.transaction.processing.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

@Service
public class GeneralValidator {
    private final TransactionRepository transactionRepository;
    private final CardRepository cardRepository;


    public GeneralValidator(TransactionRepository transactionRepository, CardRepository cardRepository) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
    }

    public void validateCardExporter(String cardNumber) {
        if (!cardNumber.matches("^[1-9]{16}"))
            throw new InvalidCardExporter();
        else {
            if (cardRepository.findByCardNumber(cardNumber) == null)
                throw new InvalidCardExporter();

        }
    }

    public void validatePassword(String cardNumber, String password) {
        if (!password.matches("[1-9]{4}"))
            throw new InvalidPasswordException();
        else {
            if (!cardRepository.findByCardNumber(cardNumber).equals(password))
                throw new InvalidPasswordException();
        }
    }

    public void validateWorkingDay(Date workingDay) {
        Calendar today = Calendar.getInstance();
        Calendar requestDay = Calendar.getInstance();
        Date todayDate = new Date();
        today.setTime(todayDate);
        requestDay.setTime(workingDay);
        if (today.get(Calendar.YEAR) != requestDay.get(Calendar.YEAR) ||
                today.get(Calendar.DAY_OF_YEAR) != requestDay.get(Calendar.DAY_OF_YEAR)) {
            throw new InvalidWorkingDayException();
        }

    }

    public void validateUniqueTransaction(Date transactionDate, String terminalType, String followUpCode, String
            cardNumber) {
        if (transactionRepository.findDuplicateTransaction(followUpCode,
                cardNumber,
                transactionDate,
                terminalType) != 0) {
            throw new DuplicateTransaction();
        }
    }

    public void validateHolding(String cardNumber, Long amount) {
        Long currentHolding = cardRepository.findAmountByCardNumber(cardNumber);
        if (currentHolding < amount)
            throw new InsufficientAmountException();
    }

}
