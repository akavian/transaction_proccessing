package com.dotin.interview.transaction.processing.request;

import java.util.Date;

public class CartToCartTransactionRequest extends DefaultRequest {
	private int amount;
	private String destinationCardNumber;
	private String accountNumber;

	public CartToCartTransactionRequest(String cardNumber, Date transactionDate, String followUpDate, String terminalType, String password, int amount, String destinationCardNumber, String accountNumber) {
		super(cardNumber, transactionDate, followUpDate, terminalType, password);
		this.amount = amount;
		this.destinationCardNumber = destinationCardNumber;
		this.accountNumber = accountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDestinationCardNumber() {
		return destinationCardNumber;
	}

	public void setDestinationCardNumber(String destinationCardNumber) {
		this.destinationCardNumber = destinationCardNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
