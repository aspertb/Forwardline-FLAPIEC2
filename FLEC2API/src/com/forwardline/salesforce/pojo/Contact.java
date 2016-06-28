package com.forwardline.salesforce.pojo;

public class Contact extends SObject {
	private String AccountId;
	private Account Account;
	private String Email;

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Account getAccount() {
		return Account;
	}

	public void setAccount(Account account) {
		Account = account;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
