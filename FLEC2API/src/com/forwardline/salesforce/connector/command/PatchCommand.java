package com.forwardline.salesforce.connector.command;

import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.types.SalesforceResponse;

public class PatchCommand extends BaseHttpCommand {
	public PatchCommand(String instanceUrl, String accessToken, String json) {
		super(instanceUrl, accessToken, json);
	}

	@Override
	public SalesforceResponse execute() throws ServiceCalloutException {
		HttpPatch patch = new HttpPatch(getInstanceUrl());
		patch.addHeader("Authorization", "Bearer " + getAccessToken());
		patch.addHeader("Content-Type", "application/json");
		patch.setEntity(new StringEntity(getJson(), ContentType.APPLICATION_JSON));
		return processRequest(patch);
	}
}
