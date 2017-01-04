package com.forwardline.salesforce.connector.port;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.forwardline.salesforce.connector.exception.ServiceCalloutException;
import com.forwardline.salesforce.connector.types.SalesforceSession;
import com.google.gson.Gson;

public class SalesforceLoginPort {
	private String loginEndPoint;
	private String userName;
	private String password;
	private String securityToken;
	private String clientId;
	private String clientSecret;

	public SalesforceLoginPort(String loginEndPoint, String userName, String password, String securityToken, String clientId, String clientSecret) {
		super();
		this.loginEndPoint = loginEndPoint;
		this.userName = userName;
		this.password = password;
		this.securityToken = securityToken;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public SalesforceSession getSession() throws ServiceCalloutException {
		// -Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2 System param

		// System.setProperty(“https.protocols”, “TLSv1,TLSv1.1,TLSv1.2”);
		// System property
		/*
		 * Runtime try { SSLContext ctx = SSLContext.getInstance("TLSv1.2");
		 * ctx.init(null, null, null); SSLContext.setDefault(ctx); } catch
		 * (Exception e) {
		 * 
		 * }
		 */

		StringBuffer pwdToken = new StringBuffer(password).append(securityToken);
		HttpClient http = HttpClients.createDefault();
		HttpPost post = new HttpPost(loginEndPoint);

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
		nameValuePairs.add(new BasicNameValuePair("client_id", clientId));
		nameValuePairs.add(new BasicNameValuePair("client_secret", clientSecret));
		nameValuePairs.add(new BasicNameValuePair("username", userName));
		nameValuePairs.add(new BasicNameValuePair("password", pwdToken.toString()));

		try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = http.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String json = "";
			String line = "";
			while ((line = rd.readLine()) != null)
				json = new StringBuffer(json).append(line).toString();
			
			System.out.println(json);
			Gson gson = new Gson();
			SalesforceSession sfSession = gson.fromJson(json, SalesforceSession.class);
			return sfSession;

		} catch (ClientProtocolException cpe) {
			throw new ServiceCalloutException(cpe.getMessage());
		} catch (IOException ioe) {
			throw new ServiceCalloutException(ioe.getMessage());
		}
	}
}
