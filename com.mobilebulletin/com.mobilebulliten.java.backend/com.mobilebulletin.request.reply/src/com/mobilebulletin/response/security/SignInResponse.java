package com.mobilebulletin.response.security;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.response.util.SystemSuperResponse;


public class SignInResponse extends SystemSuperResponse implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String email;
private String username;
private String cellNo;
private String activationStatus;
private List<String> userRoles;
private String userId;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public void setCellNo(String cellNo) {
	this.cellNo = cellNo;
}
public String getCellNo() {
	return cellNo;
}
public void setActivationStatus(String activationStatus) {
	this.activationStatus = activationStatus;
}
public String getActivationStatus() {
	return activationStatus;
}
public List<String> getUserRoles() {
	return userRoles;
}
public void setUserRoles(List<String> userRoles) {
	this.userRoles = userRoles;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}