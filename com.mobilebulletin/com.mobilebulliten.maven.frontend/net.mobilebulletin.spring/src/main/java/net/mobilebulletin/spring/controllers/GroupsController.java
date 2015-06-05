package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GroupsController {

	@RequestMapping(value = "/admin/groups", method = RequestMethod.GET)
	public String AdminGroupsPage(Model model){
		return "/views/groups.html";
	}
	
	@RequestMapping(value = "/admin/create-group", method = RequestMethod.GET)
	public String AdminCreateGroupPage(Model model){
		return "/views/create-group.html";
	}
	
}
