package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {

	@RequestMapping(value = "/admin/message", method = RequestMethod.GET)
	public String AdminMessagePage(Model model){
		return "/views/message.html";
	}
	
}
