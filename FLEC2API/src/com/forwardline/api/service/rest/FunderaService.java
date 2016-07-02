package com.forwardline.api.service.rest;

import java.io.UnsupportedEncodingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.http.entity.StringEntity;
import com.forwardline.api.pojo.fundera.TestClientReq;
import com.forwardline.api.pojo.fundera.TestClientResp;
import com.forwardline.salesforce.SalesforceFacade;
import com.google.gson.Gson;

@Path("/fundera/")
public class FunderaService {

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
