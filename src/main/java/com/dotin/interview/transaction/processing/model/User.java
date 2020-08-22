package com.dotin.interview.transaction.processing.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BANKUSER")
public class User {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BANKUSER_SEQ")
	@SequenceGenerator(name = "BANKUSER_SEQ", sequenceName = "BANKUSER_SEQ", allocationSize = 1)
	private long id;
	
	@Column(name = "FIRSTNAME", nullable = false )
	private String firstName;
	
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;
	
	@Column(name = "NATIONALCODE", nullable = false)
	private String nationalCode;
	
	@Column(name = "USERSTATUS", nullable = false)
	private String userStatus;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn (name = "ID", referencedColumnName = "CARDID" )
	private Card card;
	
	
	
	public User() {}
	
	public User(String firstName, String lastName, String nationalCode, String userStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalCode = nationalCode;
		this.userStatus = userStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public long getId() {
		return id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	

	
}
