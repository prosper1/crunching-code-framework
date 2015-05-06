package com.mobilebulletin.request.group;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class GetGroupByIdRequest  extends CommonRequest  implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String groupId;

public String getGroupId() {
	return groupId;
}

public void setGroupId(String groupId) {
	this.groupId = groupId;
}


}