package com.forwardline.salesforce.connector.types;

public class CustomerRequest {

	private RequestHeader header;
	private Customer customer;

	public CustomerRequest() {

	}

	public CustomerRequest(RequestHeader header, Customer customer) {
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
