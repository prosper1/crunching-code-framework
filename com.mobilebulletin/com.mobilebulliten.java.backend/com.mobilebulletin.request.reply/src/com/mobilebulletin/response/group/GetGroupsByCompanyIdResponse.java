package com.mobilebulletin.response.group;

import java.io.Serializable;
import java.util.List;

import com.mobilebulletin.response.group.model.LightGroupInfo;
import com.mobilebulletin.response.util.SystemSuperResponse;

public class GetGroupsByCompanyIdResponse  extends SystemSuperResponse implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private List<LightGroupInfo> groupInfoList;
public List<LightGroupInfo> getGroupInfoList() {
	return groupInfoList;
}
public void setGroupInfoList(List<LightGroupInfo> groupInfoList) {
	this.groupInfoList = groupInfoList;
}


}
