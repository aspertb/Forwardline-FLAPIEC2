package com.forwardline.api.client.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.forwardline.salesforce.connector.port.SalesforceLoginPort;

public class LoginTest {

	public LoginTest() {
		// TODO Auto-generated constructor stub
	}

	public static void testLogin() throws Exception{
		SalesforceLoginPort port = new SalesforceLoginPort("https://login.salesforce.com/services/oauth2/token", "system.user@forwardline.com", "Test1234$", "aoKIaP59IdD12Vy4uDV7HtGW",
				"3MVG9yZ.WNe6byQCe00.NEderVkB.tNuLjVIAr.aFV378PRx.0xbZQSaOc1QoQ7CKAIrMkLl6afWG86yj7YLH", "5660911029810400280");
		port.getSession();
	}
	
	public static void login() throws Exception {/*
		HttpClient http = HttpClients.createDefault();
		//HttpPost post = new HttpPost("https://esbidcddp030.ivdc.kp.org:2008/service/hp_admin/sales_acctmgmt/SalesConnect/EnterpriseRestToken/v1");
		HttpPost post = new HttpPost("http://esbidcddp030.ivdc.kp.org:2007/service/hp_admin/sales_acctmgmt/SalesConnect/EnterpriseRestToken/v1");
		//HttpPost post = new HttpPost("https://test.salesforce.com/services/oauth2/token");
		
		//post.setHeader("Authorization", "Basic " + Base64.encodeBase64String(StringUtils.getBytesUtf8("KS10029" + "V3kaiser")));
		//post.setHeader("Authorization", "Basic S1MxMDAyOTpWM2thaXNlcg==");
		post.setHeader("Authorization", "Basic S1MxMDE0Mjp4X0NSNyNVeGZ4bWc=");
		//post.setHeader("Content-Type", "application/json"); application/x-www-form-urlencoded
		//post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
		nameValuePairs.add(new BasicNameValuePair("client_id", "3MVG9dPGzpc3kWyfIA0hKosSiRrA1rfT_9cLm8ObByqwDunqT3RMDVnwRsRwoGpbFAJNjL73o38sO93i6Fwfi"));
		nameValuePairs.add(new BasicNameValuePair("client_secret", "7748253437319228799"));
		nameValuePairs.add(new BasicNameValuePair("username", "aspert.e.benjamin@kp.org.dev"));//Put the user name
		nameValuePairs.add(new BasicNameValuePair("password", "Java1123qtO5M0obLnLOkYMvIHB926Sh")); //Password + token
		nameValuePairs.add(new BasicNameValuePair("esb-region", "SCAL"));
		
		try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			System.out.println(post.getParams());
			BufferedReader rd1 = new BufferedReader(new InputStreamReader(post.getEntity().getContent()));
			String json1 = "";
			String line1 = "";
			while ((line1 = rd1.readLine()) != null) {
				System.out.println(line1);
				json1 = new StringBuffer(json1).append(line1).toString();
			}
			System.out.println(json1);
			
			HttpResponse response = http.execute(post);

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String json = "";
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
				json = new StringBuffer(json).append(line).toString();
			}

			System.out.println("Login response......");
			System.out.println(json);
			//Gson gson = new Gson();
			//LoginResponse lr = gson.fromJson(json, LoginResponse.class);
			//System.out.println("Instance Url " + lr.getInstance_url());
			//System.out.println("Access Token " + lr.getAccess_token());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		HttpClient http = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://esbidcddp030.ivdc.kp.org:2007/service/hp_admin/sales_acctmgmt/SalesConnect/EnterpriseRestToken/v1");
		
		//post.setHeader("Authorization", "Basic " + Base64.encodeBase64(StringUtils.getBytesUtf8("KS10029FdngNlYGIL3Q")));
		post.setHeader("Authorization", "Basic S1MxMDAyOTpGZG5nTmxZR0lMM1E=");
		//post.setHeader("ESB-Auth", "Basic "+Base64.encodeBase64String(StringUtils.getBytesUtf8("KS10029:V3kaiser")));
		//post.setHeader("Content-Type", "application/json");
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
		nameValuePairs.add(new BasicNameValuePair("client_id", "3MVG9dPGzpc3kWyfIA0hKosSiRrA1rfT_9cLm8ObByqwDunqT3RMDVnwRsRwoGpbFAJNjL73o38sO93i6Fwfi"));
		nameValuePairs.add(new BasicNameValuePair("client_secret", "7748253437319228799"));
		nameValuePairs.add(new BasicNameValuePair("username", "satheeshkumar.venkatachalam@kp.org.dev"));//Put the user name
		nameValuePairs.add(new BasicNameValuePair("password", "Vsatheesh3UhHd9DBHPeFp3Zq78HUUdgAK")); //Password + token
		//nameValuePairs.add(new BasicNameValuePair("username", "aspert.e.benjamin@kp.org.dev"));//Put the user name
		//nameValuePairs.add(new BasicNameValuePair("password", "Java1123qtO5M0obLnLOkYMvIHB926Sh")); //Password + token
		//nameValuePairs.add(new BasicNameValuePair("esb-region", "NCAL"));

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
			//Gson gson = new Gson();
			//LoginResponse lr = gson.fromJson(json, LoginResponse.class);
			//System.out.println("Instance Url " + lr.getInstance_url());
			//System.out.println("Access Token " + lr.getAccess_token());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//testLogin();
		/*
		String s = Base64.encodeBase64(StringUtils.getBytesUtf8("KS10029:V3kaiser"));
		System.out.println(s);
		System.out.println(StringUtils.newStringUtf8(Base64.decodeBase64(s)));
		
		s = "S1MxMDAyOTpGZG5nTmxZR0lMM1E=";
		System.out.println(StringUtils.newStringUtf8(Base64.decodeBase64(s)));*/
		login();
	}
}
