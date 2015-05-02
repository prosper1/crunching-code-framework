package com.mobilebulletin.request.support;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class AddGuestSupportQueryRequest  extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private String email;
private String fullname;
private String supportContent;
private String heading;
private String id;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public String getSupportContent() {
	return supportContent;
}
public void setSupportContent(String supportContent) {
	this.supportContent = supportContent;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public void setHeading(String heading) {
	this.heading = heading;
}
public String getHeading() {
	return heading;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}



}