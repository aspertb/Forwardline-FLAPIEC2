package com.forwardline.api.milo;

import com.forwardline.api.milo.types.Analysis;
import com.forwardline.api.milo.types.Application;
import com.forwardline.api.milo.types.ApplicationRequest;
import com.forwardline.api.milo.types.ApplicationResponse;
import com.forwardline.exception.ConnectorException;
import com.forwardline.salesforce.connector.exception.InvalidSessionException;
import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.port.MiloSalesforcePort;
import com.forwardline.salesforce.connector.port.SalesforceLoginPort;
import com.forwardline.salesforce.connector.types.RequestHeader;
import com.forwardline.salesforce.connector.types.SalesforceSession;

public class MiloFacade {
	private SalesforceSession session;

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

	public String processApplication(Application nApplication) throws ConnectorException, ConnectorException {
		RequestHeader header = new RequestHeader();
		header.setOperation("qf process");

		ApplicationRequest request = new ApplicationRequest();
		request.setnApplication(nApplication);
		request.setHeader(header);

		MiloSalesforcePort port = new MiloSalesforcePort(session); 
		ApplicationResponse response = null;
		try {
			response = port.processApplication(request);
			if (!response.isSuccess())
				throw new ConnectorException(response.getError());

			while (!response.getnApplication().getAnalysis().isBranchingComplete()) {
				Analysis analysis = response.getnApplication().getAnalysis();
				if (!analysis.isBranchingComplete()) {
					header.setOperation(analysis.getNextStep());
					request.setHeader(header);

					response = port.processApplication(request);

					if (!response.isSuccess())
						throw new ConnectorException(response.getError());
				} else
					break;
			}

			if (response.getRedirectUrl() == null)
				throw new ConnectorException("Invalid redirect endpoint from milo.");

		} catch (ServiceCalloutException se) {
			throw new ConnectorException(se.getMessage());
		} catch (InvalidSessionException ive) {
			throw new ConnectorException(ive.getMessage());
		}
		return response.getRedirectUrl();
	}
}
