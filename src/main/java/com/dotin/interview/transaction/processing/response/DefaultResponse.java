package com.dotin.interview.transaction.processing.response;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class DefaultResponse {
	private String cardNumber;
	private String followUpCode;
	private String responseState;

	public DefaultResponse(String cardNumber, String followUpCode, String responseState) {
		this.cardNumber = cardNumber;
		this.followUpCode = followUpCode;
		this.responseState = responseState;

	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setFollowUpCode(String followUpCode) {
		this.followUpCode = followUpCode;
	}

	public void setResponseState(String responseState) {
		this.responseState = responseState;
	}
}
