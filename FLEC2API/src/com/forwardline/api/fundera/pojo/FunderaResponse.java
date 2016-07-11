package com.forwardline.api.fundera.pojo;

import java.util.List;

public class FunderaResponse {
	public boolean success;
	public boolean preapproved;
	public List<Offer> offers;

	public FunderaResponse() {
		// TODO Auto-generated constructor stub
	}

	public boolean isPreapproved() {
		return preapproved;
	}

	public void setPreapproved(boolean preapproved) {
		this.preapproved = preapproved;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
