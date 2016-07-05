package com.forwardline.api.fundera.pojo;

import java.util.List;

public class TestClientResp {
	public boolean preapproved;
	public List<Offer> offers;

	public TestClientResp() {
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
