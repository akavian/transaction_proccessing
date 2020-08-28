package com.dotin.interview.transaction.processing.exception;

public class InvalidWorkingDayException extends RuntimeException {

    public InvalidWorkingDayException() {
    }

    public InvalidWorkingDayException(String message) {
        super(message);
    }
}
