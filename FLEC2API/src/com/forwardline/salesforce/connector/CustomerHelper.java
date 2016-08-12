package com.forwardline.salesforce.connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.forwardline.salesforce.connector.types.Customer;
import com.forwardline.salesforce.connector.types.CustomerLookupResponse;
import com.forwardline.salesforce.connector.types.LoginResponse;
import com.google.gson.Gson;

public class CustomerHelper {

	public CustomerHelper() {

	}

	public Customer getCustomer(LoginResponse sfLoginResponse, String email, String partner) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("operation", "is_customer"));

		String endpoint = new StringBuffer(sfLoginResponse.getInstance_url())
				.append("/services/apexrest/forwardline/customer").toString();

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
				throw new RuntimeException("...exception from getCustomer...");
			}
			BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String in;
			StringBuffer json = new StringBuffer();
			while ((in = readResponse.readLine()) != null)
				json.append(in);
			Gson gson = new Gson();
			CustomerLookupResponse clkResponse = gson.fromJson(json.toString(), CustomerLookupResponse.class);
			System.out.println("..Customer Helper.. getCustomer()" + clkResponse.getCustomer());
			return clkResponse.getCustomer();
		} catch (Exception e) {
			// todo: throw custome exception.
			e.printStackTrace();
		}
		return null;
	}

}
