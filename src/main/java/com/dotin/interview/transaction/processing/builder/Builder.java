package com.dotin.interview.transaction.processing.builder;

import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.response.Response;

import java.util.List;

public interface Builder {

    void setCardNumber(String cardNumber);
    void setFollowUpCode(String followUpCode);
    void setResponseCode(String responseCode);
    void setHolding(long holding);
    void setTransactions (List<Transaction> transactions);
    void setDestinationCardNumber(String destinationCardNumber);
    void reset();
    Response getResult();
}
