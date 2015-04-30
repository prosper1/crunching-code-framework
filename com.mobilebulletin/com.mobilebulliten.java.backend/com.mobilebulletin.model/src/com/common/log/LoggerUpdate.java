package com.common.log;

import java.io.Serializable;
import java.sql.Timestamp;

import com.common.cms.Person;
import com.common.type.TypeHierarchy;

public class LoggerUpdate  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 15L;
	private long id;

	private Person lastUpdatedBy;
	private Timestamp lastUpdated;
	private TypeHierarchy systemNameType;
	private String methodName;
	
	public TypeHierarchy getSystemNameType() {
		return systemNameType;
	}
	public void setSystemNameType(TypeHierarchy systemNameType) {
		this.systemNameType = systemNameType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Person getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(Person lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
}
