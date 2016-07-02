package com.forwardline.api.pojo.fundera;

import com.forwardline.salesforce.pojo.Lead;

public class CreateLeadResponse {
	
	private boolean success;
	private String errorMessage;
	private Lead nLead;
	
	public CreateLeadResponse(boolean success, String errorMessage, Lead nLead) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
		this.nLead = nLead;
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
