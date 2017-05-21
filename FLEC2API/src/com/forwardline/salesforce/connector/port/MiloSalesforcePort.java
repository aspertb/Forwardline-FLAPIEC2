package com.forwardline.salesforce.connector.port;

import com.forwardline.api.milo.types.ApplicationRequest;
import com.forwardline.api.milo.types.ApplicationResponse;
import com.forwardline.salesforce.connector.command.BaseHttpCommand;
import com.forwardline.salesforce.connector.command.PostCommand;
import com.forwardline.salesforce.connector.exception.InvalidSessionException;
import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.types.SalesforceRequest;
import com.forwardline.salesforce.connector.types.SalesforceResponse;
import com.forwardline.salesforce.connector.types.SalesforceSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MiloSalesforcePort {
	private static final String ENDPOINT_PROCESS_APPLICATION = "/services/apexrest/forwardline/submit_application";

	private SalesforceSession session;

	public MiloSalesforcePort(SalesforceSession session) {
		this.session = session;
	}

	public ApplicationResponse processApplication(ApplicationRequest request) throws ServiceCalloutException, InvalidSessionException {
		StringBuffer url = new StringBuffer(session.getInstance_url()).append(ENDPOINT_PROCESS_APPLICATION);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SalesforceRequest<ApplicationRequest> sr = new SalesforceRequest<ApplicationRequest>();
		sr.setRequest(request);
		String json = gson.toJson(sr);
		BaseHttpCommand command = new PostCommand(url.toString(), session.getAccess_token(), json);
		SalesforceResponse response = command.execute();
		if (response.getStatusCode() == 200) {
			ApplicationResponse applicationResponse = gson.fromJson(response.getJson(), ApplicationResponse.class);
			return applicationResponse;
		} else
			throw new ServiceCalloutException(response.getErrorMessage()); 
	}
}
