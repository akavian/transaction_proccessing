package com.dotin.interview.transaction.processing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TRANSACTION_SEQ")
	@SequenceGenerator(name = "TRANSACTION_SEQ", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "transactionDate", nullable = false)
	private Date transactionDate;

	@Column(name = "TERMINALTYPE", nullable = false)
	private String terminalType;

	@Column(name = "FOLLOWUPNUMBER", nullable = false)
	private String followUpNumber;

	@Column(name = "CARDNUMBER", nullable = false)
	private String cardNumber;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

	@Column(name = "RESPONSECODE", nullable = false)
	private String responeCode;
	
	@Column(name = "TRANSACTIONTYPE", nullable = false)
	private String transactionType;

	public Transaction() {
	}



	public Transaction(Date transactionDate, String terminalType, String followUpNumber, String cardNumber,
			double amount, String responeCode) {
		super();
		this.transactionDate = transactionDate;
		this.terminalType = terminalType;
		this.followUpNumber = followUpNumber;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.responeCode = responeCode;
	}



	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getFollowUpNumber() {
		return followUpNumber;
	}

	public void setFollowUpNumber(String followUpNumber) {
		this.followUpNumber = followUpNumber;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getResponeCode() {
		return responeCode;
	}

	public void setResponeCode(String responeCode) {
		this.responeCode = responeCode;
	}

	public long getId() {
		return id;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
