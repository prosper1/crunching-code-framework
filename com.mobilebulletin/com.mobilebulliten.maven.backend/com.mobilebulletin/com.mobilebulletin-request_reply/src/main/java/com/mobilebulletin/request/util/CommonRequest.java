package com.mobilebulletin.request.util;

import java.io.Serializable;

public class CommonRequest  implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String requestClientName;
private String requestUserId;
private String requestCompanyId;
private String requestCellNumber;
public String getRequestClientName() {
	return requestClientName;
}
public void setRequestClientName(String requestClientName) {
	this.requestClientName = requestClientName;
}
public String getRequestUserId() {
	return requestUserId;
}
public void setRequestUserId(String requestUserId) {
	this.requestUserId = requestUserId;
}
public String getRequestCompanyId() {
	return requestCompanyId;
}
public void setRequestCompanyId(String requestCompanyId) {
	this.requestCompanyId = requestCompanyId;
}
public String getRequestCellNumber() {
	return requestCellNumber;
}
public void setRequestCellNumber(String requestCellNumber) {
	this.requestCellNumber = requestCellNumber;
}






}
