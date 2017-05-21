package com.forwardline.webapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forwardline.api.milo.MiloHelper;
import com.forwardline.api.milo.types.Application;

@Controller
public class MiloController {

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	// http://forwardlineec2api-env.us-west-2.elasticbeanstalk.com/flwebapp/processApplication
	@RequestMapping(value = "/initJourney", method = RequestMethod.GET)
	public String initJourney(@RequestParam("applicationID") String applicationID, Model model) {
		System.out.println("MiloController.initJourney invoked.");
		Application application = new Application();
		application.setId(applicationID);
		model.addAttribute("application", application);
		return "MiloCustomerJourney";
	}

	@RequestMapping(value = "/processApplication", method = RequestMethod.POST)
	public @ResponseBody String processApplication(@RequestBody Application application) throws Exception {
		System.out.println("MiloController.processApplication invoked with Id " + application.getId());
		MiloHelper helper = new MiloHelper(application.getId());
		String redirectUrl = helper.processApplication();
		return "Redirect Url " + redirectUrl;
	}
}
