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

import com.forwardline.salesforce.api.ContactLookupResponse;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Contact;
import com.google.gson.Gson;

public class ContactHelper {
	
	public ContactLookupResponse getContact(LoginResponse loginResponse, String email) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/apexrest/forwardline/contact?");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		get.setHeader("Content-Type", "application/json");

		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		uriBuilder.addParameter("email", email);
		uriBuilder.addParameter("operation", "create_contact");

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

	public Contact postContact(LoginResponse loginResponse, Contact con) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		HttpPost post = new HttpPost(loginResponse.getInstance_url() + "/services/apexrest/forwardline/ola?");
		post.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setEntity((HttpEntity) con);
		
		URIBuilder uriBuilder = new URIBuilder(post.getURI());
		uriBuilder.addParameter("operation", "create_contact");
		Contact retCon = new Contact();

		try {
			response = httpClient.execute(post);
			BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String in;
			StringBuffer json = new StringBuffer();

			while ((in = readResponse.readLine()) != null) {
				json.append(in);
			}
			Gson gson = new Gson();
			retCon = gson.fromJson(json.toString(), Contact.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retCon;
	}

}
