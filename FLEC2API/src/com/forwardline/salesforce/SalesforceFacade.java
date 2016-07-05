package com.forwardline.salesforce;

import com.forwardline.salesforce.api.CustomerRequest;
import com.forwardline.salesforce.api.CustomerResponse;
import com.forwardline.salesforce.api.ForsightRequest;
import com.forwardline.salesforce.api.ForsightResponse;
import com.forwardline.salesforce.api.LeadRequest;
import com.forwardline.salesforce.api.LeadResponse;
import com.forwardline.salesforce.api.ApplicationRequest;
import com.forwardline.salesforce.api.ApplicationResponse;
import com.forwardline.salesforce.api.LoginResponse;

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

	public CustomerResponse getCustomer(String email) {
		
		CustomerHelper csf = new CustomerHelper();
		String scfResp = csf.getCustomer(logResp, email);

		return null;
	}

	public CustomerResponse postCustomer(CustomerRequest ccr) {

		CustomerHelper csf = new CustomerHelper();
		String scfResp = csf.postCustomer(logResp, ccr);

		return null;
	}

	public ForsightResponse getForsight(String id) {
		
		ForsightHelper csf = new ForsightHelper();
		String scfResp = csf.getForsight(logResp, id);
		
		return null;
	}

	public ForsightResponse postForsight(ForsightRequest cfr) {
		
		ForsightHelper csf = new ForsightHelper();
		String scfResp = csf.postForsight(logResp, cfr);

		return null;
	}

	public LeadResponse getLead(String email) {
		
		LeadHelper csfl = new LeadHelper();
		String csflResp = csfl.getLead(logResp, email);

		return null;
	}

	public LeadResponse postLead(LeadRequest clr) {
		LeadHelper csfl = new LeadHelper();
		String csflResp = csfl.postLead(logResp, clr);

		return null;
	}

	public ApplicationResponse getOLA(String id) {
		OLAHelper csfo = new OLAHelper();
		String csfoResp = csfo.getOLA(logResp, id);

		return null;
	}

	public ApplicationResponse postOLA(ApplicationRequest cor) {
		OLAHelper csfo = new OLAHelper();
		String csfoResp = csfo.postOLA(logResp, cor);

		return null;
	}
}
