package com.forwardline.api.fundera.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.forwardline.api.fundera.FunderaAPIHelper;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;

@Path("/fundera/")
public class FunderaService {
	@POST
	@Path("/getOffer/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public FunderaResponse getOffer(FunderaRequest fndRequest) {
		FunderaAPIHelper fndHelper = new FunderaAPIHelper();
		return fndHelper.getOffers(fndRequest);
	}
}
