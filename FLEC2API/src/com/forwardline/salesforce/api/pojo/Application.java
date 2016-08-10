package com.forwardline.salesforce.api.pojo;

import java.util.Date;
import java.util.List;

public class Application {

	private String id;
	private String name;
	private Customer account;
	private Contact primaryContact;
	private Lead lead;
	private Opportunity opportunity;
	private List<Contact> guarantors;

	public Double loanAmount;
	public String loanPurpose;
	public Integer industryId;
	public String businessName;
	public String businessDba;
	public String entityType;
	public Integer numberOfEmployees;
	public Double annualRevenue;
	public Double averageBankBalance;
	public Integer accountsReceivable;
	public Date businessInception;
	public Date lastBankruptcy;
	public Boolean outstandingTaxLien;

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

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessDba() {
		return businessDba;
	}

	public void setBusinessDba(String businessDba) {
		this.businessDba = businessDba;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Double getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(Double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public Double getAverageBankBalance() {
		return averageBankBalance;
	}

	public void setAverageBankBalance(Double averageBankBalance) {
		this.averageBankBalance = averageBankBalance;
	}

	public Integer getAccountsReceivable() {
		return accountsReceivable;
	}

	public void setAccountsReceivable(Integer accountsReceivable) {
		this.accountsReceivable = accountsReceivable;
	}

	public Date getBusinessInception() {
		return businessInception;
	}

	public void setBusinessInception(Date businessInception) {
		this.businessInception = businessInception;
	}

	public Date getLastBankruptcy() {
		return lastBankruptcy;
	}

	public void setLastBankruptcy(Date lastBankruptcy) {
		this.lastBankruptcy = lastBankruptcy;
	}

	public Boolean getOutstandingTaxLien() {
		return outstandingTaxLien;
	}

	public void setOutstandingTaxLien(Boolean outstandingTaxLien) {
		this.outstandingTaxLien = outstandingTaxLien;
	}

}
