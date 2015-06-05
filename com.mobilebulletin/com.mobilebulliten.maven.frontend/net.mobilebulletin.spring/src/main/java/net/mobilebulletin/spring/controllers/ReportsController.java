package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportsController {

	@RequestMapping(value = "/admin/reports", method = RequestMethod.GET)
	public String AdminReportsPage(Model model){
		return "/views/reports.html";
	}
	
}
