package com.forwardline.salesforce;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.api.pojo.fundera.CreateForsightRequest;
import com.forwardline.salesforce.pojo.LoginResponse;

public class ConnectSFForsight {

	public ConnectSFForsight() {

	}

	public String getForsight(LoginResponse loginResponse, String id) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/apexrest/forwardline/forsight?");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		get.setHeader("Content-Type", "application/json");

		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		uriBuilder.addParameter("id", id);

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

	public String postForsight(LoginResponse loginResponse, CreateForsightRequest cfr) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpPost post = new HttpPost(loginResponse.getInstance_url() + "/services/apexrest/forwardline/forsight?");
		post.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setEntity((HttpEntity) cfr);

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
