package com.forwardline.salesforce.connector.command;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.types.SalesforceResponse;

public class PostCommand extends BaseHttpCommand {

	public PostCommand(String instanceUrl, String accessToken, String json) {
		super(instanceUrl, accessToken, json);
	}

	@Override
	public SalesforceResponse execute() throws ServiceCalloutException {
		HttpPost post = new HttpPost(getInstanceUrl());
		post.addHeader("Authorization", "Bearer " + getAccessToken());
		post.addHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(getJson(), ContentType.APPLICATION_JSON));
		return processRequest(post);
	}
}
