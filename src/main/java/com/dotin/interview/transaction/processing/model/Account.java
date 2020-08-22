package com.dotin.interview.transaction.processing.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name = "Account")
public class Account {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
	@SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)
	private long id;
	
	@Column(name = "ACCOUNTNUMBER", nullable = false)
	private String accountNumber;
	
	@Column(name = "AMOUNT", nullable = false)
	private double amount;
	
	@Column(name = "PRIMARY", nullable = false)
	private boolean primary;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "CARDID", nullable = false)
	private Card card;
	
	public Account() {
		
	}

	

	public Account(String accountNumber, double amount, boolean primary, Card card) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.primary = primary;
		this.card = card;
	}



	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}
