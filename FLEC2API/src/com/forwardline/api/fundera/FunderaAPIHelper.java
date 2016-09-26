package com.forwardline.api.fundera;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.forwardline.api.fundera.pojo.Company;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;
import com.forwardline.api.fundera.pojo.Offer;
import com.forwardline.api.fundera.pojo.Person;
import com.forwardline.api.persistence.APIPropertiesDAO;
import com.forwardline.exception.InternalServerException;
import com.forwardline.salesforce.connector.SalesforceFacade;
import com.forwardline.salesforce.connector.types.Application;
import com.forwardline.salesforce.connector.types.Contact;
import com.forwardline.salesforce.connector.types.ForsightDecision;
import com.forwardline.salesforce.connector.types.Lead;
import com.forwardline.util.IFLAPIConstants;

@SuppressWarnings("unused")
public class FunderaAPIHelper {

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

	private Contact getContact(Person p) {
		Contact cont = new Contact();
		cont.setEmail(p.getEmail());
		cont.setFirstName(p.getFirst_name());
		cont.setLastName(p.getLast_name());
		cont.setMobilePhone(p.phone_number);
		cont.setPhone(p.phone_number);
		cont.setDob(p.getDate_of_birth());
		cont.setSsn(p.getSsn());
		String st = (p.getStreet_line1() != null) ? p.getStreet_line1() : "";
		cont.setStreet(st);
		cont.setCity(p.getCity());
		cont.setState(p.getState());
		cont.setZip(p.getZip());
		cont.setAnnualIncome(p.getPersonal_annual_income());
		cont.setOwnershipPercent(p.getOwnership_percentage());
		cont.setDlNumber(p.getDrivers_license_number());
		cont.setDlState(p.getDrivers_license_state());
		return cont;
	}

	private Contact getPrimaryContact(FunderaRequest request) {
		List<Person> owners = request.owners;
		Person primaryOwner = owners.get(0);
		return getContact(primaryOwner);
	}

	private List<Contact> getGuarantors(FunderaRequest request) {
		List<Person> owners = request.owners;
		if (owners.size() == 1)
			return null;
		List<Contact> cLst = new ArrayList<Contact>();
		for (Integer i = 1; i < owners.size(); i++) {
			Person p = owners.get(i);
			Contact c = getContact(p);
			cLst.add(c);
		}
		return cLst;
	}

	private Application getApplication(FunderaRequest request) {
		Application app = new Application();
		Contact primaryContact = getPrimaryContact(request);
		Lead merchant = getLead(request);
		app.setPrimaryContact(primaryContact);

		List<Contact> conList = getGuarantors(request);
		if (conList != null && !conList.isEmpty())
			app.setGuarantors(conList);

		app.setLead(merchant);
		app.setAccountsReceivable(request.getCompany().getAccounts_receivable());
		app.setAnnualRevenue(request.getCompany().getAnnual_revenue());
		app.setAverageBankBalance(request.getCompany().getAverage_bank_balance());
		app.setBusinessDba(request.getCompany().getBusiness_dba());
		app.setBusinessInception(request.getCompany().getBusiness_inception());
		app.setBusinessName(request.getCompany().getBusiness_name());
		app.setEntityType(request.getCompany().getEntity_type());
		app.setLoanAmount(request.getCompany().getLoan_amount());
		app.setNumberOfEmployees(request.getCompany().getNumber_of_employees());
		app.setOutstandingTaxLien(request.getCompany().getOutstanding_tax_lien() != null);
		app.setBusinessAddressStreet1(request.getCompany().getStreet_line1());
		app.setBusinessAddressStreet2(request.getCompany().getStreet_line2());
		app.setBusinessAddressCity(request.getCompany().getCity());
		app.setBusinessAddressState(request.getCompany().getState());
		app.setBusinessAddressZip(request.getCompany().getZip());
		app.setBusinessAcceptsCreditCard(request.getCompany().getCredit_card_volume_per_month() != null);
		app.setAverageMonthlySales(request.getCompany().getCredit_card_volume_per_month());
		app.setCcSalesLastMonth(request.getCompany().getCredit_card_volume_per_month());
		app.setCcSalesTwoMonthsAgo(request.getCompany().getCredit_card_volume_per_month());
		app.setCcSalesThreeMonthsAgo(request.getCompany().getCredit_card_volume_per_month());
		app.setCcSalesFourMonthsAgo(request.getCompany().getCredit_card_volume_per_month());
		return app;
	}

	/*
	 * public FunderaResponse getOffers(FunderaRequest request) throws
	 * InternalServerException {
	 * 
	 * FunderaResponse fndResponse = new FunderaResponse();
	 * fndResponse.setUpdated(false);
	 * 
	 * Contact primaryContact = getPrimaryContact(request); Lead merchant =
	 * getLead(request); Application appl = getApplication(request); String
	 * partner = "Fundera";
	 * 
	 * try { SalesforceFacade sfFacade = new SalesforceFacade();
	 * APIPropertiesDAO apiDAO = new APIPropertiesDAO(); Map<String, String>
	 * apiProperties = apiDAO.getAPIProperties();
	 * 
	 * sfFacade.login(apiProperties.get(IFLAPIConstants.SF_LOGIN_ENDPOINT),
	 * apiProperties.get(IFLAPIConstants.SF_USER_NAME),
	 * apiProperties.get(IFLAPIConstants.SF_PASSWORD),
	 * apiProperties.get(IFLAPIConstants.SF_TOKEN),
	 * apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_ID),
	 * apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_SECRET_ID));
	 * 
	 * Customer c = sfFacade.getCustomer(merchant.getEmail(), partner); if (c !=
	 * null) { Application app = sfFacade.getApplication(merchant.getEmail(),
	 * partner); if (app != null) return new FunderaResponse(false,
	 * "Merchant already has an application in progress."); return new
	 * FunderaResponse(false, "Merchant is a forwardline customer."); } else {
	 * Lead existingLead = sfFacade.getLead(merchant.getEmail(), partner); Lead
	 * l = new Lead(); if (existingLead == null) { Lead newLead =
	 * sfFacade.createLead(merchant, partner); Contact con =
	 * sfFacade.createContact(primaryContact, partner);
	 * appl.setPrimaryContact(con); appl.setLead(newLead);
	 * appl.setGuarantors(getGuarantors(request)); Application newApplication =
	 * sfFacade.createApplication(appl, partner); if
	 * (newApplication.declinedInPreScoreBranching) { Offer off = new Offer();
	 * fndResponse.setPreapproved(false);
	 * fndResponse.setRejection_reason(newApplication.getReason()); return
	 * fndResponse; } else { ForsightDecision decision =
	 * sfFacade.scoreApplication(newApplication, partner); if
	 * (!decision.getApproved()) { Offer off = new Offer();
	 * fndResponse.setPreapproved(false);
	 * fndResponse.setRejection_reason(decision.getReason()); return
	 * fndResponse; } else { Offer off = new Offer();
	 * fndResponse.setPreapproved(true);
	 * off.setInterest_rate(decision.getOffer().getRate()); List<Offer> lst =
	 * new ArrayList<Offer>(); lst.add(off); fndResponse.setOffers(lst); return
	 * fndResponse; } } } else { return new FunderaResponse(false,
	 * "Merchant is a lead at Forwardline."); } } } catch (Exception e) {
	 * e.printStackTrace(); // throw new
	 * InternalServerException(e.getMessage()); return new
	 * FunderaResponse(false, e.getMessage()); } }
	 */

	public FunderaResponse getOffers(FunderaRequest request) throws InternalServerException {

		FunderaResponse fndResponse = new FunderaResponse();
		fndResponse.setUpdated(false);

		Application appl = getApplication(request);
		String partner = "Fundera";

		try {
			SalesforceFacade sfFacade = new SalesforceFacade();
			APIPropertiesDAO apiDAO = new APIPropertiesDAO();
			Map<String, String> apiProperties = apiDAO.getAPIProperties();

			sfFacade.login(apiProperties.get(IFLAPIConstants.SF_LOGIN_ENDPOINT), apiProperties.get(IFLAPIConstants.SF_USER_NAME), apiProperties.get(IFLAPIConstants.SF_PASSWORD), apiProperties.get(IFLAPIConstants.SF_TOKEN),
					apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_ID), apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_SECRET_ID));

			Application newApplication = sfFacade.createApplication(appl, partner);
			if (newApplication.declinedInPreScoreBranching) {
				Offer off = new Offer();
				fndResponse.setPreapproved(false);
				fndResponse.setRejection_reason(newApplication.getReason());
				return fndResponse;
			}
			ForsightDecision decision = sfFacade.scoreApplication(newApplication, partner);
			if (!decision.getApproved()) {
				Offer off = new Offer();
				fndResponse.setPreapproved(false);
				fndResponse.setRejection_reason(decision.getReason());
				return fndResponse;
			} else {
				Offer off = new Offer();
				fndResponse.setPreapproved(true);
				off.setInterest_rate(decision.getOffer().getRate());
				List<Offer> lst = new ArrayList<Offer>();
				lst.add(off);
				fndResponse.setOffers(lst);
				return fndResponse;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new FunderaResponse(false, e.getMessage());
		}
	}
}
