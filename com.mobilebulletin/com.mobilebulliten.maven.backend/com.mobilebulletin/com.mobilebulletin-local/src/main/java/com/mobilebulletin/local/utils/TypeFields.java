package com.mobilebulletin.local.utils;

import java.io.Serializable;

public class TypeFields implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 245515903391518665L;

	private String childCode, childDescription;
	private int ordinal;
	
	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public String getChildCode() {
		return childCode;
	}

	public void setChildCode(String childCode) {
		this.childCode = childCode;
	}

	public String getChildDescription() {
		return childDescription;
	}

	public void setChildDescription(String childDescription) {
		this.childDescription = childDescription;
	}
}
