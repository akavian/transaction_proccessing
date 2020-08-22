package com.dotin.interview.transaction.processing.request;

import java.util.Date;

public class CartToCartTransactionRequest extends Request{
	private int amount;
	private String destinationCardNumber;
	
	public CartToCartTransactionRequest(String cardNumber, Date transactionDate, String followUpDate,
			String terminalType, String password, int amount, String destinationCardNumber) {
		super(cardNumber, transactionDate, followUpDate, terminalType, password);
		this.amount = amount;
		this.destinationCardNumber = destinationCardNumber;
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
	
	
}
