package com.dotin.interview.transaction.processing.request;

import java.util.Date;

public class Request {
	private String cardNumber;
	private Date transactionDate;
	private String followUpCode;
	private String terminalType;
	private String password;
	
	public Request(String cardNumber, Date transactionDate, String followUpDate, String terminalType, String password) {
		super();
		this.cardNumber = cardNumber;
		this.transactionDate = transactionDate;
		this.followUpCode = followUpDate;
		this.terminalType = terminalType;
		this.password = password;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getFollowUpCode() {
		return followUpCode;
	}

	public void setFollowUpCode(String followUpCode) {
		this.followUpCode = followUpCode;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
