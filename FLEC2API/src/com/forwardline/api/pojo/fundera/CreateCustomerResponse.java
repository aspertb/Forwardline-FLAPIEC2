package com.forwardline.api.pojo.fundera;

import com.forwardline.salesforce.pojo.Customer;

public class CreateCustomerResponse {
	
	private boolean success;
	private String errorMessage;
	private Customer customer;
	
	public CreateCustomerResponse(boolean success, String errorMessage, Customer customer) {
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
