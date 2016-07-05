package com.forwardline.api.client.samples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.forwardline.api.fundera.pojo.TestClientReq;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class FunderaServiceClient {
	private static void getOffers() {
		Gson gson = new Gson();
		try {
			TestClientReq request = new TestClientReq();
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client.resource("http://localhost:8080/FLEC2API/partner/fundera/getOffer");

			FileInputStream f = new FileInputStream("sampleReqMininfied.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(f));

			String inputLine;
			StringBuffer json = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				json.append(inputLine);
			}
			if (json != null) {
				request = gson.fromJson(json.toString(), TestClientReq.class);
			}

			ClientResponse response = webResource.accept("application/json").type("application/json")
					.post(ClientResponse.class, request);

			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			// CreateLeadResponse res = response.getEntity(CreateLeadResponse.class);
			System.out.println("Server response .... \n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// getOffers("http://forwardlineec2api-env.us-west-2.elasticbeanstalk.com/partner/fundera/getOffer");
		System.out.println("Inside Main");
		// getOffers("http://localhost:8080/FLEC2API/partner/fundera/getOffer");
		getOffers();
	}
}
