package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GroupController {

	@RequestMapping(value = "/admin/group", method = RequestMethod.GET)
	public String AdminGroupPage(Model model){
		return "/views/group.html";
	}
	
}
