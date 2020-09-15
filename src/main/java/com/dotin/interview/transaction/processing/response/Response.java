package com.dotin.interview.transaction.processing.response;

import com.dotin.interview.transaction.processing.model.Transaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Response {
    private String cardNumber;
    private String followUpCode;
    private String responseCode;
    private long holding;
    private List<Transaction> transactions;
    private String destinationCardNumber;

    public Response() {
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setFollowUpCode(String followUpCode) {
        this.followUpCode = followUpCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setHolding(long holding) {
        this.holding = holding;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setDestinationCardNumber(String destinationCardNumber) {
        this.destinationCardNumber = destinationCardNumber;
    }
}
