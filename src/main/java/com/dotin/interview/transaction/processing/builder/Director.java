package com.dotin.interview.transaction.processing.builder;

import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.request.Request;

import java.util.List;


public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }


    public void makeHoldingResponse(Request request, String responseCode, long holding) {
        builder.setCardNumber(request.getCardNumber());
        builder.setFollowUpCode(request.getFollowUpCode());
        builder.setResponseCode(responseCode);
        builder.setHolding(holding);
    }

    public void makeTenLastTransactionResponse(Request request, String responseCode, List<Transaction> transactions) {
        builder.setCardNumber(request.getCardNumber());
        builder.setFollowUpCode(request.getFollowUpCode());
        builder.setResponseCode(responseCode);
        builder.setTransactions(transactions);
    }

    public void makeCartToCartResponse(CartToCartTransactionRequest request, String responseCode) {
        builder.setCardNumber(request.getCardNumber());
        builder.setFollowUpCode(request.getFollowUpCode());
        builder.setResponseCode(responseCode);
        builder.setDestinationCardNumber(request.getDestinationCardNumber());
    }

    public void makeDailyCashFlowResponse(DailyCashFlowTransactionRequest request, String responseCode, List<Transaction> transactions) {
        builder.setCardNumber(request.getCardNumber());
        builder.setFollowUpCode(request.getFollowUpCode());
        builder.setResponseCode(responseCode);
        builder.setTransactions(transactions);
    }

    public void makeErrorResponse(){
        
    }


}
