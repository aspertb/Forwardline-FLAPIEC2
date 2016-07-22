package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.forwardline.salesforce.api.ApplicationLookupResponse;
import com.forwardline.salesforce.api.ApplicationRequest;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Application;
import com.google.gson.Gson;

public class OLAHelper {
	public Application getApplication(LoginResponse sfLoginResponse, String email, String partner) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("operation", "has_application"));

		String endpoint = new StringBuffer(sfLoginResponse.getInstance_url())
				.append("/services/apexrest/forwardline/ola").toString();

		try {
			URIBuilder uriBuilder = new URIBuilder(endpoint);
			uriBuilder.addParameters(params);
			URI uri = uriBuilder.build();
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Authorization", "OAuth " + sfLoginResponse.getAccess_token());
			httpGet.setHeader("Content-Type", "application/json");
			httpGet.setHeader("Partner", partner);

			HttpClient httpClient = HttpClients.createDefault();
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() != 200) {
				// TODO: throw exception
			}
			BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String in;
			StringBuffer json = new StringBuffer();
			while ((in = readResponse.readLine()) != null)
				json.append(in);
			Gson gson = new Gson();
			ApplicationLookupResponse applkResponse = gson.fromJson(json.toString(), ApplicationLookupResponse.class);
			EntityUtils.consume(response.getEntity());
			return applkResponse.getApplication();
		} catch (Exception e) {
			// todo: throw custome exception.
			e.printStackTrace();
		}
		return null;
	}

	public Application createApplication(LoginResponse sfLoginResponse, ApplicationRequest request) {
		String endpoint = new StringBuffer(sfLoginResponse.getInstance_url())
				.append("/services/apexrest/forwardline/ola").toString();
		request.getHeader().setOperation("create_application");
		try {
			URIBuilder uriBuilder = new URIBuilder(endpoint);
			URI uri = uriBuilder.build();

			HttpPost post = new HttpPost(uri);
			post.setHeader("Authorization", "OAuth " + sfLoginResponse.getAccess_token());
			post.setHeader("Content-Type", "application/json");
			post.setHeader("Partner", request.getHeader().getPartner());
			post.setEntity((HttpEntity)request);
			System.out.println("This is my post entity:- " +post.getEntity().getClass().getName());

			try {
				HttpClient httpClient = HttpClients.createDefault();
				HttpResponse response = httpClient.execute(post);
				HttpEntity respEntity = response.getEntity();
				String content = null;
				if (respEntity != null) {
					// EntityUtils to get the response content
				}
				BufferedReader readResponse = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));
				String in;
				StringBuffer json = new StringBuffer();
				while ((in = readResponse.readLine()) != null)
					json.append(in);
				Gson gson = new Gson();
				ApplicationLookupResponse applkResponse = gson.fromJson(json.toString(),
						ApplicationLookupResponse.class);
				EntityUtils.consume(respEntity);
				return applkResponse.getApplication();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// todo: throw custome exception.
			e.printStackTrace();
		}
		return null;
	}
}
