package com.forwardline.api.pojo.fundera;

import com.forwardline.salesforce.pojo.Customer;
import com.forwardline.salesforce.pojo.RequestHeader;

public class CreateCustomerRequest {

	private RequestHeader header;
	private Customer customer;
	
	public CreateCustomerRequest(RequestHeader header, Customer customer) {
		this.header = header;
		this.customer = customer;
	}
	
	public RequestHeader getHeader() {
		return header;
	}
	public void setHeader(RequestHeader header) {
		this.header = header;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
