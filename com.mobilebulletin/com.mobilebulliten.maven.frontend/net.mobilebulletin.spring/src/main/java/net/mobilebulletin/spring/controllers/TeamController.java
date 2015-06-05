package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeamController {

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String TeamPage(Model model){
		return "/views/team.html";
	}
	
}
