package com.common.cms;

import java.io.Serializable;
import java.util.List;

import com.common.communication.ContactReference;
import com.common.type.TypeHierarchy;


public class UserInformation extends Person implements Serializable {

	/**
	 * 
	 */

	

	private static final long serialVersionUID = 4L;
	private ContactReference username;
	private String password;
	private String activationCode;
	private boolean userActive;
	private List<TypeHierarchy> userRoles;
	private TypeHierarchy activationStatus;
	private String uniqueUsername;
	
	
	
	public ContactReference getUsername() {
		return username;
	}
	public void setUsername(ContactReference username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isUserActive() {
		return userActive;
	}
	public void setUserActive(boolean userActive) {
		this.userActive = userActive;
	}
	
	
	public String getUniqueUsername() {
		return uniqueUsername;
	}
	public void setUniqueUsername(String uniqueUsername) {
		this.uniqueUsername = uniqueUsername;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public TypeHierarchy getActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(TypeHierarchy activationStatus) {
		this.activationStatus = activationStatus;
	}
	public List<TypeHierarchy> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<TypeHierarchy> userRoles) {
		this.userRoles = userRoles;
	}

}
