package com.forwardline.api.fundera.service.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.forwardline.api.fundera.FunderaAPIHelper;
import com.forwardline.api.fundera.pojo.Offers;
import com.forwardline.api.fundera.pojo.Owners;

@Path("/fundera/")
public class FunderaService {
	
	/*	TODO 1: Based on the fundera documentation determine what that root type is in the request. 
	 			The root type must passed as a parameter to this method
		TODO 2: Based on the fundera documentation, find the root type of the response and that should be the return type for this method.
		TODO 3: This method should just call the FunderaAPIHelper.getOffer methods and return whatever that method returns.*/
	@POST
	@Path("/getOffer/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Offers> getOffer(List<Owners> ownersList, String opr) {
		
		List<Offers> oList = new ArrayList<Offers>();
		FunderaAPIHelper fHelper = new FunderaAPIHelper();
		oList = fHelper.getOffer(ownersList);
		System.out.println("Returning list of offers...");
		
		return oList;
		
	}
}
