package com.dotin.interview.transaction.processing.request;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Calendar;
import java.util.Date;


public class Request {
	private String cardNumber;
	private Date transactionDate;
	private String followUpCode;
	private String terminalType;
	private String password;
	private Long amount;
	private String destinationCardNumber;
	private String account;
	private Calendar startDateOfTransaction;
	private Calendar endDateOfTransaction;

	public Request(String cardNumber, Date transactionDate, String followUpCode, String terminalType, String password, Long amount, String destinationCardNumber, String account, Calendar startDateOfTransaction, Calendar endDateOfTransaction) {
		this.cardNumber = cardNumber;
		this.transactionDate = transactionDate;
		this.followUpCode = followUpCode;
		this.terminalType = terminalType;
		this.password = password;
		this.amount = amount;
		this.destinationCardNumber = destinationCardNumber;
		this.account = account;
		this.startDateOfTransaction = startDateOfTransaction;
		this.endDateOfTransaction = endDateOfTransaction;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getDestinationCardNumber() {
		return destinationCardNumber;
	}

	public void setDestinationCardNumber(String destinationCardNumber) {
		this.destinationCardNumber = destinationCardNumber;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Calendar getStartDateOfTransaction() {
		return startDateOfTransaction;
	}

	public void setStartDateOfTransaction(Calendar startDateOfTransaction) {
		this.startDateOfTransaction = startDateOfTransaction;
	}

	public Calendar getEndDateOfTransaction() {
		return endDateOfTransaction;
	}

	public void setEndDateOfTransaction(Calendar endDateOfTransaction) {
		this.endDateOfTransaction = endDateOfTransaction;
	}
}
