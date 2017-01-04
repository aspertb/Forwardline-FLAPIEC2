package com.forwardline.api.client.test;

import java.util.Map;

import com.forwardline.api.fundera.pojo.Offer;
import com.forwardline.api.persistence.APIPropertiesDAO;
import com.forwardline.salesforce.connector.SalesforceFacade;
import com.forwardline.salesforce.connector.command.BaseHttpCommand;
import com.forwardline.salesforce.connector.command.PostCommand;
import com.forwardline.salesforce.connector.port.SalesforceLoginPort;
import com.forwardline.salesforce.connector.types.Application;
import com.forwardline.salesforce.connector.types.ApplicationResponse;
import com.forwardline.salesforce.connector.types.ContactResponse;
import com.forwardline.salesforce.connector.types.ForsightResponse;
import com.forwardline.salesforce.connector.types.SalesforceResponse;
import com.forwardline.salesforce.connector.types.SalesforceSession;
import com.forwardline.util.IFLAPIConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RawTest {

	public RawTest() {
		// TODO Auto-generated constructor stub
	}

	public void test() throws Exception {
		String json = "{\"request\":{\"header\":{\"operation\":\"create_application\",\"partner\":\"Fundera\"},\"application\":{\"primaryContact\":{\"firstName\":\"Tyson\",\"lastName\":\"Minnick\",\"email\":\"tyson@rmcftroutdale.com\",\"phone\":\"3126134965\",\"mobilePhone\":\"3126134965\",\"dob\":\"1975-11-18\",\"ssn\":\"486960582\",\"street\":\"2080 Northwest 12th Street\",\"city\":\"Gresham\",\"state\":\"OR\",\"zip\":\"97030\",\"annualIncome\":50000.0,\"ownershipPercent\":50.0},\"lead\":{\"firstName\":\"Tyson\",\"lastName\":\"Minnick\",\"email\":\"tyson@rmcftroutdale.com\",\"companyName\":\"RMCF Troutdale, INC\",\"phone\":\"5036657237\",\"mobilePhone\":\"3126134965\"},\"guarantors\":[{\"firstName\":\"Erica\",\"lastName\":\"Ricker\",\"email\":\"erica@rmcftroutdale.com\",\"phone\":\"8162949505\",\"mobilePhone\":\"8162949505\",\"dob\":\"1982-10-27\",\"ssn\":\"514846490\",\"street\":\"2080 nw 12th st\",\"city\":\"Gresham\",\"state\":\"OR\",\"zip\":\"97030\",\"ownershipPercent\":50.0}],\"loanAmount\":75000.0,\"businessName\":\"RMCF Troutdale, INC\",\"businessDba\":\"Rocky Mountain Chocolate Factory\",\"entityType\":\"S Corporation\",\"numberOfEmployees\":8,\"annualRevenue\":475000.0,\"averageBankBalance\":8000.0,\"businessInception\":\"2013-03-15\",\"outstandingTaxLien\":false,\"businessAddressStreet1\":\"450 Northwest 257th Ave Suite 336\",\"businessAddressCity\":\"Troutdale\",\"businessAddressState\":\"OR\",\"businessAddressZip\":\"97060\",\"businessAcceptsCreditCard\":false,\"federalTaxId\":\"813116853\"}}}";
		
		SalesforceLoginPort port = new SalesforceLoginPort("https://test.salesforce.com/services/oauth2/token", "aspert.b@forwardline.com.fldev", "Java1123", "zSQrWlxO4Yo2V2tYcfl5y6qg",
				"3MVG9sLbBxQYwWquMUxRzV_8ieCNEc8.bdJ88tzWeCQ1_bZcSGRlHr4M.7LIW_gRnQydN1dqJgPSZeM.qBsdY", "6959566901876856983");
		SalesforceSession session = port.getSession();
		//String endpoint = new StringBuffer(session.getInstance_url()).append("/services/apexrest/forwardline/ola").toString();
		String endpoint = new StringBuffer(session.getInstance_url()).append("/services/apexrest/forwardline/forsight").toString();
		BaseHttpCommand command = new PostCommand(endpoint.toString(), session.getAccess_token(), json);
		SalesforceResponse response = command.execute();
		System.out.println(response.getJson());
	}
	
	public void test2() throws Exception {
		String partner = "Fundera";
		//String json = "{\"primaryContact\":{\"firstName\":\"Tyson\",\"lastName\":\"Minnick\",\"email\":\"tyson3@rmcftroutdale.com\",\"phone\":\"3126134965\",\"mobilePhone\":\"3126134965\",\"dob\":\"1975-11-18\",\"ssn\":\"486960582\",\"street\":\"2080 Northwest 12th Street\",\"city\":\"Gresham\",\"state\":\"OR\",\"zip\":\"97030\",\"annualIncome\":50000.0,\"ownershipPercent\":50.0},\"lead\":{\"firstName\":\"Tyson\",\"lastName\":\"Minnick\",\"email\":\"tyson@rmcftroutdale.com\",\"companyName\":\"RMCF Troutdale, INC\",\"phone\":\"5036657237\",\"mobilePhone\":\"3126134965\"},\"guarantors\":[{\"firstName\":\"Erica\",\"lastName\":\"Ricker\",\"email\":\"erica@rmcftroutdale.com\",\"phone\":\"8162949505\",\"mobilePhone\":\"8162949505\",\"dob\":\"1982-10-27\",\"ssn\":\"514846490\",\"street\":\"2080 nw 12th st\",\"city\":\"Gresham\",\"state\":\"OR\",\"zip\":\"97030\",\"ownershipPercent\":50.0}],\"loanAmount\":75000.0,\"businessName\":\"RMCF Troutdale, INC\",\"businessDba\":\"Rocky Mountain Chocolate Factory\",\"entityType\":\"S Corporation\",\"numberOfEmployees\":8,\"annualRevenue\":475000.0,\"averageBankBalance\":8000.0,\"businessInception\":\"2013-03-15\",\"outstandingTaxLien\":false,\"businessAddressStreet1\":\"450 Northwest 257th Ave Suite 336\",\"businessAddressCity\":\"Troutdale\",\"businessAddressState\":\"OR\",\"businessAddressZip\":\"97060\",\"businessAcceptsCreditCard\":false,\"federalTaxId\":\"813116853\"}";
		
		String json = "{\"primaryContact\":{\"firstName\":\"Eric\",\"lastName\":\"Greenspan\",\"email\":\"ericdavidgreenspan003@gmail.com\",\"phone\":\"8052527779\",\"mobilePhone\":\"8052527779\",\"dob\":\"1968-09-03\",\"ssn\":\"554554176\",\"street\":\"856 Chelham Way\",\"city\":\"Santa Barbara\",\"state\":\"CA\",\"zip\":\"93108\",\"annualIncome\":143279.0,\"ownershipPercent\":75.0},\"lead\":{\"firstName\":\"Eric\",\"lastName\":\"Greenspan\",\"email\":\"ericdavidgreenspan@gmail.com\",\"companyName\":\"74 Degrees LLC\",\"phone\":\"8888888882\",\"mobilePhone\":\"8052527779\"},\"loanAmount\":50000.0,\"businessName\":\"74 Degrees LLC\",\"entityType\":\"LLC\",\"numberOfEmployees\":2,\"annualRevenue\":321000.0,\"averageBankBalance\":2500.0,\"businessInception\":\"2010-02-01\",\"outstandingTaxLien\":false,\"businessAddressStreet1\":\"856 Chelham Way\",\"businessAddressCity\":\"Santa Barbara\",\"businessAddressState\":\"CA\",\"businessAddressZip\":\"93108\",\"businessAcceptsCreditCard\":false,\"federalTaxId\":\"342066969\"}";
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Application app = gson.fromJson(json, Application.class);
		System.out.println(app);
		
		SalesforceFacade sfFacade = new SalesforceFacade();
		APIPropertiesDAO apiDAO = new APIPropertiesDAO();
		Map<String, String> apiProperties = apiDAO.getAPIProperties();

		sfFacade.login(apiProperties.get(IFLAPIConstants.SF_LOGIN_ENDPOINT), apiProperties.get(IFLAPIConstants.SF_USER_NAME), apiProperties.get(IFLAPIConstants.SF_PASSWORD), apiProperties.get(IFLAPIConstants.SF_TOKEN),
				apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_ID), apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_SECRET_ID));

		ApplicationResponse response = sfFacade.createApplication(app, partner);
		Application newApplication = response.getApplication();
		if (newApplication.declinedInPreScoreBranching) {
			System.out.println("Declined in pre-score branching");
		}
		ForsightResponse forResponse = sfFacade.scoreApplication(newApplication, partner);
		System.out.println("Done!!");
	}
	
	public static void main(String[] args) {
		RawTest t = new RawTest();
		try {
			t.test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
