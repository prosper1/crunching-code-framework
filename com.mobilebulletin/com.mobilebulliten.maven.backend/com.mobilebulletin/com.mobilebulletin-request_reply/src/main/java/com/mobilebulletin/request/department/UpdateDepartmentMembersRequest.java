package com.mobilebulletin.request.department;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.request.department.model.DepartmentMemberInfo;
import com.mobilebulletin.request.util.CommonRequest;


public class UpdateDepartmentMembersRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private String departmentId;
private List<DepartmentMemberInfo> departmentMemberList;
public String getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}
public List<DepartmentMemberInfo> getDepartmentMemberList() {
	return departmentMemberList;
}
public void setDepartmentMemberList(
		List<DepartmentMemberInfo> departmentMemberList) {
	this.departmentMemberList = departmentMemberList;
}



}