package com.dotin.interview.transaction.processing.exception;

public class InsufficientAmountException extends RuntimeException {

    public InsufficientAmountException() {
    }

    public InsufficientAmountException(String message) {
        super(message);
    }
}
