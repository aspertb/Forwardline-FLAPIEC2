package com.forwardline.webapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forwardline.api.fundera.pojo.Company;
import com.forwardline.api.fundera.pojo.FunderaRequest;
import com.forwardline.api.fundera.pojo.FunderaResponse;
import com.forwardline.api.fundera.pojo.Person;
import com.forwardline.api.fundera.pojo.RequestHeader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Controller
public class FunderaController {
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = "/funderaRequest", method = RequestMethod.GET)
	public String funderaRequestInit(Model model) {
		System.out.println("FunderaController.funderaRequestInit invoked.");
		FunderaRequest request = new FunderaRequest();
		request.setCompany(new Company());
		request.setRequestHeader(new RequestHeader());
		List<Person> owners = new ArrayList<Person>();
		owners.add(new Person());
		request.setOwners(owners);
		model.addAttribute("request", request);
		return "FunderaRequest";
	}

	@RequestMapping(value = "/getOffer", method = RequestMethod.POST)
	public String getOffer(@ModelAttribute FunderaRequest request, Model model) {
		System.out.println("FunderaController.getOffer invoked");

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
		String json = gson.toJson(request);

		// String ep =
		// "http://forwardlineec2api-env.us-west-2.elasticbeanstalk.com/partner/fundera/getOffer");
		String ep = "http://localhost:8080/FLAPIEC2/partner/fundera/getOffer";
		FunderaResponse response = getOffers(ep, json);
		model.addAttribute("requestJSON", json);
		model.addAttribute("response", response);
		model.addAttribute("responseJSON", gson.toJson(response));
		//model.addAttribute("responseJSON", "Just testin");
		return "FunderaResponse";
	}

	private FunderaResponse getOffers(String endPoint, String requestJson) {
		try {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client.resource(endPoint);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			FunderaRequest request = gson.fromJson(requestJson, FunderaRequest.class);

			ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, request);

			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus() + " - " + response.getHeaders());
			FunderaResponse res = response.getEntity(FunderaResponse.class);
			return res;

		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) {

	}
}
