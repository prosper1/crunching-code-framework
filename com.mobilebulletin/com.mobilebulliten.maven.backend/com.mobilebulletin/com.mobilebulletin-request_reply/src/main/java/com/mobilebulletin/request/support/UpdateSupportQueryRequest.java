package com.mobilebulletin.request.support;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class UpdateSupportQueryRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private String supportId;
private String supportComment;
private String supportStatus;
public String getSupportId() {
	return supportId;
}
public void setSupportId(String supportId) {
	this.supportId = supportId;
}
public String getSupportComment() {
	return supportComment;
}
public void setSupportComment(String supportComment) {
	this.supportComment = supportComment;
}
public String getSupportStatus() {
	return supportStatus;
}
public void setSupportStatus(String supportStatus) {
	this.supportStatus = supportStatus;
}





}