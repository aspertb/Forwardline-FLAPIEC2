package com.forwardline.salesforce;

import com.forwardline.salesforce.api.CustomerRequest;
import com.forwardline.salesforce.api.CustomerResponse;
import com.forwardline.salesforce.api.ForsightRequest;
import com.forwardline.salesforce.api.ForsightResponse;
import com.forwardline.salesforce.api.LeadRequest;
import com.forwardline.salesforce.api.LeadResponse;
import com.forwardline.api.fundera.pojo.Offers;
import com.forwardline.salesforce.api.ApplicationRequest;
import com.forwardline.salesforce.api.ApplicationResponse;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Contact;

/*	TODO 1: This class should have only the operations supported by the APEX REST API. 
   			See the Forwardline*API classes in FLDEVAPI. Each of those classes a OPERATION_* static variable. 
  			Create methods based on those values.
	TODO 2: Doing the login in a constructor is not a good idea. 
			Please move it to SalesforceHelper and add a login method in the facade. 
			Caching the loginResponse in the class is fine. Always pass the keys and credentials to the login method. 
			Do not cache those.
	TODO 3: I have renamed your connection* classes to helper classes. 
			I am fine if you want just want to use the OLA helper for all the methods.
	TODO 4: FYI, I might refactor this after your done.	*/

@SuppressWarnings("unused")
public class SalesforceFacade {

	private LoginResponse logResp;

	public SalesforceFacade() {

	}

	public LoginResponse login(String userName, String password, String clientId, String SecretId) {
		SalesforceHelper sfHelper = new SalesforceHelper();
		if (logResp == null)
			logResp = sfHelper.sfLogin(userName, password, clientId, SecretId);
		return logResp;
	}

	public Offers getCustomer(String email) {

		CustomerHelper ch = new CustomerHelper();
		Offers offers = ch.getCustomer(logResp, email);

		return offers;
	}

	/* Not needed at this time
	 * public CustomerResponse postCustomer(CustomerRequest ccr) {

		CustomerHelper csf = new CustomerHelper();
		String scfResp = csf.postCustomer(logResp, ccr);

		return null;
	}*/

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
	
	public ApplicationResponse getContact(String email) {
		OLAHelper csfo = new OLAHelper();
		String csfoResp = csfo.getOLA(logResp, email);

		return null;
	}

	/* Not needed at this time
	 * public ApplicationResponse postContact(Contact con) {
		OLAHelper csfo = new OLAHelper();
		String csfoResp = csfo.postOLA(logResp, con);

		return null;
	}*/
}
