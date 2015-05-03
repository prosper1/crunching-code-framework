package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/admin/employee", method = RequestMethod.GET)
	public String AdminEmployeePage(Model model){
		return "/views/employee.html";
	}
	
}
