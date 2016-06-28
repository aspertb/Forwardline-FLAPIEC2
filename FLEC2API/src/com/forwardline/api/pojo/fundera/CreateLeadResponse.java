package com.forwardline.api.pojo.fundera;

import java.util.List;

public class CreateLeadResponse {
	public boolean preapproved;
	public List<Offer> offers;

	public CreateLeadResponse() {
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

}
