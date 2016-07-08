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
import com.forwardline.salesforce.api.ContactLookupResponse;
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

	// SET APPROPRIATE VALUE FOR OPERATION VALUE IN ORDER TO USE IT.
	public Offers isCustomerExist(String email) {

		CustomerHelper ch = new CustomerHelper();
		Offers offers = ch.getCustomer(logResp, email);

		return offers;
	}
	
	/*public Boolean isCustomer(String email) {

		CustomerHelper ch = new CustomerHelper();
		Boolean isCust = ch.isCustomer(logResp, email);

		return isCust;
	}*/

	/* Not needed at this time
	 * public CustomerResponse postCustomer(CustomerRequest ccr) {

		CustomerHelper csf = new CustomerHelper();
		String scfResp = csf.postCustomer(logResp, ccr);

		return null;
	}*/

	public ForsightResponse lookupForsight(String id) {

		ForsightHelper csf = new ForsightHelper();
		ForsightResponse scfResp = csf.getForsight(logResp, id);

		return scfResp;
	}

	public ForsightResponse runAnalysis(ForsightRequest cfr) {

		ForsightHelper csf = new ForsightHelper();
		ForsightResponse scfResp = csf.postForsight(logResp, cfr);

		return scfResp;
	}

	public LeadResponse isExistingLead(String email) {

		LeadHelper csfl = new LeadHelper();
		LeadResponse csflResp = csfl.getLead(logResp, email);

		return null;
	}

	public LeadResponse createLead(LeadRequest clr) {
		LeadHelper csfl = new LeadHelper();
		LeadResponse csflResp = csfl.postLead(logResp, clr);

		return csflResp;
	}
	
	public LeadResponse convertLead(LeadRequest clr) {
		LeadHelper csfl = new LeadHelper();
		LeadResponse csflResp = csfl.convertLead(logResp, clr);

		return csflResp;
	}

	public ApplicationResponse hasApplication(String id) {
		OLAHelper olaH = new OLAHelper();
		ApplicationResponse aResp = olaH.getOLA(logResp, id);

		return aResp;
	}

	public ApplicationResponse createApplication(ApplicationRequest cor) {
		OLAHelper olaH = new OLAHelper();
		ApplicationResponse aResp = olaH.postOLA(logResp, cor);

		return aResp;
	}
	
	public ContactLookupResponse isContactExist(String email) {
		ContactHelper ch = new ContactHelper();
		ContactLookupResponse chResp = ch.getContact(logResp, email);

		return chResp;
	}

	// Not needed at this time
	  /*public ApplicationResponse createContact(ApplicationRequest con) {
		OLAHelper csfo = new OLAHelper();
		ApplicationResponse csfoResp = csfo.postOLA(logResp, con);

		return null;
	}*/
}
