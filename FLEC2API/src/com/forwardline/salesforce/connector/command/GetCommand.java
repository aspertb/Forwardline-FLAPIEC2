package com.forwardline.salesforce.connector.command;

import java.util.Map;

import org.apache.http.client.methods.HttpGet;

import com.forwardline.salesforce.api.pojo.SalesforceResponse;
import com.forwardline.salesforce.connector.exception.ServiceCalloutException;

public class GetCommand extends BaseHttpCommand {
	private Map<String, String> parameters;

	public GetCommand(String instanceUrl, String accessToken, Map<String, String> parameters) {
		super(instanceUrl, accessToken, null);
		this.parameters = parameters;
	}

	private String getQueryString(String instanceUrl) {
		StringBuffer query = new StringBuffer(instanceUrl);
		if (parameters != null && !parameters.isEmpty()) {
			query.append("?");
			boolean addSeperator = false;
			for (String key : parameters.keySet()) {
				if (addSeperator)
					query.append("&");
				query.append(key);
				query.append("=");
				query.append(parameters.get(key));
				addSeperator = true;
			}
		}
		return query.toString();
	}

	@Override
	public SalesforceResponse execute() throws ServiceCalloutException {
		HttpGet get = new HttpGet(getQueryString(getInstanceUrl()));
		get.addHeader("Authorization", "Bearer " + getAccessToken());
		return processRequest(get);
	}
}
