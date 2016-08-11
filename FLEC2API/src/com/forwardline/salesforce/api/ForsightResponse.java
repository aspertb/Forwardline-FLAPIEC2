package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.ForsightDecision;

public class ForsightResponse {

	private boolean success;
	private String errorMessage;
	private ForsightDecision decision;

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

	public ForsightDecision getDecision() {
		return decision;
	}

	public void setDecision(ForsightDecision decision) {
		this.decision = decision;
	}

}
