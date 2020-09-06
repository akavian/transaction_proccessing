package com.dotin.interview.transaction.processing.response;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class CurrentExistingAmount extends DefaultResponse {
	private double amount;

	public CurrentExistingAmount(String cardNumber, String followUpCode, String responseState, double amount) {
		super(cardNumber, followUpCode, responseState);
		this.amount = amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
