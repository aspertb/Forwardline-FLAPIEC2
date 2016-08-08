package com.forwardline.api.fundera;

import java.util.ArrayList;
import java.util.List;

import com.forwardline.api.fundera.pojo.Company;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;
import com.forwardline.api.fundera.pojo.Person;
import com.forwardline.salesforce.SalesforceFacade;
import com.forwardline.salesforce.api.pojo.Application;
import com.forwardline.salesforce.api.pojo.Contact;
import com.forwardline.salesforce.api.pojo.Customer;
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
		Person guarantor = request.getOwners().get(0);
		Lead l = new Lead();
		l.setCompanyName(merchant.getBusiness_name());
		l.setPhone(merchant.getPhone_number());
		l.setEmail(guarantor.getEmail());
		l.setFirstName(guarantor.getFirst_name());
		l.setLastName(guarantor.getLast_name());
		l.setMobilePhone(guarantor.getPhone_number());

		return l;
	}

	private Contact getPrimaryContact(FunderaRequest request) {
		List<Person> owners = request.owners;
		Person primaryOwner = owners.get(0);
		// TODO. for future. how do we determine who the primary is when there
		// are multiple owners.
		Contact cont = new Contact();
		cont.setEmail(primaryOwner.getEmail());
		cont.setFirstName(primaryOwner.getFirst_name());
		cont.setLastName(primaryOwner.getLast_name());
		cont.setMobilePhone(primaryOwner.phone_number);
		cont.setPhone(primaryOwner.phone_number);

		return cont;
	}

	private Application getApplication(FunderaRequest request) {

		Application app = new Application();
		Contact primaryContact = getPrimaryContact(request);
		List<Contact> conList = new ArrayList<Contact>();
		Lead merchant = getLead(request);
		app.setPrimaryContact(primaryContact);
		conList.add(primaryContact);
		app.setGuarantors(conList);
		app.setLead(merchant);
		// app.setName(request.getCompany().business_name);
		// TODO Set Customer and Opportunity at the time of Application creation
		// app.setAccount(account);
		// app.setOpportunity(opportunity);
		return app;
	}

	public FunderaResponse getOffers(FunderaRequest request) {
		System.out.println("...Inside Get Offers - API Helper...");
		FunderaResponse fndResponse = new FunderaResponse();
		// TODO: For future. validations here. Assume happy path for now.

		Contact primaryContact = getPrimaryContact(request);
		Lead merchant = getLead(request);
		Application appl = getApplication(request);
		String partner = "Fundera";

		try {
			SalesforceFacade sfFacade = new SalesforceFacade();
			sfFacade.login(USERNAME, PASSWORD, CLIENTID, SECRETID);

			Customer c = sfFacade.getCustomer(merchant.getEmail(), partner);
			if (c != null) {
				Application app = sfFacade.getApplication(merchant.getEmail(), partner);
				if (app != null) {
					fndResponse.setSuccess(false);
					System.out.println("...application exists...");
					throw new RuntimeException("Application Already exists");
				} else {
					System.out.println("...App is Null...");
					Application newApp = new Application();
					appl.setAccount(c);
					newApp = sfFacade.createApplication(appl, partner);
				}
			} else {
				System.out.println("...Cust is Null...");
				Lead existingLead = sfFacade.getLead(merchant.getEmail(), partner);
				Lead l = new Lead();
				if (existingLead == null)
					l = sfFacade.createLead(merchant, partner);
				else
					l = existingLead;

				System.out.println("Lead when cust doesn't exist:- " + l.getEmail());

				Contact con = new Contact();
				Application newApp = new Application();

				con = sfFacade.createContact(primaryContact, partner);
				if (con != null) {
					// Create application
					appl.setAccount(c);
					newApp = sfFacade.createApplication(appl, partner);
				}
			}
		} catch (Exception e) {
			fndResponse.setSuccess(false);
		}
		return fndResponse;
	}
}
