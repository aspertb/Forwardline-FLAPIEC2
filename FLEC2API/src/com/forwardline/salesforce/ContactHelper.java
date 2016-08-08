package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.salesforce.api.ContactRequest;
import com.forwardline.salesforce.api.ContactResponse;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Contact;
import com.forwardline.salesforce.api.pojo.SalesforceRequest;
import com.google.gson.Gson;

public class ContactHelper {
	public Contact createContact(LoginResponse sfLoginResponse, ContactRequest request) {
		String endpoint = new StringBuffer(sfLoginResponse.getInstance_url()).append("/services/apexrest/forwardline/contact").toString();
		request.getHeader().setOperation("create_contact");
		try {
			URIBuilder uriBuilder = new URIBuilder(endpoint);
			URI uri = uriBuilder.build();

			HttpPost post = new HttpPost(uri);
			post.setHeader("Authorization", "OAuth " + sfLoginResponse.getAccess_token());
			post.setHeader("Content-Type", "application/json");
			post.setHeader("Partner", request.getHeader().getPartner());

			Gson gs = new Gson();
			SalesforceRequest<ContactRequest> sr = new SalesforceRequest<ContactRequest>();
			sr.setRequest(request);
			String strEntity = gs.toJson(sr);
			System.out.println("ContactHelper.createContact :: JSON");
			System.out.println(strEntity);
			// post.setEntity((HttpEntity) strEty);
			post.setEntity(new StringEntity(strEntity, ContentType.APPLICATION_JSON));

			try {
				HttpClient httpClient = HttpClients.createDefault();
				HttpResponse response = httpClient.execute(post);
				BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String in;
				StringBuffer json = new StringBuffer();
				while ((in = readResponse.readLine()) != null)
					json.append(in);
				
				System.out.println("ContactHelper.createContact output");
				System.out.println(json);
				
				Gson gson = new Gson();
				ContactResponse cntResponse = gson.fromJson(json.toString(), ContactResponse.class);
				return cntResponse.getContact();
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
