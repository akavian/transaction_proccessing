package com.dotin.interview.transaction.processing.enums;

public enum TerminalTypeEnum {
	INTERNET("02"),
	ATM("59");
	
	private final String terminalTypeCode;

	private TerminalTypeEnum(String terminalTypeCode) {
		this.terminalTypeCode = terminalTypeCode;
	}

	public String getTerminalTypeCode() {
		return terminalTypeCode;
	}
	
}
