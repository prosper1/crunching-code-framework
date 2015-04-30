package com.mobilebulletin.request.security;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class SignUpUserRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String username;
private String companyName;
private String cellNo;
private String email;
private String website;
private String password;

public String getCellNo() {
	return cellNo;
}
public void setCellNo(String cellNo) {
	this.cellNo = cellNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}



}