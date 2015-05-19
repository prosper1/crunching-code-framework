package com.common.communication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class AddressInfomation  implements Serializable
{
	private static final long serialVersionUID = -2574126019153554412L;
	private long id;
	
	private List<Address> addresses;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public AddressInfomation() {
		addresses = new ArrayList<Address>();
	}
	
}
