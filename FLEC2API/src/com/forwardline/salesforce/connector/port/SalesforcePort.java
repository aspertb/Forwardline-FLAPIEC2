package com.forwardline.salesforce.connector.port;

import java.util.HashMap;
import java.util.Map;

import com.forwardline.salesforce.connector.command.BaseHttpCommand;
import com.forwardline.salesforce.connector.command.GetCommand;
import com.forwardline.salesforce.connector.command.PostCommand;
import com.forwardline.salesforce.connector.exception.InvalidSessionException;
import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.types.Application;
import com.forwardline.salesforce.connector.types.ApplicationLookupResponse;
import com.forwardline.salesforce.connector.types.ApplicationRequest;
import com.forwardline.salesforce.connector.types.ApplicationResponse;
import com.forwardline.salesforce.connector.types.Contact;
import com.forwardline.salesforce.connector.types.ContactRequest;
import com.forwardline.salesforce.connector.types.ContactResponse;
import com.forwardline.salesforce.connector.types.Customer;
import com.forwardline.salesforce.connector.types.CustomerLookupResponse;
import com.forwardline.salesforce.connector.types.ForsightDecision;
import com.forwardline.salesforce.connector.types.ForsightRequest;
import com.forwardline.salesforce.connector.types.ForsightResponse;
import com.forwardline.salesforce.connector.types.Lead;
import com.forwardline.salesforce.connector.types.LeadLookupResponse;
import com.forwardline.salesforce.connector.types.LeadRequest;
import com.forwardline.salesforce.connector.types.LeadResponse;
import com.forwardline.salesforce.connector.types.RequestHeader;
import com.forwardline.salesforce.connector.types.SalesforceRequest;
import com.forwardline.salesforce.connector.types.SalesforceResponse;
import com.forwardline.salesforce.connector.types.SalesforceSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SalesforcePort {
	private static final String ENDPOINT_CONTACT = "/services/apexrest/forwardline/contact";
	private static final String ENDPOINT_CUSTOMER = "/services/apexrest/forwardline/customer";
	private static final String ENDPOINT_LEAD = "/services/apexrest/forwardline/lead";
	private static final String ENDPOINT_OLA = "/services/apexrest/forwardline/ola";
	private static final String ENDPOINT_FORSIGHT = "/services/apexrest/forwardline/forsight";

	private SalesforceSession session;

	public SalesforcePort(SalesforceSession session) {
		this.session = session;
	}

	public Contact createContact(ContactRequest request) throws ServiceCalloutException, InvalidSessionException {
		StringBuffer url = new StringBuffer(session.getInstance_url()).append(ENDPOINT_CONTACT);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SalesforceRequest<ContactRequest> sr = new SalesforceRequest<ContactRequest>();
		sr.setRequest(request);
		String json = gson.toJson(sr);
		BaseHttpCommand command = new PostCommand(url.toString(), session.getAccess_token(), json);
		SalesforceResponse response = command.execute();
		if (response.getStatusCode() == 200) {
			ContactResponse contactResponse = gson.fromJson(response.getJson(), ContactResponse.class);
			return contactResponse.getContact();
		} else
			throw new ServiceCalloutException(response.getErrorMessage());
	}

	public Customer getCustomer(String email, String partner) throws ServiceCalloutException, InvalidSessionException {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("email", email);
		parameters.put("operation", "is_customer");
		String endpoint = new StringBuffer(session.getInstance_url()).append(ENDPOINT_CUSTOMER).toString();
		BaseHttpCommand command = new GetCommand(endpoint, session.getAccess_token(), parameters);
		SalesforceResponse response = command.execute();
		if (response.getStatusCode() == 200) {
			Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
			CustomerLookupResponse custLkpResponse = gson.fromJson(response.getJson(), CustomerLookupResponse.class);
			return custLkpResponse.getCustomer();
		} else
			throw new ServiceCalloutException(response.getErrorMessage());
	}

	public Application getApplication(String email, String partner) throws ServiceCalloutException, InvalidSessionException {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("email", email);
		parameters.put("operation", "has_application");

		String endpoint = new StringBuffer(session.getInstance_url()).append(ENDPOINT_OLA).toString();
		BaseHttpCommand command = new GetCommand(endpoint, session.getAccess_token(), parameters);
		SalesforceResponse response = command.execute();

		if (response.getStatusCode() == 200) {
			Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
			ApplicationLookupResponse applkResponse = gson.fromJson(response.getJson(), ApplicationLookupResponse.class);
			return applkResponse.getApplication();
		} else
			throw new ServiceCalloutException(response.getErrorMessage());
	}

	public Application createApplication(ApplicationRequest request) throws ServiceCalloutException, InvalidSessionException {
		String endpoint = new StringBuffer(session.getInstance_url()).append(ENDPOINT_OLA).toString();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SalesforceRequest<ApplicationRequest> sr = new SalesforceRequest<ApplicationRequest>();
		sr.setRequest(request);
		String json = gson.toJson(sr);
		BaseHttpCommand command = new PostCommand(endpoint.toString(), session.getAccess_token(), json);
		SalesforceResponse response = command.execute();
		if (response.getStatusCode() == 200) {
			ApplicationResponse appResponse = gson.fromJson(response.getJson(), ApplicationResponse.class);
			return appResponse.getApplication();
		} else
			throw new ServiceCalloutException(response.getErrorMessage());
	}

	public Lead getLead(String email, String partner) throws ServiceCalloutException, InvalidSessionException {
		String endpoint = new StringBuffer(session.getInstance_url()).append(ENDPOINT_LEAD).toString();
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("email", email);
		parameters.put("operation", "is_existing_lead");

		BaseHttpCommand command = new GetCommand(endpoint, session.getAccess_token(), parameters);
		SalesforceResponse response = command.execute();

		if (response.getStatusCode() == 200) {
			Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
			LeadLookupResponse leadLookupResponse = gson.fromJson(response.getJson(), LeadLookupResponse.class);
			return leadLookupResponse.getnLead();
		} else
			throw new ServiceCalloutException(response.getErrorMessage());
	}

	public Lead createLead(LeadRequest request) throws ServiceCalloutException, InvalidSessionException {
		String endpoint = new StringBuffer(session.getInstance_url()).append(ENDPOINT_LEAD).toString();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SalesforceRequest<LeadRequest> sr = new SalesforceRequest<LeadRequest>();
		sr.setRequest(request);
		String json = gson.toJson(sr);
		BaseHttpCommand command = new PostCommand(endpoint.toString(), session.getAccess_token(), json);
		SalesforceResponse response = command.execute();

		if (response.getStatusCode() == 200) {
			LeadResponse leadResponse = gson.fromJson(response.getJson(), LeadResponse.class);
			return leadResponse.getnLead();
		} else
			throw new ServiceCalloutException(response.getErrorMessage());
	}

	public ForsightDecision scoreApplication(ForsightRequest request) throws ServiceCalloutException, InvalidSessionException {
		String endpoint = new StringBuffer(session.getInstance_url()).append(ENDPOINT_FORSIGHT).toString();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SalesforceRequest<ForsightRequest> sr = new SalesforceRequest<ForsightRequest>();
		sr.setRequest(request);
		String json = gson.toJson(sr);
		BaseHttpCommand command = new PostCommand(endpoint.toString(), session.getAccess_token(), json);
		SalesforceResponse response = command.execute();

		if (response.getStatusCode() == 200) {
			ForsightResponse forsightResponse = gson.fromJson(response.getJson(), ForsightResponse.class);
			return forsightResponse.getDecision();
		} else
			throw new ServiceCalloutException(response.getErrorMessage());
	}
}
