package com.mobilebulletin.request.department;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class AddDepartmentRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private String name;
private String description;
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



}