package com.forwardline.api.milo.types;

public class ApplicationResponse {
	private boolean success;
	private String error;
	private String redirectUrl;
	private Application nApplication;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public Application getnApplication() {
		return nApplication;
	}

	public void setnApplication(Application nApplication) {
		this.nApplication = nApplication;
	}

}
