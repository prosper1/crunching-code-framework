package com.common.cms;

import java.io.Serializable;
import java.util.Date;

import com.common.communication.AddressInfomation;
import com.common.communication.ContactInformation;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;
public abstract class Person extends SuperPerson implements Serializable{
	public Person(){}
	
	private static final long serialVersionUID = -2574126019196557412L;
	
	private String fullnameAndSurname;
	private String firstname;
	private String middleName;
	private String lastname;
	private String initials;
	private Date dateOfBirth;
	private TypeHierarchy genderType;
	private TypeHierarchy titleType;
	private TypeHierarchy disabilityType;
	private TypeHierarchy raceType;
	private TypeHierarchy langaugeType;
	public TypeHierarchy getLangaugeType() {
		return langaugeType;
	}
	public void setLangaugeType(TypeHierarchy langaugeType) {
		this.langaugeType = langaugeType;
	}
	public TypeHierarchy getDisabilityType() {
		return disabilityType;
	}
	public void setDisabilityType(TypeHierarchy disabilityType) {
		this.disabilityType = disabilityType;
	}
	public TypeHierarchy getRaceType() {
		return raceType;
	}
	public void setRaceType(TypeHierarchy raceType) {
		this.raceType = raceType;
	}

	private LogActivity logActivity;
	private ContactInformation contactInformation;
	private AddressInfomation addressInfomation;
	private boolean emailOptOut;
	
	public boolean isEmailOptOut() {
		return emailOptOut;
	}
	public void setEmailOptOut(boolean emailOptOut) {
		this.emailOptOut = emailOptOut;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public TypeHierarchy getGenderType() {
		return genderType;
	}

	public void setGenderType(TypeHierarchy genderType) {
		this.genderType = genderType;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setLogActivity(LogActivity logActivity) {
		this.logActivity = logActivity;
	}

	public LogActivity getLogActivity() {
		return logActivity;
	}

	public void setAddressInfomation(AddressInfomation addressInfomation) {
		this.addressInfomation = addressInfomation;
	}

	public AddressInfomation getAddressInfomation() {
		return addressInfomation;
	}
	public void setTitleType(TypeHierarchy titleType) {
		this.titleType = titleType;
	}
	public TypeHierarchy getTitleType() {
		return titleType;
	}
	public String getFullnameAndSurname() {
		return fullnameAndSurname;
	}
	public void setFullnameAndSurname(String fullnameAndSurname) {
		this.fullnameAndSurname = fullnameAndSurname;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	
	
}
