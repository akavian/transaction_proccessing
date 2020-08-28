package com.dotin.interview.transaction.processing.exception;

public class ProcessingTransactionProblem extends RuntimeException {

    public ProcessingTransactionProblem() {
    }

    public ProcessingTransactionProblem(String message) {
        super(message);
    }
}
