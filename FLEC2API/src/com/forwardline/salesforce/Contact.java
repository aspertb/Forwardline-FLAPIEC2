package com.forwardline.salesforce;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.forwardline.salesforce.pojo.LoginResponse;

public class Contact {

	public Contact() {
	}

	/*public ContactResponse findCustomer(String id, LoginResponse loginResponse) {
		ContactResponse cr = null;
		HttpClient httpclient = HttpClients.createDefault();
		// HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/data/v31.0/query?");
		HttpGet get = new HttpGet(loginResponse.getInstance_url() + "/services/apexrest/forwardline/contact?");
		get.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		
		URIBuilder uriBuilder = new URIBuilder(get.getURI());
		// uriBuilder.addParameter("q", "SELECT Name, Id, Email, AccountId, Account.Name from Contact where Email = '" + email + "'");
		uriBuilder.addParameter("ID", id);

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
			System.out.println("This is JSON:- " +json);

			Gson gson = new Gson();
			cr = gson.fromJson(json.toString(), ContactResponse.class);
			System.out.println("This is CR:- ");
			System.out.println("Number of records Found " + cr.getTotalSize());
			com.forwardline.salesforce.pojo.Contact c = cr.getRecords().get(0);
			System.out.println("Name " + c.getName());
			System.out.println("Record Id " + c.getId());
			System.out.println("Account Id " + c.getAccountId());
			System.out.println("Account Name " + c.getAccount().getName());
			System.out.println("Contact URL " + c.getAttributes().getUrl());
			System.out.println("Email " + c.getEmail());
			System.out.println("This is CR:- ");
			System.out.println("Number of records Found " + cr.getRecordSize());
			com.forwardline.salesforce.pojo.nContact c = cr.getNContact();
			System.out.println("Name:- " + c.getName());
			System.out.println("Record Id:- " + c.getId());
			System.out.println("Account Id:- " + c.getAccountId());
			System.out.println("Account Name:- " + c.getAccountName());
			// System.out.println("Contact URL:- " + c.getAttributes().getUrl());
			System.out.println("Email:- " + c.getEmail());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cr;
	}*/
	
	public String postCust(LoginResponse loginResponse, HttpEntity ety) {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		String content = "";
		HttpPost post = new HttpPost(loginResponse.getInstance_url() + "/services/apexrest/forwardline/contact?");
		post.setHeader("Authorization", "OAuth " + loginResponse.getAccess_token());
		post.setHeader("Content-Type", "application/json");
		post.setEntity((HttpEntity)ety);

		try {
			System.out.println("This is my String Entity:- " +EntityUtils.toString(post.getEntity()));
			response = httpClient.execute(post);
		    HttpEntity respEntity = response.getEntity();
		    if (respEntity != null) {
		        // EntityUtils to get the response content
		        content =  EntityUtils.toString(respEntity);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	/*public static void main(String args[]) {

		RestLogin l = new RestLogin();
		LoginResponse loginResponse = l.login("", "", "", "");

		Contact c = new Contact();
		c.findCustomer("aeb501@mailinator.com", loginResponse);
	}*/
}
