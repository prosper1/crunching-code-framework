package com.mobilebulletin.util.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListObjects {
	
	public static List<String> constractList(){
		List<String> list = new ArrayList<String>();
		list.add("AddEmployee");
		
		list.add("RemoveEmployee");
		list.add("UpdateEmployee");
		list.add("ImportEmployees");
		
		list.add("ImportEmployeesFromDatabase");
	
		list.add("GetEmployeeById");
		list.add("GetEmployeesFromCompany");
		
		//5 last visited places
		
		return list;
	}
}
