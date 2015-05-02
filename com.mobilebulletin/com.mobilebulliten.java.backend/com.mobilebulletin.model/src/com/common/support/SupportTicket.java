package com.common.support;

import java.io.Serializable;
import java.util.List;

import com.common.cms.Person;
import com.common.log.LogActivity;
import com.common.notes.AdditionalNotes;
import com.common.type.TypeHierarchy;

public class SupportTicket implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -19968526509515L;
	private long id;
	private String email;
	private String fullname;
	private String heading;
	private Person person;
	private boolean createdByGuest;
	private String supportContent;
	private TypeHierarchy supportStatus;
	private TypeHierarchy supportModule;
	private String supportTickectId;
	private List<AdditionalNotes> additionalNotes; 
	
	public boolean isCreatedByGuest() {
		return createdByGuest;
	}
	public void setCreatedByGuest(boolean createdByGuest) {
		this.createdByGuest = createdByGuest;
	}
	private LogActivity logActivity;
	
	
	public TypeHierarchy getSupportStatus() {
		return supportStatus;
	}
	public void setSupportStatus(TypeHierarchy supportStatus) {
		this.supportStatus = supportStatus;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSupportContent() {
		return supportContent;
	}
	public void setSupportContent(String supportContent) {
		this.supportContent = supportContent;
	}
	
	public String getSupportTickectId() {
		return supportTickectId;
	}
	public void setSupportTickectId(String supportTickectId) {
		this.supportTickectId = supportTickectId;
	}
	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}
	public LogActivity getLogActivity() {
		return logActivity;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getHeading() {
		return heading;
	}
	public void setAdditionalNotes(List<AdditionalNotes> additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public List<AdditionalNotes> getAdditionalNotes() {
		return additionalNotes;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public TypeHierarchy getSupportModule() {
		return supportModule;
	}
	public void setSupportModule(TypeHierarchy supportModule) {
		this.supportModule = supportModule;
	}

	
	
	
	

}
