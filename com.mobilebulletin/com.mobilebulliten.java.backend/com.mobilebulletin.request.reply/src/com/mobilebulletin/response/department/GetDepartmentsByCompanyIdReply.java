package com.mobilebulletin.response.department;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.response.department.model.LightDepartmentInfo;
import com.mobilebulletin.response.util.SystemSuperResponse;

public class GetDepartmentsByCompanyIdReply  extends SystemSuperResponse implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private List<LightDepartmentInfo> departmentInfoList;
public List<LightDepartmentInfo> getDepartmentInfoList() {
	return departmentInfoList;
}
public void setDepartmentInfoList(List<LightDepartmentInfo> departmentInfoList) {
	this.departmentInfoList = departmentInfoList;
}

}
