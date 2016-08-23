package com.forwardline.api.fundera.pojo;

import java.util.Date;
// import javax.validation.Valid;
// import javax.validation.constraints.DecimalMin;

public class Person {
	public String uuid;
	public String email;
	public String phone_number;
	public String first_name;
	public String last_name;
	public Float ownership_percentage;
	public Date date_of_birth;
	public String street_line1;
	public String street_line2;
	public String city;
	public String state;
	public String zip;
	public String ssn;
	public String credit_score;
	public String last_bankruptcy;
	public String drivers_license_number;
	public String drivers_license_state;
	public Date drivers_license_expiration;
	public String passport_number;
	public String passport_country;
	public Date passport_expiration;
	public Double monthly_residential_payment;
	public String residence_rent_or_own;
	public Double personal_annual_income;
	public Double value_of_liquid_assets;
	public Double value_of_nonretirement_assets;
	public Double value_of_retirement_assets;
	public String citizenship;

	public Person() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public Float getOwnership_percentage() {
		return ownership_percentage;
	}

	public void setOwnership_percentage(Float ownership_percentage) {
		this.ownership_percentage = ownership_percentage;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCredit_score() {
		return credit_score;
	}

	public void setCredit_score(String credit_score) {
		this.credit_score = credit_score;
	}

	public String getLast_bankruptcy() {
		return last_bankruptcy;
	}

	public void setLast_bankruptcy(String last_bankruptcy) {
		this.last_bankruptcy = last_bankruptcy;
	}

	public String getDrivers_license_number() {
		return drivers_license_number;
	}

	public void setDrivers_license_number(String drivers_license_number) {
		this.drivers_license_number = drivers_license_number;
	}

	public String getDrivers_license_state() {
		return drivers_license_state;
	}

	public void setDrivers_license_state(String drivers_license_state) {
		this.drivers_license_state = drivers_license_state;
	}

	public Date getDrivers_license_expiration() {
		return drivers_license_expiration;
	}

	public void setDrivers_license_expiration(Date drivers_license_expiration) {
		this.drivers_license_expiration = drivers_license_expiration;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public String getPassport_country() {
		return passport_country;
	}

	public void setPassport_country(String passport_country) {
		this.passport_country = passport_country;
	}

	public Date getPassport_expiration() {
		return passport_expiration;
	}

	public void setPassport_expiration(Date passport_expiration) {
		this.passport_expiration = passport_expiration;
	}

	public Double getMonthly_residential_payment() {
		return monthly_residential_payment;
	}

	public void setMonthly_residential_payment(Double monthly_residential_payment) {
		this.monthly_residential_payment = monthly_residential_payment;
	}

	public String getResidence_rent_or_own() {
		return residence_rent_or_own;
	}

	public void setResidence_rent_or_own(String residence_rent_or_own) {
		this.residence_rent_or_own = residence_rent_or_own;
	}

	public Double getPersonal_annual_income() {
		return personal_annual_income;
	}

	public void setPersonal_annual_income(Double personal_annual_income) {
		this.personal_annual_income = personal_annual_income;
	}

	public Double getValue_of_liquid_assets() {
		return value_of_liquid_assets;
	}

	public void setValue_of_liquid_assets(Double value_of_liquid_assets) {
		this.value_of_liquid_assets = value_of_liquid_assets;
	}

	public Double getValue_of_nonretirement_assets() {
		return value_of_nonretirement_assets;
	}

	public void setValue_of_nonretirement_assets(Double value_of_nonretirement_assets) {
		this.value_of_nonretirement_assets = value_of_nonretirement_assets;
	}

	public Double getValue_of_retirement_assets() {
		return value_of_retirement_assets;
	}

	public void setValue_of_retirement_assets(Double value_of_retirement_assets) {
		this.value_of_retirement_assets = value_of_retirement_assets;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

}
