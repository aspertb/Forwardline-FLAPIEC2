package com.forwardline.api.pojo.fundera;

import java.util.Date;

public class Company {
	public Double loan_amount;
	public String loan_purpose;
	public Integer industry_id;
	public String business_name;
	public String business_dba;
	public String entity_type;
	public String street_line1;
	public String street_line2;
	public String city;
	public String state;
	public String zip;
	public String phone_number;
	public Integer number_of_employees;
	public Double annual_revenue;
	public Double average_bank_balance;
	public Integer accounts_receivable;
	public Date business_inception;
	public Date last_bankruptcy;
	public Boolean outstanding_tax_lien_bool;

	public Company() {
	}

	public Double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(Double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public String getLoan_purpose() {
		return loan_purpose;
	}

	public void setLoan_purpose(String loan_purpose) {
		this.loan_purpose = loan_purpose;
	}

	public Integer getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(Integer industry_id) {
		this.industry_id = industry_id;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getBusiness_dba() {
		return business_dba;
	}

	public void setBusiness_dba(String business_dba) {
		this.business_dba = business_dba;
	}

	public String getEntity_type() {
		return entity_type;
	}

	public void setEntity_type(String entity_type) {
		this.entity_type = entity_type;
	}

	public String getStreet_line1() {
		return street_line1;
	}

	public void setStreet_line1(String street_line1) {
		this.street_line1 = street_line1;
	}

	public String getStreet_line2() {
		return street_line2;
	}

	public void setStreet_line2(String street_line2) {
		this.street_line2 = street_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Integer getNumber_of_employees() {
		return number_of_employees;
	}

	public void setNumber_of_employees(Integer number_of_employees) {
		this.number_of_employees = number_of_employees;
	}

	public Double getAnnual_revenue() {
		return annual_revenue;
	}

	public void setAnnual_revenue(Double annual_revenue) {
		this.annual_revenue = annual_revenue;
	}

	public Double getAverage_bank_balance() {
		return average_bank_balance;
	}

	public void setAverage_bank_balance(Double average_bank_balance) {
		this.average_bank_balance = average_bank_balance;
	}

	public Integer getAccounts_receivable() {
		return accounts_receivable;
	}

	public void setAccounts_receivable(Integer accounts_receivable) {
		this.accounts_receivable = accounts_receivable;
	}

	public Date getBusiness_inception() {
		return business_inception;
	}

	public void setBusiness_inception(Date business_inception) {
		this.business_inception = business_inception;
	}

	public Date getLast_bankruptcy() {
		return last_bankruptcy;
	}

	public void setLast_bankruptcy(Date last_bankruptcy) {
		this.last_bankruptcy = last_bankruptcy;
	}

	public Boolean getOutstanding_tax_lien_bool() {
		return outstanding_tax_lien_bool;
	}

	public void setOutstanding_tax_lien_bool(Boolean outstanding_tax_lien_bool) {
		this.outstanding_tax_lien_bool = outstanding_tax_lien_bool;
	}

}
