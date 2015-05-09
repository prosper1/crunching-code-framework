package com.mobilebulletin.request.group;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class UpdateGroupInfoRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String groupId;
private String name;
private String description;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getGroupId() {
	return groupId;
}
public void setGroupId(String groupId) {
	this.groupId = groupId;
}



}