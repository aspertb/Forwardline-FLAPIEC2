package com.forwardline.salesforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import com.forwardline.salesforce.api.ForsightRequest;
import com.forwardline.salesforce.api.ForsightResponse;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Analysis;
import com.forwardline.salesforce.api.pojo.ForsightDecision;
import com.forwardline.salesforce.api.pojo.SalesforceRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ForsightHelper {

	public ForsightDecision scoreApplication(LoginResponse sfLoginResponse, ForsightRequest request) {
		request.getHeader().setOperation("start_scoring");
		String endpoint = new StringBuffer(sfLoginResponse.getInstance_url()).append("/services/apexrest/forwardline/forsight").toString();
		try {
			URIBuilder uriBuilder = new URIBuilder(endpoint);
			URI uri = uriBuilder.build();
			HttpPost post = new HttpPost(uri);
			post.setHeader("Authorization", "OAuth " + sfLoginResponse.getAccess_token());
			post.setHeader("Content-Type", "application/json");
			post.setHeader("Partner", request.getHeader().getPartner());

			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			SalesforceRequest<ForsightRequest> sr = new SalesforceRequest<ForsightRequest>();
			sr.setRequest(request);
			String strEntity = gson.toJson(sr);
			post.setEntity(new StringEntity(strEntity, ContentType.APPLICATION_JSON));

			HttpClient httpClient = HttpClients.createDefault();
			ForsightResponse fsResponse = new ForsightResponse();
			fsResponse.setDecision(new ForsightDecision());
			fsResponse.getDecision().setAnalysis(new Analysis());
			fsResponse.getDecision().getAnalysis().setBranchingComplete(false);
			while (!fsResponse.getDecision().getAnalysis().getBranchingComplete()) {
				System.out.println("Current branch \\n" + request.getHeader().getOperation());
				System.out.println("Branch input \\n" + strEntity);
				HttpResponse response = httpClient.execute(post);
				BufferedReader readResponse = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String in;
				StringBuffer json = new StringBuffer();
				while ((in = readResponse.readLine()) != null)
					json.append(in);
				System.out.println("Response \\n" + json);
				if (json != null) {
					fsResponse = gson.fromJson(json.toString(), ForsightResponse.class);
					if (fsResponse.isSuccess()) {
						if (!fsResponse.getDecision().getAnalysis().getBranchingComplete()) {
							uriBuilder = new URIBuilder(endpoint);
							uri = uriBuilder.build();
							post = new HttpPost(uri);
							post.setHeader("Authorization", "OAuth " + sfLoginResponse.getAccess_token());
							post.setHeader("Content-Type", "application/json");
							post.setHeader("Partner", request.getHeader().getPartner());

							httpClient = HttpClients.createDefault();

							request.getHeader().setOperation(fsResponse.getDecision().getAnalysis().getNextStep());
							sr = new SalesforceRequest<ForsightRequest>();
							if (fsResponse.getDecision().getAnalysis() != null)
								request.setAnalysis(fsResponse.getDecision().getAnalysis());
							sr.setRequest(request);
							strEntity = gson.toJson(sr);
							post.setEntity(new StringEntity(strEntity, ContentType.APPLICATION_JSON));
							continue;
						}
					} else
						throw new Exception("Scoring error!!! " + fsResponse.getErrorMessage());
				}
			}
			return fsResponse.getDecision();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
