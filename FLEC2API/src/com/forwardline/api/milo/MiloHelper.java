package com.forwardline.api.milo;

import java.util.Map;

import com.forwardline.api.milo.types.Application;
import com.forwardline.api.persistence.APIPropertiesDAO;
import com.forwardline.util.IFLAPIConstants;

public class MiloHelper {
	public static final String PARTNER_NAME = "Milo";
	
	private String applicationId;

	public MiloHelper(String applicationId) {
		this.applicationId = applicationId;
	}

	public String processApplication() throws Exception {
		String redirectEndpoint = null;

		Application nApplication = new Application();
		nApplication.setId(applicationId);

		try {
			MiloFacade facade = new MiloFacade();
			APIPropertiesDAO apiDAO = new APIPropertiesDAO(PARTNER_NAME);
			Map<String, String> apiProperties = apiDAO.getAPIProperties();

			facade.login(apiProperties.get(IFLAPIConstants.SF_LOGIN_ENDPOINT), apiProperties.get(IFLAPIConstants.SF_USER_NAME), apiProperties.get(IFLAPIConstants.SF_PASSWORD), apiProperties.get(IFLAPIConstants.SF_TOKEN),
					apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_ID), apiProperties.get(IFLAPIConstants.SF_OAUTH_CLIENT_SECRET_ID));

			redirectEndpoint = facade.processApplication(nApplication); 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return redirectEndpoint;
	}
}
