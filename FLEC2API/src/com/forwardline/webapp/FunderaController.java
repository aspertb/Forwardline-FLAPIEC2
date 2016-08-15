package com.forwardline.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FunderaController {

	@RequestMapping(value = "/funderaRequest", method=RequestMethod.GET)
	public String funderaRequestInit(Model model) {
		System.out.println("FunderaController: Passing through...");
		model.addAttribute("request", new FunderaRequest());
        return "FunderaRequest";
	}
	
	@RequestMapping(value = "/getOffer", method=RequestMethod.POST)
	public String getOffer(@ModelAttribute FunderaRequest request, Model model) {
		System.out.println("FunderaController: Passing through...");
		model.addAttribute("offer", new FunderaRequest());
        return "FunderaResponse";
	}
}
