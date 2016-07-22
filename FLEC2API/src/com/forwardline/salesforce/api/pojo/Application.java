package com.forwardline.salesforce.api.pojo;

import java.util.List;

public class Application {

	private String id;
	private String name;
	private Customer account;
	private Contact primaryContact;
	private Lead lead;
	private Opportunity opportunity;
	private List<Contact> guarantors;

	public Application() {
		// TODO Auto-generated constructor stub
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

	public Customer getAccount() {
		return account;
	}

	public void setAccount(Customer account) {
		this.account = account;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	public List<Contact> getGuarantors() {
		return guarantors;
	}

	public void setGuarantors(List<Contact> guarantors) {
		this.guarantors = guarantors;
	}

	public Contact getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Contact primaryContact) {
		this.primaryContact = primaryContact;
	}

}
