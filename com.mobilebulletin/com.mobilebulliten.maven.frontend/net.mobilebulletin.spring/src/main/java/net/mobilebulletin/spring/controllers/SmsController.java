package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SmsController {
	
	@RequestMapping(value = "/admin/sms", method = RequestMethod.GET)
	public String AdminSmsPage(Model model){
		return "/views/sms.html";
	}
	
	@RequestMapping(value = "/admin/create-sms", method = RequestMethod.GET)
	public String AdminCreateSmsPage(Model model){
		return "/views/create-sms.html";
	}

}
