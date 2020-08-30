package com.dotin.interview.transaction.processing.request;

import java.util.Date;

public class DailyCashFlowTransactionRequest extends DefaultRequest {
	private Date startDate;
	private Date endDate;
	public DailyCashFlowTransactionRequest(String cardNumber, Date transactionDate, String followUpDate,
			String terminalType, String password, Date startDate, Date endDate) {
		super(cardNumber, transactionDate, followUpDate, terminalType, password);
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
