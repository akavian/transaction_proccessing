package com.dotin.interview.transaction.processing.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
	@SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "ACCOUNTNUMBER", nullable = false, unique = true)
	@Pattern(regexp = "^[1-9]{10}", message = "Should only contains number")
	private String accountNumber;

	@Column(name = "AMOUNT", nullable = false)
	@NotBlank
	@Digits(integer = 30, fraction = 0)
	private int amount;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "CARDID", nullable = false)
	private Card card;

	public Account() {

	}



	public Account(String accountNumber, int amount, Card card) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.card = card;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}


}
