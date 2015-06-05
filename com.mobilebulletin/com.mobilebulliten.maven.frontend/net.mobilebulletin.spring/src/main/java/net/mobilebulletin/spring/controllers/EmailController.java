package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {
	
	@RequestMapping(value = "/admin/email", method = RequestMethod.GET)
	public String AdminEmailPage(Model model){
		return "/views/email.html";
	}
	
	@RequestMapping(value = "/admin/create-email", method = RequestMethod.GET)
	public String AdminCreateEmailPage(Model model){
		return "/views/create-email.html";
	}

}
