package com.dotin.interview.transaction.processing.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_SEQ")
	@SequenceGenerator(name = "TRANSACTION_SEQ", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "TRANSACTIONDATE", nullable = false)
	private Date transactionDate;

	@Pattern(regexp = "^[1-9]{2}", message = "Should contain only two digits")
	@Column(name = "TERMINALTYPE", nullable = false)
	private String terminalType;

	@Pattern(regexp = "^[1-9a-zA-Z]{20}", message = "Should contains 20 digits or characters")
	@Column(name = "FOLLOWUPNUMBER", nullable = false, unique = true)
	private String followUpNumber;

	@Pattern(regexp = "^[1-9]{16}")
	@Column(name = "CARDNUMBER", nullable = false)
	private String cardNumber;

	@Digits(integer = 30, fraction = 0)
	@Column(name = "AMOUNT", nullable = false)
	@Min(value = 0 , message = "The amount cannot be negative")
	private Long amount;

	@Pattern(regexp = "^[1-9]{2}" , message = "Has only two digits")
	@Column(name = "RESPONSECODE", nullable = false)
	private String responeCode;

	@Pattern(regexp = "^[1-9]{2}", message = "Has only two digits")
	@Column(name = "TRANSACTIONTYPE", nullable = false)
	private String transactionType;


	public Transaction() {
	}

	public Transaction(Date transactionDate, String terminalType, String followUpNumber, String cardNumber,
					   Long amount, String responeCode) {
		super();
		this.transactionDate = transactionDate;
		this.terminalType = terminalType;
		this.followUpNumber = followUpNumber;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.responeCode = responeCode;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
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

	public void setId(long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


}
