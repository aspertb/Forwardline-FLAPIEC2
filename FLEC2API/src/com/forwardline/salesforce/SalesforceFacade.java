package com.forwardline.salesforce;

import com.forwardline.api.pojo.fundera.CreateCustomerRequest;
import com.forwardline.api.pojo.fundera.CreateCustomerResponse;
import com.forwardline.api.pojo.fundera.CreateForsightRequest;
import com.forwardline.api.pojo.fundera.CreateForsightResponse;
import com.forwardline.api.pojo.fundera.CreateLeadRequest;
import com.forwardline.api.pojo.fundera.CreateLeadResponse;
import com.forwardline.api.pojo.fundera.CreateOLARequest;
import com.forwardline.api.pojo.fundera.CreateOLAResponse;
import com.forwardline.salesforce.pojo.LoginResponse;

public class SalesforceFacade {

	private static final String USERNAME = "shujaath.mohammed@forwardline.com.fldevapi";
	private static final String PASSWORD = "fl82NYla#";
	private static final String CLIENT_ID = "3MVG98dostKihXN46h.7UoAs4kwDqkPbYxSJTg2mThCWISAJ7AidlI9JFAlKri6iMPVwhCGpvxLtDWGfUR1Ey";
	private static final String SECRET_ID = "7786943219302079736";
	private LoginResponse logResp;

	public SalesforceFacade() {
		System.out.println("getting login..");
		this.logResp = new RestLogin().login(SalesforceFacade.USERNAME, SalesforceFacade.PASSWORD,
				SalesforceFacade.CLIENT_ID, SalesforceFacade.SECRET_ID);
	}

	public CreateCustomerResponse getCustomer(String email) {
		
		ConnectSFCustomer csf = new ConnectSFCustomer();
		String scfResp = csf.getCustomer(logResp, email);

		return null;
	}

	public CreateCustomerResponse postCustomer(CreateCustomerRequest ccr) {

		ConnectSFCustomer csf = new ConnectSFCustomer();
		String scfResp = csf.postCustomer(logResp, ccr);

		return null;
	}

	public CreateForsightResponse getForsight(String id) {
		
		ConnectSFForsight csf = new ConnectSFForsight();
		String scfResp = csf.getForsight(logResp, id);
		
		return null;
	}

	public CreateForsightResponse postForsight(CreateForsightRequest cfr) {
		
		ConnectSFForsight csf = new ConnectSFForsight();
		String scfResp = csf.postForsight(logResp, cfr);

		return null;
	}

	public CreateLeadResponse getLead(String email) {
		
		ConnectSFLead csfl = new ConnectSFLead();
		String csflResp = csfl.getLead(logResp, email);

		return null;
	}

	public CreateLeadResponse postLead(CreateLeadRequest clr) {
		ConnectSFLead csfl = new ConnectSFLead();
		String csflResp = csfl.postLead(logResp, clr);

		return null;
	}

	public CreateOLAResponse getOLA(String id) {
		ConnectSFOLA csfo = new ConnectSFOLA();
		String csfoResp = csfo.getOLA(logResp, id);

		return null;
	}

	public CreateOLAResponse postOLA(CreateOLARequest cor) {
		ConnectSFOLA csfo = new ConnectSFOLA();
		String csfoResp = csfo.postOLA(logResp, cor);

		return null;
	}
}
