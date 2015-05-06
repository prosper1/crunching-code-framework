package com.mobilebulletin.request.group;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.request.group.model.GroupMemberInfo;
import com.mobilebulletin.request.util.CommonRequest;


public class UpdateGroupMembersRequest  extends CommonRequest  implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private String groupId;
private List<GroupMemberInfo> groupMemberList;
public String getGroupId() {
	return groupId;
}
public void setGroupId(String groupId) {
	this.groupId = groupId;
}
public List<GroupMemberInfo> getGroupMemberList() {
	return groupMemberList;
}
public void setGroupMemberList(List<GroupMemberInfo> groupMemberList) {
	this.groupMemberList = groupMemberList;
}





}