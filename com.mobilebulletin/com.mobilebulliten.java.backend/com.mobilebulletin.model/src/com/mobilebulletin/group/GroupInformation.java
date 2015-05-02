package com.mobilebulletin.group;

import java.io.Serializable;

import com.common.log.LogActivity;

public class GroupInformation   implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9029537495207218078L;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String name;
	private LogActivity logActivity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LogActivity getLogActivity() {
		return logActivity;
	}
	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}
	

}
