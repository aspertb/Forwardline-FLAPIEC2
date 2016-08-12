package com.forwardline.salesforce.connector;

import com.forwardline.salesforce.connector.types.Application;
import com.forwardline.salesforce.connector.types.ApplicationRequest;
import com.forwardline.salesforce.connector.types.Contact;
import com.forwardline.salesforce.connector.types.ContactRequest;
import com.forwardline.salesforce.connector.types.Customer;
import com.forwardline.salesforce.connector.types.ForsightDecision;
import com.forwardline.salesforce.connector.types.ForsightRequest;
import com.forwardline.salesforce.connector.types.Lead;
import com.forwardline.salesforce.connector.types.LeadRequest;
import com.forwardline.salesforce.connector.types.LoginResponse;
import com.forwardline.salesforce.connector.types.RequestHeader;

public class SalesforceFacade {

	private LoginResponse sfLoginResponse;

	public SalesforceFacade() {

	}

	public LoginResponse login(String userName, String password, String clientId, String SecretId) {
		SalesforceHelper sfHelper = new SalesforceHelper();
		if (sfLoginResponse == null)
			sfLoginResponse = sfHelper.sfLogin(userName, password, clientId, SecretId);
		return sfLoginResponse;
	}

	public Customer getCustomer(String email, String partner) {
		System.out.println("...Inside SF Facade getCustomer..." + email);
		CustomerHelper helper = new CustomerHelper();
		return helper.getCustomer(sfLoginResponse, email, partner);
	}

	public Lead getLead(String email, String partner) {
		LeadHelper helper = new LeadHelper();
		return helper.getLead(sfLoginResponse, email, partner);
	}

	public Lead createLead(Lead lead, String partner) {
		RequestHeader header = new RequestHeader(); 
		header.setPartner(partner);
		LeadRequest request = new LeadRequest(header, lead);
		LeadHelper helper = new LeadHelper();
		return helper.createLead(sfLoginResponse, request);
	}

	public Application getApplication(String email, String partner) {
		OLAHelper helper = new OLAHelper();
		return helper.getApplication(sfLoginResponse, email, partner);
	}

	public Application createApplication(Application application, String partner) {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		header.setOperation("create_application");
		ApplicationRequest request = new ApplicationRequest();
		request.setApplication(application);
		request.setHeader(header);
		OLAHelper helper = new OLAHelper();
		return helper.createApplication(sfLoginResponse, request);
	}

	public ForsightDecision scoreApplication(Application application, String partner) {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		header.setOperation("start_scoring");
		ForsightRequest request = new ForsightRequest();
		request.setApplication(application);
		request.setHeader(header);
		ForsightHelper helper = new ForsightHelper();
		return helper.scoreApplication(sfLoginResponse, request);
	}

	public Contact createContact(Contact contact, String partner) {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		ContactRequest request = new ContactRequest();
		request.setContact(contact);
		request.setHeader(header);
		ContactHelper helper = new ContactHelper();
		return helper.createContact(sfLoginResponse, request);
	}
}
