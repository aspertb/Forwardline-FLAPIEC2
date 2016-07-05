package com.forwardline.api.fundera.service.rest;

import java.io.UnsupportedEncodingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.http.entity.StringEntity;

import com.forwardline.api.fundera.pojo.TestClientReq;
import com.forwardline.api.fundera.pojo.TestClientResp;
import com.forwardline.salesforce.SalesforceFacade;
import com.google.gson.Gson;

@Path("/fundera/")
public class FunderaService {
	
	//TODO 1: Based on the fundera documentation determine what that root type is in the request. The root type must passed as a parameter to this method
	//TODO 2: Based on the fundera documentation, find the root type of the response and that should be the return type for this method.
	//TODO 3: This method should just call the FunderaAPIHelper.getOffer methods and return whatever that method returns.
	@POST
	@Path("/getOffer/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TestClientResp getOffer(TestClientReq request) {
		TestClientResp res = new TestClientResp();
		Gson gson = new Gson();
		String clReq = gson.toJson(request);
		StringEntity strEty;
		try {
			strEty = new StringEntity(clReq);
			System.out.println("This is post body:- " +strEty);
			SalesforceFacade sfc = new SalesforceFacade();
			
			// res = sfc.postMerchant(strEty);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fundera service called!!!");
		return res;
	}
}
