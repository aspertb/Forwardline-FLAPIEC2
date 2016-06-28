package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.salesforce.pojo.ContactResponse;
import com.forwardline.salesforce.pojo.LoginResponse;
import com.google.gson.Gson;

public class Contact {

	public Contact() {
	}

	public ContactResponse findCustomer(String email, LoginResponse loginResponse) {
		ContactResponse cr = null;
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/data/v31.0/query");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());

		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		uriBuilder.addParameter("q", "SELECT Name, Id, Email, AccountId, Account.Name from Contact where Email = '" + email + "'");

		try {
			((HttpRequestBase) get).setURI(uriBuilder.build());
			HttpResponse response = httpclient.execute(get);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String inputLine;
			StringBuffer json = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				json.append(inputLine);
			}
			System.out.println("Lookup response......");
			System.out.println(json);

			Gson gson = new Gson();
			cr = gson.fromJson(json.toString(), ContactResponse.class);
			System.out.println("Number of records Found " + cr.getTotalSize());
			com.forwardline.salesforce.pojo.Contact c = cr.getRecords().get(0);
			System.out.println("Name " + c.getName());
			System.out.println("Record Id " + c.getId());
			System.out.println("Account Id " + c.getAccountId());
			System.out.println("Account Name " + c.getAccount().getName());
			System.out.println("Contact URL " + c.getAttributes().getUrl());
			System.out.println("Email " + c.getEmail());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cr;
	}

	public static void main(String args[]) {

		RestLogin l = new RestLogin();
		LoginResponse loginResponse = l.login("", "", "", "");

		Contact c = new Contact();
		c.findCustomer("aeb501@mailinator.com", loginResponse);
	}
}
