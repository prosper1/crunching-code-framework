package com.mobilebulletin.company;

import java.io.Serializable;
import java.util.List;

import com.common.communication.AddressInfomation;
import com.common.communication.ContactInformation;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;

public class CompanyInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9029537495207218078L;

	private String tradingName;
	private ContactInformation contactInformation;
	private AddressInfomation addressInfomation;
	private LogActivity logActivity;
	private List<TypeHierarchy> roles;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTradingName() {
		return tradingName;
	}
	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}
	public ContactInformation getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}
	public AddressInfomation getAddressInfomation() {
		return addressInfomation;
	}
	public void setAddressInfomation(AddressInfomation addressInfomation) {
		this.addressInfomation = addressInfomation;
	}
	public LogActivity getLogActivity() {
		return logActivity;
	}
	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}
	public List<TypeHierarchy> getRoles() {
		return roles;
	}
	public void setRoles(List<TypeHierarchy> roles) {
		this.roles = roles;
	}
	

}
