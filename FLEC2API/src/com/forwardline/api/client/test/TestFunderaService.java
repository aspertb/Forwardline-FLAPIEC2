package com.forwardline.api.client.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.forwardline.api.fundera.FunderaAPIHelper;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;
import com.forwardline.api.fundera.pojo.Offer;
import com.forwardline.util.APIUtil;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class TestFunderaService {
	private static void getOffers(String endPoint) {

		try {
			// String signature = null;

			FunderaRequest request = new FunderaRequest();
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client.resource(endPoint);

			//FileInputStream f = new FileInputStream("sampleReqMininfied.txt");
			FileInputStream f = new FileInputStream("C:\\Development_Code\\GitRepositories\\git\\Forwardline-FLAPIEC2\\FLEC2API\\FunderaSample2.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(f));

			String inputLine;
			StringBuffer json = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				json.append(inputLine);
			}
			br.close();
			if (json != null) {
				Gson gson = new Gson();
				request = gson.fromJson(json.toString(), FunderaRequest.class);
			}

			String s = "FunderAPIUser:1472676134675";
			ClientResponse response = webResource.accept("application/json").type("application/json").header("Authorization", "Basic " + APIUtil.encode(s)).post(ClientResponse.class, request);

			//System.out.println(response.getEntity(String.class));

			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus() + " - " + response.getHeaders());
			FunderaResponse res = response.getEntity(FunderaResponse.class);
			List<Offer> offersList = res.getOffers();

			if (offersList != null) {
				System.out.println("...Offers returned successfully...");
			}

			System.out.println("Server response .... \n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testAPIHelper() {

		try {
			FunderaRequest request = new FunderaRequest();
			FileInputStream f = new FileInputStream("C:\\Development_Code\\GitRepositories\\git\\Forwardline-FLAPIEC2\\FLEC2API\\FunderaSample2.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(f));

			String inputLine;
			StringBuffer json = new StringBuffer("");

			while ((inputLine = br.readLine()) != null) {
				json.append(inputLine);
			}
			br.close();
			if (json != null) {
				Gson gson = new Gson();
				request = gson.fromJson(json.toString(), FunderaRequest.class);
			}
			FunderaAPIHelper helper = new FunderaAPIHelper();

			FunderaResponse res = helper.getOffers(request);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getOffers("http://forwardlineec2api-env.us-west-2.elasticbeanstalk.com/partner/fundera/getOffer");
		System.out.println("Inside Main");
		// getOffers("http://localhost:8080/FLEC2API/partner/fundera/getOffer");
		//getOffers("http://localhost:8080/FLAPIEC2/partner/fundera/getOffer");
		//testAPIHelper();
	}
}
