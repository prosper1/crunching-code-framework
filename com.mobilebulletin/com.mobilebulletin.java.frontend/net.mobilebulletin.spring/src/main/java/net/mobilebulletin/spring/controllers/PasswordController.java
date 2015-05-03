package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PasswordController {

	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public String ForgotPasswordPage(Model model){
		return "/views/forgot-password.html";
	}
	
}
