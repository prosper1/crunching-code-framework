package com.mobilebulletin.group;

import java.io.Serializable;
import java.util.List;

import com.common.cms.UserInformation;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;

public class EmployeeGroupInformation implements Serializable{
	
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
	private GroupInformation groupInformation;
	private TypeHierarchy groupRole;
	private LogActivity logActivity;
	
	
	
	
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
	public GroupInformation getGroupInformation() {
		return groupInformation;
	}
	public void setGroupInformation(GroupInformation groupInformation) {
		this.groupInformation = groupInformation;
	}
	public TypeHierarchy getGroupRole() {
		return groupRole;
	}
	public void setGroupRole(TypeHierarchy groupRole) {
		this.groupRole = groupRole;
	}
	
	

}
