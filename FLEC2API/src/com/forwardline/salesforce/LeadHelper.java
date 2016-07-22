package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.forwardline.salesforce.api.LeadLookupResponse;
import com.forwardline.salesforce.api.LeadRequest;
import com.forwardline.salesforce.api.LeadResponse;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Lead;
import com.google.gson.Gson;

public class LeadHelper {

	public LeadHelper() {

	}

	public Lead getLead(LoginResponse sfLoginResponse, String email, String partner) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("operation", "is_existing_lead"));

		String endpoint = new StringBuffer(sfLoginResponse.getInstance_url())
				.append("/services/apexrest/forwardline/lead").toString();

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
			LeadLookupResponse llkResponse = gson.fromJson(json.toString(), LeadLookupResponse.class);
			return llkResponse.getLead();
		} catch (Exception e) {
			// todo: throw custome exception.
			e.printStackTrace();
		}
		return null;
	}

	public Lead createLead(LoginResponse sfLoginResponse, LeadRequest request) {

		LeadRequest lr = new LeadRequest();
		Gson gs = new Gson();
		String clReq = gs.toJson(lr);
		StringEntity strEty = null;
		try {
			strEty = new StringEntity(clReq);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		request.getHeader().setOperation("create_lead");
		String endpoint = new StringBuffer(sfLoginResponse.getInstance_url())
				.append("/services/apexrest/forwardline/lead").toString();
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(endpoint);
		post.setHeader("Authorization", "OAuth " + sfLoginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setHeader("Partner", request.getHeader().getPartner());
		post.setEntity((HttpEntity) strEty);
		try {
			HttpResponse response = httpClient.execute(post);
			BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String in;
			StringBuffer json = new StringBuffer();
			while ((in = readResponse.readLine()) != null)
				json.append(in);
			Gson gson = new Gson();
			LeadResponse leadRes = new LeadResponse();
			if (json != null){
				leadRes = gson.fromJson(json.toString(), LeadResponse.class);
				return leadRes.getnLead();
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
