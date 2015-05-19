package com.common.notes;

import java.io.Serializable;

import com.common.log.LogActivity;

public class AdditionalNotes  implements Serializable{
	private static final long serialVersionUID = -25747891554412L;
	private long id;
	private LogActivity logActivity;
	private String notes;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LogActivity getLogActivity() {
		return logActivity;
	}
	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
