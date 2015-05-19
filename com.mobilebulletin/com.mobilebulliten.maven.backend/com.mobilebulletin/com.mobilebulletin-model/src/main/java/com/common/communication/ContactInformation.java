package com.common.communication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ContactInformation  implements Serializable{
	private static final long serialVersionUID = -2574125519153557412L;
	private long id;
	private List<ContactReference> contactReferences;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ContactReference> getContactReferences() {
		return contactReferences;
	}

	public void setContactReferences(List<ContactReference> contactReferences) {
		this.contactReferences = contactReferences;
	}

	public ContactInformation() {
		contactReferences = new ArrayList<ContactReference>();
	}

	

	
}
