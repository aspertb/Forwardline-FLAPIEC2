package com.forwardline.salesforce.connector.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.types.SalesforceResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseHttpCommand {
	private String instanceUrl;
	private String accessToken;
	private String json;

	public BaseHttpCommand(String instanceUrl, String accessToken, String json) {
		super();
		this.instanceUrl = instanceUrl;
		this.accessToken = accessToken;
		this.json = json;
	}

	public String getInstanceUrl() {
		return instanceUrl;
	}

	public void setInstanceUrl(String instanceUrl) {
		this.instanceUrl = instanceUrl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getResponseBody(HttpResponse response) throws ServiceCalloutException {
		StringBuffer json = new StringBuffer();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null)
				json.append(line);
		} catch (IOException e) {
			throw new ServiceCalloutException(e);
		}
		return json.toString();
	}

	public SalesforceResponse processRequest(HttpRequestBase httpMethod) throws ServiceCalloutException {
		HttpClient http = HttpClients.createDefault();
		try {
			HttpResponse response = http.execute(httpMethod);
			String responseBody = getResponseBody(response);
			SalesforceResponse svcResponse = null;
			if (response.getStatusLine().getStatusCode() != 200) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				svcResponse = gson.fromJson(responseBody, SalesforceResponse.class);
			} else {
				svcResponse = new SalesforceResponse();
				svcResponse.setJson(responseBody);
			}
			svcResponse.setStatusCode(response.getStatusLine().getStatusCode());
			return svcResponse;
		} catch (ClientProtocolException cpe) {
			throw new ServiceCalloutException(cpe);
		} catch (IOException ioe) {
			throw new ServiceCalloutException(ioe);
		}
	}

	public abstract SalesforceResponse execute() throws ServiceCalloutException;
}
