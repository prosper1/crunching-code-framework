package com.mobilebulletin.util.department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentListObjects {
	
	public static List<String> constractList(){
		List<String> list = new ArrayList<String>();
		list.add("AddDepartment");
		
		list.add("UpdateDepartmentMembers");
		list.add("UpdateDepartmentInfo");
		list.add("GetDepartmentById");
		
		list.add("ImportDepartmentFromExcel");
	
		
		return list;
	}
}
