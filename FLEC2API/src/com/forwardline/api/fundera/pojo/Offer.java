package com.forwardline.api.fundera.pojo;

public class Offer {
	public String repayment;
	public Double loan_amount;
	public Double interest_rate;
	public Integer term;
	public Double origination_fee;
	public boolean approved;
	public String reason;

	public Offer() {
	}

	public String getRepayment() {
		return repayment;
	}

	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}

	public Double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(Double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public Double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Double getOrigination_fee() {
		return origination_fee;
	}

	public void setOrigination_fee(Double origination_fee) {
		this.origination_fee = origination_fee;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
