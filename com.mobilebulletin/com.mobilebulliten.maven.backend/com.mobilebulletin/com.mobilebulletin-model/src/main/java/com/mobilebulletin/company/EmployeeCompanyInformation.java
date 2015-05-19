package com.mobilebulletin.company;

import java.io.Serializable;
import java.util.List;

import com.common.cms.UserInformation;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;

public class EmployeeCompanyInformation implements Serializable{
	
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
	private CompanyInformation companyInformation;
	private List<TypeHierarchy> userRoles;
	private LogActivity logActivity;
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	public CompanyInformation getCompanyInformation() {
		return companyInformation;
	}
	public void setCompanyInformation(CompanyInformation companyInformation) {
		this.companyInformation = companyInformation;
	}
	public List<TypeHierarchy> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<TypeHierarchy> userRoles) {
		this.userRoles = userRoles;
	}
	public LogActivity getLogActivity() {
		return logActivity;
	}
	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}
	
	

}
