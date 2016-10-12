package com.forwardline.salesforce.connector.types;

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
	public Double accountsReceivable;
	public Date businessInception;
	public Date lastBankruptcy;
	public Boolean outstandingTaxLien;

	public String businessAddressStreet1;
	public String businessAddressStreet2;
	public String businessAddressCity;
	public String businessAddressState;
	public String businessAddressZip;

	public Boolean businessAcceptsCreditCard;
	public Double ccSalesLastMonth;
	public Double ccSalesTwoMonthsAgo;
	public Double ccSalesThreeMonthsAgo;
	public Double ccSalesFourMonthsAgo;
	public Double averageMonthlySales;

	public Boolean declinedInPreScoreBranching;
	public String reason;

	public Long federalTaxId;

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

	public Double getAccountsReceivable() {
		return accountsReceivable;
	}

	public void setAccountsReceivable(Double accountsReceivable) {
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

	public String getBusinessAddressStreet1() {
		return businessAddressStreet1;
	}

	public void setBusinessAddressStreet1(String businessAddressStreet1) {
		this.businessAddressStreet1 = businessAddressStreet1;
	}

	public String getBusinessAddressStreet2() {
		return businessAddressStreet2;
	}

	public void setBusinessAddressStreet2(String businessAddressStreet2) {
		this.businessAddressStreet2 = businessAddressStreet2;
	}

	public String getBusinessAddressCity() {
		return businessAddressCity;
	}

	public void setBusinessAddressCity(String businessAddressCity) {
		this.businessAddressCity = businessAddressCity;
	}

	public String getBusinessAddressState() {
		return businessAddressState;
	}

	public void setBusinessAddressState(String businessAddressState) {
		this.businessAddressState = businessAddressState;
	}

	public String getBusinessAddressZip() {
		return businessAddressZip;
	}

	public void setBusinessAddressZip(String businessAddressZip) {
		this.businessAddressZip = businessAddressZip;
	}

	public Boolean getDeclinedInPreScoreBranching() {
		return declinedInPreScoreBranching;
	}

	public void setDeclinedInPreScoreBranching(Boolean declinedInPreScoreBranching) {
		this.declinedInPreScoreBranching = declinedInPreScoreBranching;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getBusinessAcceptsCreditCard() {
		return businessAcceptsCreditCard;
	}

	public void setBusinessAcceptsCreditCard(Boolean businessAcceptsCreditCard) {
		this.businessAcceptsCreditCard = businessAcceptsCreditCard;
	}

	public Double getCcSalesLastMonth() {
		return ccSalesLastMonth;
	}

	public void setCcSalesLastMonth(Double ccSalesLastMonth) {
		this.ccSalesLastMonth = ccSalesLastMonth;
	}

	public Double getCcSalesTwoMonthsAgo() {
		return ccSalesTwoMonthsAgo;
	}

	public void setCcSalesTwoMonthsAgo(Double ccSalesTwoMonthsAgo) {
		this.ccSalesTwoMonthsAgo = ccSalesTwoMonthsAgo;
	}

	public Double getCcSalesThreeMonthsAgo() {
		return ccSalesThreeMonthsAgo;
	}

	public void setCcSalesThreeMonthsAgo(Double ccSalesThreeMonthsAgo) {
		this.ccSalesThreeMonthsAgo = ccSalesThreeMonthsAgo;
	}

	public Double getCcSalesFourMonthsAgo() {
		return ccSalesFourMonthsAgo;
	}

	public void setCcSalesFourMonthsAgo(Double ccSalesFourMonthsAgo) {
		this.ccSalesFourMonthsAgo = ccSalesFourMonthsAgo;
	}

	public Double getAverageMonthlySales() {
		return averageMonthlySales;
	}

	public void setAverageMonthlySales(Double averageMonthlySales) {
		this.averageMonthlySales = averageMonthlySales;
	}

	public Long getFederalTaxId() {
		return federalTaxId;
	}

	public void setFederalTaxId(Long federalTaxId) {
		this.federalTaxId = federalTaxId;
	}

}
