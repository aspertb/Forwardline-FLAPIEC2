package com.forwardline.api.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.forwardline.api.pojo.fundera.CreateLeadRequest;
import com.forwardline.api.pojo.fundera.CreateLeadResponse;

@Path("/fundera")
public class FunderaService {

	@POST
	@Path("/getOffer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreateLeadResponse getOffer(CreateLeadRequest request) {
		CreateLeadResponse res = new CreateLeadResponse();
		System.out.println("Fundera service called!!!");
		return res;
	}

}
