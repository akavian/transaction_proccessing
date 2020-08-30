package com.dotin.interview.transaction.processing.response;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class CartToCartTransactionResponse extends DefaultResponse {
	private String destinationCardNumber;

	public CartToCartTransactionResponse(String cardNumber, String followUpCode, ResponseStateEnum responseStateEnum,
			String destinationCardNumber) {
		super(cardNumber, followUpCode, responseStateEnum);
		this.destinationCardNumber = destinationCardNumber;
	}

	public String getDestinationCardNumber() {
		return destinationCardNumber;
	}

	public void setDestinationCardNumber(String destinationCardNumber) {
		this.destinationCardNumber = destinationCardNumber;
	}
	
	
}
