package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.Lead;

public class LeadResponse {
	
	private boolean success;
	private String errorMessage;
	private Lead nLead;
	
	public LeadResponse(boolean success, String errorMessage, Lead nLead) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
		this.nLead = nLead;
	}
	
	public LeadResponse() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Lead getnLead() {
		return nLead;
	}
	public void setnLead(Lead nLead) {
		this.nLead = nLead;
	}

}
