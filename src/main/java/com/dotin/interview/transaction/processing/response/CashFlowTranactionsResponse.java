package com.dotin.interview.transaction.processing.response;

import java.util.Set;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import com.dotin.interview.transaction.processing.model.Transaction;

public class CashFlowTranactionsResponse extends Response {
	
	private Set<Transaction> transactions;

	public CashFlowTranactionsResponse(String cardNumber, String followUpCode, ResponseStateEnum responseStateEnum,
			Set<Transaction> transaction) {
		super(cardNumber, followUpCode, responseStateEnum);
		this.transactions = transaction;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
