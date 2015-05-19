package com.mobilebulletin.department;

import java.io.Serializable;

import com.common.log.LogActivity;
import com.mobilebulletin.company.CompanyInformation;

public class DepartmentInformation  implements Serializable{
	
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
	private String name;
	private LogActivity logActivity;
	private String description;
	private CompanyInformation companyInformation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LogActivity getLogActivity() {
		return logActivity;
	}
	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}
	public CompanyInformation getCompanyInformation() {
		return companyInformation;
	}
	public void setCompanyInformation(CompanyInformation companyInformation) {
		this.companyInformation = companyInformation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
