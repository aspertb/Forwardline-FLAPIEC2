package com.forwardline.salesforce.connector.port;

import java.util.HashMap;
import java.util.Map;

import com.forwardline.salesforce.api.ContactRequest;
import com.forwardline.salesforce.api.pojo.RequestHeader;
import com.forwardline.salesforce.api.pojo.SalesforceRequest;
import com.forwardline.salesforce.api.pojo.SalesforceResponse;
import com.forwardline.salesforce.api.pojo.SalesforceSession;
import com.forwardline.salesforce.connector.command.BaseHttpCommand;
import com.forwardline.salesforce.connector.command.GetCommand;
import com.forwardline.salesforce.connector.command.PostCommand;
import com.forwardline.salesforce.connector.exception.InvalidSessionException;
import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SalesforcePort {
	private static final String ENDPOINT_CONTACT = "/services/apexrest/forwardline/contact";
	private static final String ENDPOINT_CUSTOMER = "/services/apexrest/forwardline/customer";
	private static final String ENDPOINT_LEAD = "/services/apexrest/forwardline/lead";
	private static final String ENDPOINT_OLA = "/services/apexrest/forwardline/olsr";
	private static final String ENDPOINT_FORSIGHT = "/services/apexrest/forwardline/forsight";

	private SalesforceSession session;

	public SalesforcePort(SalesforceSession session) {
		this.session = session;
	}

	public SalesforceResponse createContact(SalesforceSession session, ContactRequest request, String partner) throws ServiceCalloutException, InvalidSessionException {
		RequestHeader header = new RequestHeader();
		header.setPartner(partner);
		header.setOperation("create_application");
		request.setHeader(header);
		StringBuffer url = new StringBuffer(session.getInstance_url()).append(ENDPOINT_CONTACT);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SalesforceRequest<ContactRequest> sr = new SalesforceRequest<ContactRequest>();
		sr.setRequest(request);
		String json = gson.toJson(sr);
		BaseHttpCommand command = new PostCommand(url.toString(), session.getAccess_token(), json);
		SalesforceResponse response = command.execute();
		return response;
	}

	public SalesforceResponse getCustomer(SalesforceSession session, String email, String partner) throws ServiceCalloutException, InvalidSessionException {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("email", email);
		parameters.put("operation", "is_customer");
		String endpoint = new StringBuffer(session.getInstance_url()).append(ENDPOINT_CUSTOMER).toString();
		BaseHttpCommand command = new GetCommand(endpoint, session.getAccess_token(), parameters);
		SalesforceResponse response = command.execute();
		return response;
	}

}
