package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.salesforce.api.LeadRequest;
import com.forwardline.salesforce.api.LeadResponse;
import com.forwardline.salesforce.api.LoginResponse;
import com.google.gson.Gson;

public class LeadHelper {
	
public LeadHelper(){
		
	}
	
	public LeadResponse getLead(LoginResponse loginResponse, String email) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		LeadResponse lead = new LeadResponse();
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/apexrest/forwardline/lead?");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		get.setHeader("Content-Type", "application/json");
		
		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		uriBuilder.addParameter("email", email);
		uriBuilder.addParameter("operation", "is_existing_lead");

		try {
			response = httpClient.execute(get);
			BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String in;
			StringBuffer json = new StringBuffer();

			while ((in = readResponse.readLine()) != null) {
				json.append(in);
			}
			Gson gson = new Gson();
			lead = gson.fromJson(json.toString(), LeadResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lead;
	}
	
	public LeadResponse postLead(LoginResponse loginResponse, LeadRequest l) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		LeadResponse lead = new LeadResponse();
		HttpPost post = new HttpPost(loginResponse.getInstance_url() + "/services/apexrest/forwardline/lead?");
		post.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setEntity((HttpEntity)l);
		
		URIBuilder uriBuilder = new URIBuilder(post.getURI());
		uriBuilder.addParameter("operation", "create_lead");
		
		try {
			response = httpClient.execute(post);
			BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String in;
			StringBuffer json = new StringBuffer();

			while ((in = readResponse.readLine()) != null) {
				json.append(in);
			}
			Gson gson = new Gson();
			lead = gson.fromJson(json.toString(), LeadResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lead;
	}
	
	public LeadResponse convertLead(LoginResponse loginResponse, LeadRequest lead) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpPut put = new HttpPut(loginResponse.getInstance_url() + "/services/apexrest/forwardline/lead?");
		put.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		put.setHeader("Content-Type", "application/json");
		put.setEntity((HttpEntity)lead);
		
		URIBuilder uriBuilder = new URIBuilder(put.getURI());
		uriBuilder.addParameter("operation", "convert_lead");
		
		try {
			response = httpClient.execute(put);
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
