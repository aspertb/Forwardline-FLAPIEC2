package com.forwardline.api.client.samples;

import com.forwardline.api.pojo.fundera.CreateLeadRequest;
import com.forwardline.api.pojo.fundera.CreateLeadResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class FunderaServiceClient {
	private static void getOffers(String endpoint) {
		try {
			String signature = null;

			CreateLeadRequest request = new CreateLeadRequest();
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client.resource(endpoint);
			ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, request);
			System.out.println(response.toString());
			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			CreateLeadResponse clr = response.getEntity(CreateLeadResponse.class);

			System.out.println("Server response .... \n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//getOffers("http://awstest-env.us-west-2.elasticbeanstalk.com/partner/fundera/getOffer");
		getOffers("http://localhost:8080/partner/fundera/getOffer");
	}
}
