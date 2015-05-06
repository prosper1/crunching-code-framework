package com.mobilebulletin.request.department;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class GetDepartmentByIdRequest  extends CommonRequest  implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String departmentId;

public String getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}



}