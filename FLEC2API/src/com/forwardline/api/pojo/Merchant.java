package com.forwardline.api.pojo;

import java.io.Serializable;

public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String salesforceRecordId;
	private String accountName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Name : " + name + "\n\n" + "Email: " + email + "\n\n" + "Salesforce Record Id: " + salesforceRecordId;
	}

	public String getSalesforceRecordId() {
		return salesforceRecordId;
	}

	public void setSalesforceRecordId(String salesforceRecordId) {
		this.salesforceRecordId = salesforceRecordId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
