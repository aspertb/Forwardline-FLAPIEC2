package com.forwardline.salesforce;

import org.apache.http.entity.StringEntity;
import com.forwardline.api.pojo.fundera.CreateLeadResponse;
import com.forwardline.salesforce.pojo.LoginResponse;
import com.google.gson.Gson;

public class SalesforceFacade {

	/* public Merchant findMerchant(String id) {
		Merchant merchant = new Merchant();
		RestLogin login = new RestLogin();
		Contact contSvc = new Contact();
		System.out.println("Before login");
		LoginResponse loginResponse = login.login(userName, password, clientId, secretId);

		ContactResponse sfResponse = contSvc.findCustomer(id, loginResponse);
		merchant.setName(sfResponse.getNContact().getName());
		merchant.setSalesforceRecordId(sfResponse.getNContact().getId());
		merchant.setAccountName(sfResponse.getNContact().getAccountName());
		merchant.setEmail(sfResponse.getNContact().getEmail());

		return merchant;
	}*/

	public CreateLeadResponse postMerchant(StringEntity string) {
		RestLogin login = new RestLogin();
		Contact contSvc = new Contact();
		System.out.println("Before login");
		LoginResponse loginResponse = login.getLoginRes();

		String sfResponse = contSvc.postCust(loginResponse, string);
		System.out.println("This is SF Response:- " + sfResponse);
		Gson gson = new Gson();
		CreateLeadResponse clr = gson.fromJson(sfResponse, CreateLeadResponse.class);
		return clr;
	}
}
