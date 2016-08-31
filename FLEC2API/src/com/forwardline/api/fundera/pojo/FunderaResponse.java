package com.forwardline.api.fundera.pojo;

import java.util.List;

public class FunderaResponse {
	public boolean updated;
	public boolean preapproved;
	public String rejection_reason;
	public List<Offer> offers;

	public FunderaResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public FunderaResponse(boolean preapproved, String rejection_reason) {
		this.preapproved = preapproved;
		this.rejection_reason = rejection_reason;
	}
	
	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	public boolean isPreapproved() {
		return preapproved;
	}

	public void setPreapproved(boolean preapproved) {
		this.preapproved = preapproved;
	}

	public String getRejection_reason() {
		return rejection_reason;
	}

	public void setRejection_reason(String rejection_reason) {
		this.rejection_reason = rejection_reason;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

}
