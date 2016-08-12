package com.forwardline.salesforce.connector.types;

public class ApplicationResponse {

	private boolean success;
	private String errorMessage;
	private Application application;

	public ApplicationResponse(boolean success, String errorMessage, Application application) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
		this.application = application;
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

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
