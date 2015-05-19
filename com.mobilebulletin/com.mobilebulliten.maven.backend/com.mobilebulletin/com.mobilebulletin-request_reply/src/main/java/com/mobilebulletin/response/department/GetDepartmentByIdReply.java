package com.mobilebulletin.response.department;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.response.department.model.DepartmentInfo;
import com.mobilebulletin.response.employee.model.EmployeeInfo;
import com.mobilebulletin.response.util.SystemSuperResponse;


public class GetDepartmentByIdReply extends SystemSuperResponse implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private DepartmentInfo departmentInfo;

public DepartmentInfo getDepartmentInfo() {
	return departmentInfo;
}
public void setDepartmentInfo(DepartmentInfo departmentInfo) {
	this.departmentInfo = departmentInfo;
}


}