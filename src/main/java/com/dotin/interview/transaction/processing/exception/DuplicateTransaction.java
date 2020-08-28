package com.dotin.interview.transaction.processing.exception;

public class DuplicateTransaction extends RuntimeException {

    public DuplicateTransaction() {
    }

    public DuplicateTransaction(String message) {
        super(message);
    }
}
