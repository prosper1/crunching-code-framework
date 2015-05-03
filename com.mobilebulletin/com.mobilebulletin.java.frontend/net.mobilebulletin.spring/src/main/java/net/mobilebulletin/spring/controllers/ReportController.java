package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

	@RequestMapping(value = "/admin/report", method = RequestMethod.GET)
	public String AdminReportPage(Model model){
		return "/views/report.html";
	}
	
}
