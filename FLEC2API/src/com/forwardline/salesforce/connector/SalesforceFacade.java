package com.forwardline.salesforce.connector;

import com.forwardline.exception.ConnectorException;
import com.forwardline.salesforce.connector.exception.InvalidSessionException;
import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.port.SalesforceLoginPort;
import com.forwardline.salesforce.connector.port.SalesforcePort;
import com.forwardline.salesforce.connector.types.Analysis;
import com.forwardline.salesforce.connector.types.Application;
import com.forwardline.salesforce.connector.types.ApplicationLookupResponse;
import com.forwardline.salesforce.connector.types.ApplicationRequest;
import com.forwardline.salesforce.connector.types.ApplicationResponse;
import com.forwardline.salesforce.connector.types.Contact;
import com.forwardline.salesforce.connector.types.ContactRequest;
import com.forwardline.salesforce.connector.types.ContactResponse;
import com.forwardline.salesforce.connector.types.CustomerLookupResponse;
import com.forwardline.salesforce.connector.types.ForsightDecision;
import com.forwardline.salesforce.connector.types.ForsightRequest;
import com.forwardline.salesforce.connector.types.ForsightResponse;
import com.forwardline.salesforce.connector.types.Lead;
import com.forwardline.salesforce.connector.types.LeadLookupResponse;
import com.forwardline.salesforce.connector.types.LeadRequest;
import com.forwardline.salesforce.connector.types.LeadResponse;
import com.forwardline.salesforce.connector.types.RequestHeader;
import com.forwardline.salesforce.connector.types.SalesforceSession;

public class SalesforceFacade {

	private SalesforceSession session;

	public SalesforceFacade() {

	}

	public void login(String loginEndPoint, String userName, String password, String securityToken, String clientId, String clientSecret) throws ConnectorException {
		if (session == null) {
			SalesforceLoginPort port = new SalesforceLoginPort(loginEndPoint, userName, password, securityToken, clientId, clientSecret);
			try {
				this.session = port.getSession();
			} catch (ServiceCalloutException se) {
				throw new ConnectorException(se.getMessage());
			}
		}
	}

	public CustomerLookupResponse getCustomer(String email, String partner) throws ConnectorException {
		SalesforcePort port = new SalesforcePort(session);
		try {
			return port.getCustomer(email, partner);
		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
	}

	public LeadLookupResponse getLead(String email, String partner) throws ConnectorException {
		SalesforcePort port = new SalesforcePort(session);
		try {
			return port.getLead(email, partner);
		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
	}

	public LeadResponse createLead(Lead lead, String partner) throws ConnectorException {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		header.setOperation("create_lead");
		LeadRequest request = new LeadRequest(header, lead);
		SalesforcePort port = new SalesforcePort(session);
		try {
			return port.createLead(request);
		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
	}

	public ApplicationLookupResponse getApplication(String email, String partner) throws ConnectorException {
		SalesforcePort port = new SalesforcePort(session);
		try {
			return port.getApplication(email, partner);
		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
	}

	public ApplicationResponse createApplication(Application application, String partner) throws ConnectorException {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		header.setOperation("create_application");
		ApplicationRequest request = new ApplicationRequest();
		request.setApplication(application);
		request.setHeader(header);
		SalesforcePort port = new SalesforcePort(session);
		try {
			return port.createApplication(request);
		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
	}

	public ForsightResponse scoreApplication(Application application, String partner) throws ConnectorException {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		header.setOperation("start_scoring");
		ForsightRequest request = new ForsightRequest();
		request.setApplication(application);
		request.setHeader(header);

		SalesforcePort port = new SalesforcePort(session);
		ForsightDecision decision = new ForsightDecision();
		decision.setAnalysis(new Analysis());
		decision.getAnalysis().setBranchingComplete(false);
		ForsightResponse response = null;
		try {
			while (!decision.getAnalysis().getBranchingComplete()) {
				response = port.scoreApplication(request);
				if (!response.isSuccess())
					return response;
				decision = response.getDecision();
				if (decision.getAnalysis() != null)
					request.setAnalysis(decision.getAnalysis());
				if (!decision.getAnalysis().getBranchingComplete()) {
					request.getHeader().setOperation(decision.getAnalysis().getNextStep());
				} else
					break;
			}
		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
		return response;
	}

	public ContactResponse createContact(Contact contact, String partner) throws ConnectorException {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		header.setOperation("create_contact");
		ContactRequest request = new ContactRequest();
		request.setContact(contact);
		request.setHeader(header);
		SalesforcePort port = new SalesforcePort(session);
		try {
			return port.createContact(request);
		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
	}

	/*
	 * public LoginResponse login(String userName, String password, String
	 * clientId, String SecretId) { SalesforceHelper sfHelper = new
	 * SalesforceHelper(); if (sfLoginResponse == null) sfLoginResponse =
	 * sfHelper.sfLogin(userName, password, clientId, SecretId); return
	 * sfLoginResponse; }
	 * 
	 * public Customer getCustomer(String email, String partner) {
	 * System.out.println("...Inside SF Facade getCustomer..." + email);
	 * CustomerHelper helper = new CustomerHelper(); return
	 * helper.getCustomer(sfLoginResponse, email, partner); }
	 * 
	 * public Lead getLead(String email, String partner) { LeadHelper helper =
	 * new LeadHelper(); return helper.getLead(sfLoginResponse, email, partner);
	 * }
	 * 
	 * public Lead createLead(Lead lead, String partner) { RequestHeader header
	 * = new RequestHeader(); header.setPartner(partner); LeadRequest request =
	 * new LeadRequest(header, lead); LeadHelper helper = new LeadHelper();
	 * return helper.createLead(sfLoginResponse, request); }
	 * 
	 * public Application getApplication(String email, String partner) {
	 * OLAHelper helper = new OLAHelper(); return
	 * helper.getApplication(sfLoginResponse, email, partner); }
	 * 
	 * public Application createApplication(Application application, String
	 * partner) { RequestHeader header = new RequestHeader();
	 * header.setPartner(partner); header.setOperation("create_application");
	 * ApplicationRequest request = new ApplicationRequest();
	 * request.setApplication(application); request.setHeader(header); OLAHelper
	 * helper = new OLAHelper(); return
	 * helper.createApplication(sfLoginResponse, request); }
	 * 
	 * public ForsightDecision scoreApplication(Application application, String
	 * partner) { RequestHeader header = new RequestHeader();
	 * header.setPartner(partner); header.setOperation("start_scoring");
	 * ForsightRequest request = new ForsightRequest();
	 * request.setApplication(application); request.setHeader(header);
	 * ForsightHelper helper = new ForsightHelper(); return
	 * helper.scoreApplication(sfLoginResponse, request); }
	 * 
	 * public Contact createContact(Contact contact, String partner) {
	 * RequestHeader header = new RequestHeader(); header.setPartner(partner);
	 * ContactRequest request = new ContactRequest();
	 * request.setContact(contact); request.setHeader(header); ContactHelper
	 * helper = new ContactHelper(); return
	 * helper.createContact(sfLoginResponse, request); }
	 */
}
