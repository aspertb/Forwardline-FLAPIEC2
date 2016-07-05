package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.Forsight;

public class ForsightResponse {
	
	private boolean success;
	private String errorMessage;
	private Forsight fvo;
	
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
	public Forsight getFvo() {
		return fvo;
	}
	public void setFvo(Forsight fvo) {
		this.fvo = fvo;
	}
	
}
