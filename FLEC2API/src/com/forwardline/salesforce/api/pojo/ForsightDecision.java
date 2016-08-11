package com.forwardline.salesforce.api.pojo;

public class ForsightDecision {

	private Analysis analysis;
	private Offer offer;
	private Boolean approved;

	public ForsightDecision() {

	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

}
