package com.forwardline.api.fundera;

import java.util.List;

import com.forwardline.api.fundera.pojo.Company;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;
import com.forwardline.api.fundera.pojo.Person;
import com.forwardline.salesforce.SalesforceFacade;
import com.forwardline.salesforce.api.LoginResponse;
import com.forwardline.salesforce.api.pojo.Contact;
import com.forwardline.salesforce.api.pojo.Lead;

@SuppressWarnings("unused")
public class FunderaAPIHelper {

	public static final String USERNAME = "shujaath.mohammed@forwardline.com.fldevapi";
	public static final String PASSWORD = "fl82NYla#";
	public static final String CLIENTID = "3MVG98dostKihXN46h.7UoAs4kwDqkPbYxSJTg2mThCWISAJ7AidlI9JFAlKri6iMPVwhCGpvxLtDWGfUR1Ey";
	public static final String SECRETID = "7786943219302079736";

	public FunderaAPIHelper() {

	}

	private Lead getLead(FunderaRequest request) {
		Company merchant = request.company;
		Lead l = new Lead();
		l.setCompanyName(merchant.getBusiness_name());
		// TODO: set other fields
		return l;
	}

	private Contact getPrimaryContact(FunderaRequest request) {
		List<Person> owners = request.owners;
		Person primaryOwner = owners.get(0);
		// TODO. for future. how do we determine who the primary is when there
		// are multiple owners.
		Contact cont = new Contact();
		cont.setEmail(primaryOwner.getEmail());
		// TODO: fillin in the other fields
		return cont;
	}

	public FunderaResponse getOffers(FunderaRequest request) {
		FunderaResponse fndResponse = new FunderaResponse();
		// TODO: For future. validations here. Assume happy path for now.

		Contact primaryContact = getPrimaryContact(request);
		Lead merchant = getLead(request);
		try {
			SalesforceFacade sfFacade = new SalesforceFacade();
			sfFacade.login(USERNAME, PASSWORD, CLIENTID, SECRETID);
			
		} catch (Exception e) {
			fndResponse.setSuccess(false);
		}

		/**
		 * ????? Offer offrs = new Offer();
		 * 
		 * Gson gson = new Gson(); String clReq = gson.toJson(offrs);
		 * StringEntity strEty; try { strEty = new StringEntity(clReq);
		 * SalesforceFacade sfc = new SalesforceFacade(); LoginResponse lr =
		 * sfc.login(USERNAME, PASSWORD, CLIENTID, SECRETID); //
		 * sfc.isCustomer("xyz@xyz.com"); sfc.isCustomerExist("xyz@xyz.com");
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 **/
		return fndResponse;
	}
}
