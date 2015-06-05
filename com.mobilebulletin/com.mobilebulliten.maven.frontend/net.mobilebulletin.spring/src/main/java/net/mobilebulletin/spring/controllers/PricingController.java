package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PricingController {
	
	@RequestMapping(value = "/pricing", method = RequestMethod.GET)
	public String PricingPage(Model model){
		return "/views/pricing.html";
	}

}
