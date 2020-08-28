/**
 * 
 */
package com.dotin.interview.transaction.processing.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CARD")
public class Card {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_SEQ")
	@SequenceGenerator(name = "CARD_SEQ", sequenceName = "CARD_SEQ", allocationSize = 1)
	private long id;

	@Pattern(regexp = "^[1-9]{16}", message = "Should only contain numbers")
	@Column(name = "CARDNUMBER", nullable = false, unique = true)
	private String cardNumber;

	@Column(name = "CARDPASSWORD", nullable = false)
	private String cardPassword;

	@Column(name = "MISTAKETIMES")
	private short mistakeTimes;

	@Column(name = "ISOPEN", nullable = false)
	private boolean isOpen;

	@Pattern(regexp = "^[1-9]{10}", message = "Should only contain numbers")
	@Column(name = "MAINACCOUNT", nullable = false)
	private String mainAccount;

	@OneToOne(mappedBy = "card")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "card", cascade = CascadeType.ALL)
	private Set<Account> accounts;


	public Card() {
	}

	public Card(String cardNumber, String cardPassword, boolean isOpen) {
		super();
		this.cardNumber = cardNumber;
		this.cardPassword = cardPassword;
		this.isOpen = isOpen;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardPassword() {
		return cardPassword;
	}

	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount( Account account) {
		if (accounts == null) {
			accounts = new HashSet<Account>();
		}
		accounts.add(account);
	}

	public short getMistakeTimes() {
		return mistakeTimes;
	}

	public void setMistakeTimes(short mistakeTimes) {
		this.mistakeTimes = mistakeTimes;
	}

	public String getMainAccount() {
		return mainAccount;
	}

	public void setMainAccount(String mainAccount) {
		this.mainAccount = mainAccount;
	}

}
