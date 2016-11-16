package com.forwardline.salesforce.connector.types;

public class Offer {

	private Analysis analysis;
	private Double loanAmount;
	private Integer term;
	private Double rate;
	private Double processingFee;
	private Double controlAccountFee;

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(Double processingFee) {
		this.processingFee = processingFee;
	}

	public Double getControlAccountFee() {
		return controlAccountFee;
	}

	public void setControlAccountFee(Double controlAccountFee) {
		this.controlAccountFee = controlAccountFee;
	}

}
