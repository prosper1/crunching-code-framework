package com.mobilebulletin.local.common;

import javax.ejb.Local;

import com.common.cms.Person;
import com.common.cms.UserInformation;
import com.common.type.TypeHierarchy;

@Local
public interface CommonLocalService {
	
	public TypeHierarchy getTypeHierarchyByDescription(String description) throws Exception;
	public UserInformation getUserById(long id) throws Exception;
	public Person getPersonById(long id) throws Exception;
	public Long getCurrentSequenceIdByName(String sequenceName) throws Exception;
	
	public UserInformation getUserByUniqueUsername(String uniqueUsername) throws Exception;
	
}
