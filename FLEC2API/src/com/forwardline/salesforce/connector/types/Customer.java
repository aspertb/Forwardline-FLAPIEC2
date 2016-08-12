package com.forwardline.salesforce.connector.types;

public class Customer {

	private String id;
	private String name;
	private Contact primaryContact;

	public Customer(String id, String name, Contact primaryContact) {
		this.id = id;
		this.name = name;
		this.primaryContact = primaryContact;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Contact primaryContact) {
		this.primaryContact = primaryContact;
	}

}
