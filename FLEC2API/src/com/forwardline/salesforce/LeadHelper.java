package com.forwardline.salesforce;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.salesforce.api.LeadRequest;
import com.forwardline.salesforce.api.LoginResponse;

public class LeadHelper {
	
public LeadHelper(){
		
	}
	
	public String getLead(LoginResponse loginResponse, String email) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/apexrest/forwardline/lead?");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		get.setHeader("Content-Type", "application/json");
		
		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		uriBuilder.addParameter("email", email);

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
	
	public String postLead(LoginResponse loginResponse, LeadRequest lead) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpPost post = new HttpPost(loginResponse.getInstance_url() + "/services/apexrest/forwardline/lead?");
		post.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setEntity((HttpEntity)lead);
		
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
