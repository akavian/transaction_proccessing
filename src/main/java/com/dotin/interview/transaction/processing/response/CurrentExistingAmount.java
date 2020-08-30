package com.dotin.interview.transaction.processing.response;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class CurrentExistingAmount extends DefaultResponse {
	private double amount;

	public CurrentExistingAmount(String cardNumber, String followUpCode, ResponseStateEnum responseStateEnum,
			double amount) {
		super(cardNumber, followUpCode, responseStateEnum);
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	 
}
