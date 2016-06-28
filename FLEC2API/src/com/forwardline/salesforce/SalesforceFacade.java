package com.forwardline.salesforce;

import com.forwardline.api.pojo.Merchant;
import com.forwardline.salesforce.pojo.ContactResponse;
import com.forwardline.salesforce.pojo.LoginResponse;

public class SalesforceFacade {

	public SalesforceFacade() {
		// TODO Auto-generated constructor stub
	}

	public Merchant findMerchant(String email) {
		Merchant merchant = new Merchant();
		RestLogin login = new RestLogin();
		Contact contSvc = new Contact();
		LoginResponse loginResponse = login.login("", "", "", "");
		ContactResponse sfResponse = contSvc.findCustomer(email, loginResponse);
		merchant.setName(sfResponse.getRecords().get(0).getName());
		merchant.setSalesforceRecordId(sfResponse.getRecords().get(0).getId());
		merchant.setAccountName(sfResponse.getRecords().get(0).getAccount().getName());
		merchant.setEmail(sfResponse.getRecords().get(0).getEmail());
		return merchant;
	}
}
