package com.dotin.interview.transaction.processing.response;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import com.dotin.interview.transaction.processing.model.Transaction;

import java.util.Set;

public class TenLastTransactionsResponse extends DefaultResponse {
    Set<Transaction> transactionSet;

    public TenLastTransactionsResponse(String cardNumber, String followUpCode, String responseState, Set<Transaction> transactionSet) {
        super(cardNumber, followUpCode, responseState);
        this.transactionSet = transactionSet;
    }

    public void setTransactionSet(Set<Transaction> transactionSet) {
        this.transactionSet = transactionSet;
    }
}
