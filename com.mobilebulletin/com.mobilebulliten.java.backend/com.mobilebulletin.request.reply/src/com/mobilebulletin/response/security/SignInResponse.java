package com.mobilebulletin.response.security;

import java.io.Serializable;


import com.mobilebulletin.response.util.SystemSuperResponse;


public class SignInResponse extends SystemSuperResponse implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private boolean userExist;
private boolean userActive;
private String userFullName;
private String username;
private String cellNo;
private String activationStatus;
private String userRole;
private String imagePath;
private String userId;
private String gender;
public boolean isUserExist() {
	return userExist;
}
public void setUserExist(boolean userExist) {
	this.userExist = userExist;
}
public boolean isUserActive() {
	return userActive;
}
public void setUserActive(boolean userActive) {
	this.userActive = userActive;
}
public String getUserFullName() {
	return userFullName;
}
public void setUserFullName(String userFullName) {
	this.userFullName = userFullName;
}

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
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public String getUserRole() {
	return userRole;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}
public String getImagePath() {
	return imagePath;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getGender() {
	return gender;
}

}