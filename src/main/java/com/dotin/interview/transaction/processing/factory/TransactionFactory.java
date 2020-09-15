package com.dotin.interview.transaction.processing.factory;

import com.dotin.interview.transaction.processing.model.Transaction;
import com.dotin.interview.transaction.processing.request.Request;

public interface TransactionFactory {

    Transaction creatTransaction(Request request, String status);
}
