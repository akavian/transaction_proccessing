package com.dotin.interview.transaction.processing.enums;

public enum Response {
	SUCCESSFUL("00"),
	INVALID("12"),
	NOTENOUGHMONEY("51"),
	INVALIDISSUANCE("15");
	
	private final String code;

	Response(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
