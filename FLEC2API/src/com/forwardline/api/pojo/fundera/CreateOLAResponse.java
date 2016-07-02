package com.forwardline.api.pojo.fundera;

import com.forwardline.salesforce.pojo.OLA;

public class CreateOLAResponse {
	
	private boolean success;
	private String errorMessage;
	private OLA ola;
	
	public CreateOLAResponse(boolean success, String errorMessage, OLA ola) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
		this.ola = ola;
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
	public OLA getOla() {
		return ola;
	}
	public void setOla(OLA ola) {
		this.ola = ola;
	}

}
