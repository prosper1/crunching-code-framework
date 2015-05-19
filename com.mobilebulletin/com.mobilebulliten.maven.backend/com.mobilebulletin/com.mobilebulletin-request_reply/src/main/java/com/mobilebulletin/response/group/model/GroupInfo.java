package com.mobilebulletin.response.group.model;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.response.employee.model.EmployeeInfo;

public class GroupInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6648692469485074016L;
	private String id;
	private String name;
	private String description;
	private List<EmployeeInfo> employeeInfoList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<EmployeeInfo> getEmployeeInfoList() {
		return employeeInfoList;
	}
	public void setEmployeeInfoList(List<EmployeeInfo> employeeInfoList) {
		this.employeeInfoList = employeeInfoList;
	}
	

}
