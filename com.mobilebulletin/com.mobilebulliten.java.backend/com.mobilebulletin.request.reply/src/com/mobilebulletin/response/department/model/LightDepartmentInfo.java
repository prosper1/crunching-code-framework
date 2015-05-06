package com.mobilebulletin.response.department.model;

import java.io.Serializable;

public class LightDepartmentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String timeAgo;
	private long numberOfMembers;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeAgo() {
		return timeAgo;
	}
	public void setTimeAgo(String timeAgo) {
		this.timeAgo = timeAgo;
	}
	public long getNumberOfMembers() {
		return numberOfMembers;
	}
	public void setNumberOfMembers(long numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}
	
	

}
