package com.common.communication;

import java.io.Serializable;

import com.common.type.TypeHierarchy;

public class ContactReference  implements Serializable{

	private static final long serialVersionUID = -257412645453557412L;
	private long id;
	private String contact;
	private TypeHierarchy contactType;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public TypeHierarchy getContactType() {
		return contactType;
	}

	public void setContactType(TypeHierarchy contactType) {
		this.contactType = contactType;
	}

	public ContactReference() {
		contactType = new TypeHierarchy();
	}
}
