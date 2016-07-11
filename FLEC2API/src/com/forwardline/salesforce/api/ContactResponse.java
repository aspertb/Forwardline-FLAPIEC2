package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.Contact;

public class ContactResponse {
	private boolean success;
	private String errorMessage;
	private Contact contact;

	public ContactResponse() {
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
