package com.forwardline.salesforce.api.pojo;

public class RequestHeader {
	private String operation;
	private String partner;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}
}
