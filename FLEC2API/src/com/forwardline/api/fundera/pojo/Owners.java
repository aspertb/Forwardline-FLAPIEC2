package com.forwardline.api.fundera.pojo;

import java.util.List;

import com.forwardline.salesforce.api.pojo.Contact;
import com.forwardline.salesforce.api.pojo.Customer;
import com.forwardline.salesforce.api.pojo.RequestHeader;

public class Owners {
	
	public RequestHeader RequestHeader;
	public List<Contact> conList;
	public Customer cust;

	public Owners(com.forwardline.salesforce.api.pojo.RequestHeader requestHeader, List<Contact> conList,
			Customer cust) {
		RequestHeader = requestHeader;
		this.conList = conList;
		this.cust = cust;
	}

	public Owners() {
	}

	public RequestHeader getRequestHeader() {
		return RequestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		RequestHeader = requestHeader;
	}

	public List<Contact> getContats() {
		return conList;
	}

	public void setOwners(List<Contact> conList) {
		this.conList = conList;
	}

	public Customer getCompany() {
		return cust;
	}

	public void setCompany(Customer cust) {
		this.cust = cust;
	}
}
