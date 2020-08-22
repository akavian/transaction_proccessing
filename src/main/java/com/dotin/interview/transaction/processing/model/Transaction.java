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

	@Column(name = "CARD", nullable = false)
	private Card card;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

	@Column(name = "RESPONSECODE", nullable = false)
	private String responeCode;

	public Transaction() {
	}

	public Transaction(Date transactionDate, String terminalType, String followUpNumber, Card card, double amount,
			String responeCode) {
		super();
		this.transactionDate = transactionDate;
		this.terminalType = terminalType;
		this.followUpNumber = followUpNumber;
		this.card = card;
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
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

}
