package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SupportController {
	
	@RequestMapping(value = "/contact-us", method = RequestMethod.GET)
	public String ContactUsPage(Model model){
		return "/views/contact-us.html";
	}

	@RequestMapping(value = "/support", method = RequestMethod.GET)
	public String OutsideSupportPage(Model model){
		return "/views/support.html";
	}
	
}
