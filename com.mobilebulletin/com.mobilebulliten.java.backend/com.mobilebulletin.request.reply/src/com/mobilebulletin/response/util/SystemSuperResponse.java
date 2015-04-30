package com.mobilebulletin.response.util;

import java.io.Serializable;

public class SystemSuperResponse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1093603375735039984L;
	private SERVRESPONSE response;
	private String servValidation;
	private String responseTo;
	public void setResponse(SERVRESPONSE response) {
		this.response = response;
	}
	public SERVRESPONSE getResponse() {
		return response;
	}
	public void setServValidation(String servValidation) {
		this.servValidation = servValidation;
	}
	public String getServValidation() {
		return servValidation;
	}
	public void setResponseTo(String responseTo) {
		this.responseTo = responseTo;
	}
	public String getResponseTo() {
		return responseTo;
	}
}
