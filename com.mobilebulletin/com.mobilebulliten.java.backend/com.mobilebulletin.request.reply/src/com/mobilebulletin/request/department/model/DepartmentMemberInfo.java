package com.mobilebulletin.request.department.model;

import java.io.Serializable;

public class DepartmentMemberInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6448678286075286955L;
	private String memberId;
	private String memberRole;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}
	

}
