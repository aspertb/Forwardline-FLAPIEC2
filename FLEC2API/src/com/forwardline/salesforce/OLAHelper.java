package com.forwardline.salesforce;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.salesforce.api.ApplicationRequest;
import com.forwardline.salesforce.api.ApplicationResponse;
import com.forwardline.salesforce.api.LoginResponse;

public class OLAHelper {
	
	public ApplicationResponse getOLA(LoginResponse loginResponse, String id) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/apexrest/forwardline/ola?");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		get.setHeader("Content-Type", "application/json");

		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		uriBuilder.addParameter("id", id);
		uriBuilder.addParameter("operation", "has_application");

		try {
			response = httpClient.execute(get);
			HttpEntity respEntity = response.getEntity();
			if (respEntity != null) {
				// EntityUtils to get the response content
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ApplicationResponse postOLA(LoginResponse loginResponse, ApplicationRequest cor) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpPost post = new HttpPost(loginResponse.getInstance_url() + "/services/apexrest/forwardline/ola?");
		post.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setEntity((HttpEntity) cor);
		
		URIBuilder uriBuilder = new URIBuilder(post.getURI());
		uriBuilder.addParameter("operation", "create_application");

		try {
			response = httpClient.execute(post);
			HttpEntity respEntity = response.getEntity();
			if (respEntity != null) {
				// EntityUtils to get the response content
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
