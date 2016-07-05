package com.forwardline.api.fundera.pojo;

import java.util.Date;

public class Owners {
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date dob;
	private String ssn;
	private String street_line1;
	private String street_line2;
	private String city;
	private String state;
	private String zip;
	private Double annual_income;
	private Double ownership_pct;
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public Double getAnnual_income() {
		return annual_income;
	}
	public void setAnnual_income(Double annual_income) {
		this.annual_income = annual_income;
	}
	public Double getOwnership_pct() {
		return ownership_pct;
	}
	public void setOwnership_pct(Double ownership_pct) {
		this.ownership_pct = ownership_pct;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
}
