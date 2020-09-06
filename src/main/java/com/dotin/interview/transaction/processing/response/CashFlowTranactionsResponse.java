package com.dotin.interview.transaction.processing.response;

import java.util.Set;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import com.dotin.interview.transaction.processing.model.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class CashFlowTranactionsResponse extends DefaultResponse {
	
	private Set<Transaction> transactions;

	public CashFlowTranactionsResponse(String cardNumber, String followUpCode, String responseState, Set<Transaction> transactions) {
		super(cardNumber, followUpCode, responseState);
		this.transactions = transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
}
