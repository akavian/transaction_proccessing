package com.dotin.interview.transaction.processing.enums;

public enum ResponseStateEnum {
	SUCCESSFUL("Successful", "00"), INVALID("Invalid", "12"), NOTENOUGHMONEY("Not Enough Money", "51"),
	INVALIDISSUANCE("Invalid Issuance", "15"), INCORRECTPASSWORD("Incorrect Password", "57"),
	INVALIDWORKINGDAY("Invalid Woking Day", "77"),
	PROBLEMINPROCESSINGTRANSACTION("Problem in processing Transaction", "80"),
	REPEATEDTRANSACTION("Repeated Transaction", "94");

	private final String code;
	private final String message;

	ResponseStateEnum(String message, String code) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
