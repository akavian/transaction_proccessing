package com.dotin.interview.transaction.processing.exception;

public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException() {
    }

    public InvalidTransactionException(String message) {
        super(message);
    }
}
