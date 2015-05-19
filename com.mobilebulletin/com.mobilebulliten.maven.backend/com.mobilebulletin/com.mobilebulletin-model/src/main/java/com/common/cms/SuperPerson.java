package com.common.cms;

import java.io.Serializable;
public abstract class SuperPerson implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7213563322875693542L;
	private long id;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}