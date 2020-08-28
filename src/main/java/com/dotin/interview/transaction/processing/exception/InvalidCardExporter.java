package com.dotin.interview.transaction.processing.exception;

public class InvalidCardExporter extends RuntimeException {

    public InvalidCardExporter() {
    }

    public InvalidCardExporter(String message) {
        super(message);
    }
}
