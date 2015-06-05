package net.mobilebulletin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentsController {
	
	@RequestMapping(value = "/admin/departments", method = RequestMethod.GET)
	public String AdminDepartmentsPage(Model model){
		return "/views/departments.html";
	}
	
	@RequestMapping(value = "/admin/create-department", method = RequestMethod.GET)
	public String AdminCreateDepartmentPage(Model model){
		return "/views/create-department.html";
	}

}
