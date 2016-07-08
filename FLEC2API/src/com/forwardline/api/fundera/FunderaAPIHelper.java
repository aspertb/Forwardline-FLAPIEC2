package com.forwardline.api.fundera;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.StringEntity;

import com.forwardline.api.fundera.pojo.Offers;
import com.forwardline.api.fundera.pojo.Owners;
import com.forwardline.salesforce.SalesforceFacade;
import com.forwardline.salesforce.api.LoginResponse;
import com.google.gson.Gson;

@SuppressWarnings("unused")
public class FunderaAPIHelper {
	
	public static final String USERNAME = "shujaath.mohammed@forwardline.com.fldevapi";
	public static final String PASSWORD = "fl82NYla#";
	public static final String CLIENTID = "3MVG98dostKihXN46h.7UoAs4kwDqkPbYxSJTg2mThCWISAJ7AidlI9JFAlKri6iMPVwhCGpvxLtDWGfUR1Ey";
	public static final String SECRETID = "7786943219302079736";

	public FunderaAPIHelper() {

	}
	
	/*	TODO 1: Based on the fundera documentation determine what that root type is in the request. 
				The root type must passed as a parameter to this method
		TODO 2: Based on the fundera documentation, find the root type of the response and that 
				should be the return type for this method.*/

	public Offers getOffer(Owners owners) {
		Offers offrs = new Offers();

		Gson gson = new Gson();
		String clReq = gson.toJson(offrs);
		StringEntity strEty;
		try {
			strEty = new StringEntity(clReq);
			SalesforceFacade sfc = new SalesforceFacade();
			LoginResponse lr = sfc.login(USERNAME, PASSWORD, CLIENTID, SECRETID);
			// sfc.isCustomer("xyz@xyz.com");
			sfc.isCustomerExist("xyz@xyz.com");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offrs;
	}
}
