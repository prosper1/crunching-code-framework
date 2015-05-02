package com.mobilebulletin.department;

import java.io.Serializable;
import java.util.List;

import com.common.cms.UserInformation;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;

public class EmployeeDepartmentInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9029537495207218078L;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private UserInformation userInformation;
	private DepartmentInformation departmentInformation;
	private TypeHierarchy departmentRole;
	private LogActivity logActivity;
	
	
	public DepartmentInformation getDepartmentInformation() {
		return departmentInformation;
	}
	public void setDepartmentInformation(DepartmentInformation departmentInformation) {
		this.departmentInformation = departmentInformation;
	}
	public TypeHierarchy getDepartmentRole() {
		return departmentRole;
	}
	public void setDepartmentRole(TypeHierarchy departmentRole) {
		this.departmentRole = departmentRole;
	}
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	
	
	public LogActivity getLogActivity() {
		return logActivity;
	}
	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}
	
	

}
