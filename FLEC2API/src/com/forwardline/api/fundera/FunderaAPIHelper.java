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
		Contact cont = new Contact();
		cont.setEmail(primaryOwner.getEmail());
		cont.setFirstName(primaryOwner.getFirst_name());
		cont.setLastName(primaryOwner.getLast_name());
		cont.setMobilePhone(primaryOwner.phone_number);
		cont.setPhone(primaryOwner.phone_number);
		cont.setDob(primaryOwner.getDob());
		cont.setSsn(primaryOwner.getSsn());
		String st = (primaryOwner.getStreet_line1() != null) ? primaryOwner.getStreet_line1() : "";
		st += (primaryOwner.getStreet_line2() != null) ? "\\n" + primaryOwner.getStreet_line2() : "";
		cont.setStreet(st);
		cont.setCity(primaryOwner.getCity());
		cont.setState(primaryOwner.getState());
		cont.setZip(primaryOwner.getZip());
		cont.setAnnualIncome(primaryOwner.getAnnual_income());
		cont.setOwnershipPercent(primaryOwner.getOwnership_pct());
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
		app.setAccountsReceivable(request.getCompany().getAccounts_receivable());
		app.setAnnualRevenue(request.getCompany().getAnnual_revenue());
		app.setAverageBankBalance(request.getCompany().getAverage_bank_balance());
		app.setBusinessDba(request.getCompany().getBusiness_dba());
		app.setBusinessInception(request.getCompany().getBusiness_inception());
		app.setBusinessName(request.getCompany().getBusiness_name());
		app.setEntityType(request.getCompany().getEntity_type());
		app.setIndustryId(request.getCompany().getIndustry_id());
		app.setLastBankruptcy(request.getCompany().getLast_bankruptcy());
		app.setLoanAmount(request.getCompany().getLoan_amount());
		app.setLastBankruptcy(request.getCompany().getLast_bankruptcy());
		app.setNumberOfEmployees(request.getCompany().getNumber_of_employees());
		app.setOutstandingTaxLien(request.getCompany().getOutstanding_tax_lien_bool());
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
				if (existingLead == null) {
					Lead newLead = sfFacade.createLead(merchant, partner);
					Contact con = sfFacade.createContact(primaryContact, partner);
					appl.setPrimaryContact(con);
					appl.setLead(newLead);
					Application newApplication = sfFacade.createApplication(appl, partner);
				} else {
					l = existingLead;
					// TODO: 1. Lookup and create contact. 2. lookup and create
					// application
				}
			}
		} catch (Exception e) {
			fndResponse.setSuccess(false);
		}
		return fndResponse;
	}
}
