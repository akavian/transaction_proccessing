package com.dotin.interview.transaction.processing.factory;

import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.request.Request;

public class TransactionFactoryImpl implements TransactionFactory {

    public Transaction creatTransaction(Request request, String status){
        Transaction transaction = new Transaction(request.getTransactionDate(), request.getTerminalType(),request.getFollowUpCode(), request.getCardNumber(), request.getAmount(), status);
        return transaction;
    }
}
