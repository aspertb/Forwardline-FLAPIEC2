package com.forwardline.api.fundera;

import java.util.ArrayList;
import java.util.List;

import com.forwardline.api.fundera.pojo.Company;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;
import com.forwardline.api.fundera.pojo.Person;
import com.forwardline.salesforce.SalesforceFacade;
import com.forwardline.salesforce.api.LoginResponse;
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

		return cont;
	}

	private Application getApplication(FunderaRequest request) {

		Application app = new Application();
		Contact primaryContact = getPrimaryContact(request);

		List<Contact> conList = new ArrayList<Contact>();

		Lead merchant = getLead(request);

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

			// Get customer using Primary contact's email address
			Customer c = sfFacade.getCustomer(merchant.getEmail(), partner);
			
			System.out.println("Cust is returned:- " +sfFacade.getCustomer(merchant.getEmail(), partner));
			
			Lead existingLead = sfFacade.getLead(merchant.getEmail(), partner);

			// If customer exist, look for application using merchant's email
			if (c != null) {
				Application app = sfFacade.getApplication(merchant.getEmail(), partner);

				// If application exisit, throw error
				if (app != null) {
					fndResponse.setSuccess(false);
					System.out.println("...application exists...");
					throw new RuntimeException("Application Already exists");

				} else {

					// Create Lead, and then create an Application

					Lead l;
					Application newApp;

					if (existingLead == null)
						l = sfFacade.createLead(merchant, partner);

					else
						l = existingLead;
					
					System.out.println("Lead when cust exist:- " + l.getEmail());

					if (l != null) {
						appl.setAccount(c);
						newApp = sfFacade.createApplication(appl, partner);
					}
				}
			} else {

				// If customer doesn't exist - Create Lead/contact/application

				Lead l;
				if (existingLead == null)
					l = sfFacade.createLead(merchant, partner);
				else
					l = existingLead;
				
				System.out.println("Lead when cust doesn't exist:- " + l.getEmail());

				Contact con;
				Application newApp;

				if (l != null) {

					// Create contact
					con = sfFacade.createContact(primaryContact, partner);
					if (con != null) {

						// Create application
						appl.setAccount(c);
						newApp = sfFacade.createApplication(appl, partner);
					}
				}

			}

		} catch (Exception e) {
			fndResponse.setSuccess(false);
		}
		return fndResponse;
	}
}
