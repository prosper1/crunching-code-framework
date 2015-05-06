package com.mobilebulletin.local.common;

import java.util.List;

import javax.ejb.Local;

import com.common.cms.Person;
import com.common.cms.UserInformation;
import com.common.support.SupportTicket;
import com.common.type.TypeHierarchy;
import com.mobilebulletin.company.CompanyInformation;
import com.mobilebulletin.company.EmployeeCompanyInformation;
import com.mobilebulletin.department.DepartmentInformation;
import com.mobilebulletin.department.EmployeeDepartmentInformation;
import com.mobilebulletin.group.EmployeeGroupInformation;
import com.mobilebulletin.group.GroupInformation;

@Local
public interface CommonLocalService {
	
	public TypeHierarchy getTypeHierarchyByDescription(String description) throws Exception;
	public UserInformation getUserById(long id) throws Exception;
	public Person getPersonById(long id) throws Exception;
	public Long getCurrentSequenceIdByName(String sequenceName) throws Exception;
	
	public UserInformation getUserByUniqueUsername(String uniqueUsername) throws Exception;

	public boolean checkCompanyExistByName(String companyName) throws Exception;
	
	public boolean checkEmailExistByName(String email) throws Exception;
	
	public boolean checkCellNoExistByCellNo(String cellNo) throws Exception;
	
	public boolean checkUsernameExistByName(String username) throws Exception;
	
	public UserInformation getUserByUsername(String username) throws Exception;
	
	public CompanyInformation getCompanyById(long id) throws Exception;
	
	public SupportTicket getSupportTicketById(long id) throws Exception;
	
	public GroupInformation getGroupInformationById(long id) throws Exception;
	
	public DepartmentInformation getDepartmentInformationById(long id) throws Exception;
	
	public long checkUserExistInGroupInformation(long userId,long groupId) throws Exception;
	
	public long checkUserExistInDepartmentInformation(long userId,long departmentId) throws Exception;
	
	public EmployeeDepartmentInformation getEmployeeDepartmentInfoById(long id) throws Exception;
	
	
	public EmployeeGroupInformation getEmployeeGroupInfoById(long id) throws Exception;
	
	public long getGroupNoOfMembers(long groupId) throws Exception;
	
	public long getDepartmentNoOfMembers(long departmentId) throws Exception;
	
	public List<EmployeeGroupInformation> getGroupMembers(long groupId) throws Exception;
	
	public List<EmployeeDepartmentInformation> getDepartmentMembers(long departmentId) throws Exception;
	
	public List<EmployeeCompanyInformation> getCompanyMembers(long companyId) throws Exception;
	
	
}
