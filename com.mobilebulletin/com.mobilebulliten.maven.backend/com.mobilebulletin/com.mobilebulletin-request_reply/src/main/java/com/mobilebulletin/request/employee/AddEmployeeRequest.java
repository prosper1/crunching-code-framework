package com.mobilebulletin.request.employee;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class AddEmployeeRequest  extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;


private String initials;
private String firstname;
private String lastname;
private String cellNo;
private String email;
private String employeeNo;
private String langauge;

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


public String getInitials() {
	return initials;
}
public void setInitials(String initials) {
	this.initials = initials;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmployeeNo() {
	return employeeNo;
}
public void setEmployeeNo(String employeeNo) {
	this.employeeNo = employeeNo;
}
public String getLangauge() {
	return langauge;
}
public void setLangauge(String langauge) {
	this.langauge = langauge;
}






}