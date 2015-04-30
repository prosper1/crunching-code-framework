package com.common.log;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.common.cms.Person;
import com.common.type.TypeHierarchy;

public class LogActivity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -199685265015L;
	private long id;

	private Person createdBy;	
	private Timestamp createdOn;
	private List<LoggerUpdate> loggerUpdates;
	private TypeHierarchy systemNameType;
	private String methodName;
	
	public TypeHierarchy getSystemNameType() {
		return systemNameType;
	}
	public void setSystemNameType(TypeHierarchy systemNameType) {
		this.systemNameType = systemNameType;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Person getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Person createdBy) {
		this.createdBy = createdBy;
	}
	
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public void setLoggerUpdates(List<LoggerUpdate> loggerUpdates) {
		this.loggerUpdates = loggerUpdates;
	}
	public List<LoggerUpdate> getLoggerUpdates() {
		return loggerUpdates;
	}
	
	
}
