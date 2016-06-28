package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.forwardline.salesforce.pojo.LoginResponse;
import com.google.gson.Gson;

public class RestLogin {
	public LoginResponse login(String userName, String password, String clientId, String clientSecret) {
		HttpClient http = HttpClients.createDefault();
		HttpPost post = new HttpPost("https://test.salesforce.com/services/oauth2/token");
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
		nameValuePairs.add(new BasicNameValuePair("client_id", clientId));
		nameValuePairs.add(new BasicNameValuePair("client_secret", clientSecret));
		nameValuePairs.add(new BasicNameValuePair("username", password));
		nameValuePairs.add(new BasicNameValuePair("password", userName));

		try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = http.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String json = "";
			String line = "";
			while ((line = rd.readLine()) != null)
				json = new StringBuffer(json).append(line).toString();

			System.out.println("Login response......");
			System.out.println(json);
			Gson gson = new Gson();
			LoginResponse lr = gson.fromJson(json, LoginResponse.class);
			System.out.println("Instance Url " + lr.getInstance_url());
			System.out.println("Access Token " + lr.getAccess_token());
			return lr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) {
		RestLogin l = new RestLogin();
		l.login("xyx", "xyx", "3122", "sdfsdfsdf");
	}
}
