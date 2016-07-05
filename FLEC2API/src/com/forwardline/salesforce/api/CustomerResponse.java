package com.forwardline.salesforce.api;

import com.forwardline.salesforce.api.pojo.Customer;

public class CustomerResponse {
	
	private boolean success;
	private String errorMessage;
	private Customer customer;
	
	public CustomerResponse(boolean success, String errorMessage, Customer customer) {
		this.success = success;
		this.errorMessage = errorMessage;
		this.customer = customer;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
