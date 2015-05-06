package com.mobilebulletin.response.group;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.response.department.model.DepartmentInfo;
import com.mobilebulletin.response.employee.model.EmployeeInfo;
import com.mobilebulletin.response.group.model.GroupInfo;
import com.mobilebulletin.response.util.SystemSuperResponse;


public class GetGroupByIdResponse extends SystemSuperResponse implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private GroupInfo groupInfo;

public GroupInfo getGroupInfo() {
	return groupInfo;
}
public void setGroupInfo(GroupInfo groupInfo) {
	this.groupInfo = groupInfo;
}


}