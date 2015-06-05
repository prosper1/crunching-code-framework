package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeesController {

	@RequestMapping(value = "/admin/employees", method = RequestMethod.GET)
	public String AdminEmployeesPage(Model model){
		return "/views/employees.html";
	}
	
	@RequestMapping(value = "/admin/create-employee", method = RequestMethod.GET)
	public String AdminCreateEmployeePage(Model model){
		return "/views/create-employee.html";
	}
	
}
