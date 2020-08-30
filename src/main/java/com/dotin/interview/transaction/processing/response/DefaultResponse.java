package com.dotin.interview.transaction.processing.response;

import com.dotin.interview.transaction.processing.enums.ResponseStateEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class DefaultResponse {
	private String cardNumber;
	private String followUpCode;
	private ResponseStateEnum responseStateEnum;
	public DefaultResponse(String cardNumber, String followUpCode, ResponseStateEnum responseStateEnum) {
		super();
		this.cardNumber = cardNumber;
		this.followUpCode = followUpCode;
		this.responseStateEnum = responseStateEnum;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getFollowUpCode() {
		return followUpCode;
	}
	public void setFollowUpCode(String followUpCode) {
		this.followUpCode = followUpCode;
	}
	public ResponseStateEnum getResponseStateEnum() {
		return responseStateEnum;
	}
	public void setResponseStateEnum(ResponseStateEnum responseStateEnum) {
		this.responseStateEnum = responseStateEnum;
	}
	
}
