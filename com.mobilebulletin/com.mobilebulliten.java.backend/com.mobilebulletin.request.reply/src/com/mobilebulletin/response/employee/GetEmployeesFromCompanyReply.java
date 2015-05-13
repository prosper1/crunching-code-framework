package com.mobilebulletin.response.employee;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.response.employee.model.EmployeeInfo;
import com.mobilebulletin.response.util.SystemSuperResponse;


public class GetEmployeesFromCompanyReply extends SystemSuperResponse implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private List<EmployeeInfo> employeeInfoList;
public List<EmployeeInfo> getEmployeeInfoList() {
	return employeeInfoList;
}
public void setEmployeeInfoList(List<EmployeeInfo> employeeInfoList) {
	this.employeeInfoList = employeeInfoList;
}


}