package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.api.fundera.pojo.Offers;
import com.forwardline.salesforce.api.CustomerRequest;
import com.forwardline.salesforce.api.LoginResponse;
import com.google.gson.Gson;

public class CustomerHelper {
	
	public CustomerHelper(){
		
	}
	
	public Offers getCustomer(LoginResponse loginResponse, String email) {
		Offers offers = null;
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/apexrest/forwardline/customer?");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		get.setHeader("Content-Type", "application/json");
		
		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		uriBuilder.addParameter("email", email);
		uriBuilder.addParameter("operation", "is_customer");

		try {
			response = httpClient.execute(get);
		    BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		    String in;
			StringBuffer json = new StringBuffer();

			while ((in = readResponse.readLine()) != null) {
				json.append(in);
			}
			Gson gson = new Gson();
			offers = gson.fromJson(json.toString(), Offers.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offers;
	}
	
	public String postCustomer(LoginResponse loginResponse, CustomerRequest cust) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpPost post = new HttpPost(loginResponse.getInstance_url() + "/services/apexrest/forwardline/customer?");
		post.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setEntity((HttpEntity)cust);
		
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
