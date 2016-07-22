package com.forwardline.salesforce;

import com.forwardline.salesforce.api.ApplicationRequest;
import com.forwardline.salesforce.api.ContactRequest;
import com.forwardline.salesforce.api.LeadRequest;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Application;
import com.forwardline.salesforce.api.pojo.Contact;
import com.forwardline.salesforce.api.pojo.Customer;
import com.forwardline.salesforce.api.pojo.Lead;
import com.forwardline.salesforce.api.pojo.RequestHeader;

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
		System.out.println("...Inside SF Facade getCustomer..." +email);
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
