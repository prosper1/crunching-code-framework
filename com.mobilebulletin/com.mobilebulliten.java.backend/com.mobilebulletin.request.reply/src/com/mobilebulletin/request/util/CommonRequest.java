package com.mobilebulletin.request.util;

import java.io.Serializable;

public class CommonRequest  implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String clientName;
private String userId;
private String companyId;
private String cellNumber;


public String getCompanyId() {
	return companyId;
}
public void setCompanyId(String companyId) {
	this.companyId = companyId;
}
public String getCellNumber() {
	return cellNumber;
}
public void setCellNumber(String cellNumber) {
	this.cellNumber = cellNumber;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}



}
