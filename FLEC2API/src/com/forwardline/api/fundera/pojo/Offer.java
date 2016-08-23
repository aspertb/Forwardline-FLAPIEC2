package com.forwardline.api.fundera.pojo;

public class Offer {
	public Double loan_approval_amount;
	public Integer term;
	public String repayment;
	public Double factor_rate;
	public Double interest_rate;
	public Double origination_fee;
	public Integer miscellaneous_fee;
	public String url;

	public Offer() {
	}

	public Double getLoan_approval_amount() {
		return loan_approval_amount;
	}

	public void setLoan_approval_amount(Double loan_approval_amount) {
		this.loan_approval_amount = loan_approval_amount;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public String getRepayment() {
		return repayment;
	}

	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}

	public Double getFactor_rate() {
		return factor_rate;
	}

	public void setFactor_rate(Double factor_rate) {
		this.factor_rate = factor_rate;
	}

	public Double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public Double getOrigination_fee() {
		return origination_fee;
	}

	public void setOrigination_fee(Double origination_fee) {
		this.origination_fee = origination_fee;
	}

	public Integer getMiscellaneous_fee() {
		return miscellaneous_fee;
	}

	public void setMiscellaneous_fee(Integer miscellaneous_fee) {
		this.miscellaneous_fee = miscellaneous_fee;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
