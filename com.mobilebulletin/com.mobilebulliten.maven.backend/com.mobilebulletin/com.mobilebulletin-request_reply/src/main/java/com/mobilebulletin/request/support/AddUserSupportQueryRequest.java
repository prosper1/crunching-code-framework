package com.mobilebulletin.request.support;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class AddUserSupportQueryRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String supportModule;

private String supportContent;
private String heading;

public String getSupportContent() {
	return supportContent;
}
public void setSupportContent(String supportContent) {
	this.supportContent = supportContent;
}
public void setHeading(String heading) {
	this.heading = heading;
}
public String getHeading() {
	return heading;
}
public String getSupportModule() {
	return supportModule;
}
public void setSupportModule(String supportModule) {
	this.supportModule = supportModule;
}


}