package com.mobilebulletin.local.common;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.common.cms.Person;
import com.common.cms.UserInformation;
import com.common.communication.ContactReference;
import com.common.support.SupportTicket;
import com.common.type.TypeHierarchy;
import com.mobilebulletin.company.CompanyInformation;
import com.mobilebulletin.company.EmployeeCompanyInformation;
import com.mobilebulletin.department.DepartmentInformation;
import com.mobilebulletin.department.EmployeeDepartmentInformation;
import com.mobilebulletin.group.EmployeeGroupInformation;
import com.mobilebulletin.group.GroupInformation;

@Stateless
public class CommonLocalBean implements CommonLocalService{

	@PersistenceContext(unitName="com.mobilebulletin.model")
    private EntityManager em;
	
	@EJB 
	private CommonLocalService commonLocalService;
	private static final Logger log = Logger.getLogger(CommonLocalService.class
			.getName());
	@Override
	public TypeHierarchy getTypeHierarchyByDescription(String description)
			throws Exception {
		TypeHierarchy type = null;
		try
		{
			String queryString = "SELECT x FROM TypeHierarchy x where lower(x.description) = :descriptionParam";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("descriptionParam", description.toLowerCase().trim());
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					type = (TypeHierarchy)o;
					return type;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return null;
	}
	

	@Override
	public UserInformation getUserById(long id) throws Exception
	{
		UserInformation user = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			user = em.find(UserInformation.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return user;
	}

	@Override
	public UserInformation getUserByUniqueUsername(String uniqueUsername) throws Exception
	{
		UserInformation user = null;
		try
		{
			String queryString = "SELECT x FROM UserInformation x where lower(x.uniqueUsername) = :uniqueUsernameParam";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("uniqueUsernameParam", uniqueUsername.toLowerCase());
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					user = (UserInformation)o;
					return user;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return null;
	}
	
	@Override
	public Person getPersonById(long id) throws Exception {
		Person results = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			results = em.find(Person.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return results;
	}
	
	@Override
	public Long getCurrentSequenceIdByName(String sequenceName)
			throws Exception {
		Long sequenceId = null;
		
		try
		{
			String sql = "select currval('"+sequenceName+"');";
			Query query =  em.createNativeQuery(sql);
			sequenceId = (Long)query.getSingleResult();
		}catch(Exception e)
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
		}
		return sequenceId;
	}


	@Override
	public boolean checkCompanyExistByName(String companyName) throws Exception {
		CompanyInformation companyInformation = null;
		try
		{
			String queryString = "SELECT x FROM CompanyInformation x where lower(x.tradingName) = :companyNameParam";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("companyNameParam", companyName.toLowerCase());
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					companyInformation = (CompanyInformation)o;
					return true;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return false;
	}


	@Override
	public boolean checkEmailExistByName(String email) throws Exception {
		ContactReference contactReference = null;
		try
		{
			String queryString = "SELECT x FROM ContactReference x where lower(x.contact) = :contactParam";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("contactParam", email.toLowerCase());
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					contactReference = (ContactReference)o;
					return true;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return false;
	}


	@Override
	public boolean checkUsernameExistByName(String username) throws Exception {
		UserInformation userInformation = null;
		try
		{
			String queryString = "SELECT x FROM UserInformation x where lower(x.uniqueUsername) = :uniqueUsernameParam";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("uniqueUsernameParam", username.toLowerCase());
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					userInformation = (UserInformation)o;
					return true;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return false;
	}


	@Override
	public UserInformation getUserByUsername(String username) throws Exception {
		UserInformation userInformation = null;
		try
		{
			String queryString = "SELECT x FROM UserInformation x where lower(x.uniqueUsername) = :uniqueUsernameParam";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("uniqueUsernameParam", username.toLowerCase());
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					userInformation = (UserInformation)o;
					return userInformation;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return null;
	}


	@Override
	public boolean checkCellNoExistByCellNo(String cellNo) throws Exception {
		ContactReference contactReference = null;
		try
		{
			String queryString = "SELECT x FROM ContactReference x where lower(x.contact) = :contactParam";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("contactParam", cellNo.toLowerCase());
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					contactReference = (ContactReference)o;
					return true;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return false;
	}


	@Override
	public CompanyInformation getCompanyById(long id) throws Exception {
		CompanyInformation results = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			results = em.find(CompanyInformation.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return results;
	}


	@Override
	public SupportTicket getSupportTicketById(long id) throws Exception {
		SupportTicket results = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			results = em.find(SupportTicket.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return results;
	}


	@Override
	public GroupInformation getGroupInformationById(long id) throws Exception {
		GroupInformation results = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			results = em.find(GroupInformation.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return results;
	}


	@Override
	public DepartmentInformation getDepartmentInformationById(long id)
			throws Exception {
		DepartmentInformation results = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			results = em.find(DepartmentInformation.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return results;
	}


	@Override
	public long checkUserExistInGroupInformation(long userId, long groupId)
			throws Exception {
		try
		{
			
			String queryString = "SELECT x.id FROM EmployeeGroupInformation x where x.userInformation.id = :userIdParam and  x.groupInformation.id = :groupIdParam ";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("userIdParam", userId);
			query.setParameter("groupIdParam", groupId);
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					Long employeeGroupInformation = (Long)o;
					return employeeGroupInformation;
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			throw e;
		}
		return 0L;
	}


	@Override
	public long checkUserExistInDepartmentInformation(long userId,
			long departmentId) throws Exception {
		try
		{
			
			String queryString = "SELECT x FROM EmployeeDepartmentInformation x where x.userInformation.id = :userIdParam and  x.departmentInformation.id = :departmentIdParam ";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("userIdParam", userId);
			query.setParameter("departmentIdParam", departmentId);
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					EmployeeDepartmentInformation employeeDepartmentInformation = (EmployeeDepartmentInformation)o;
					return employeeDepartmentInformation.getId();
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			throw e;
		}
		return 0L;
	}


	@Override
	public EmployeeDepartmentInformation getEmployeeDepartmentInfoById(long id)
			throws Exception {
		EmployeeDepartmentInformation results = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			results = em.find(EmployeeDepartmentInformation.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return results;
	}


	@Override
	public EmployeeGroupInformation getEmployeeGroupInfoById(long id)
			throws Exception {
		EmployeeGroupInformation results = null;
		
		try
		{
			//Use the entity manager to find the user information by id
			results = em.find(EmployeeGroupInformation.class, id);
		}catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Return the user
		return results;
	}


	@Override
	public long getGroupNoOfMembers(long groupId) throws Exception {
		Long numberOfMembers = null;
		
		try
		{
			String sql = "select count(id) from grpdb.employee_group_information where groupinfo_id = ?1;";
			Query query =  em.createNativeQuery(sql);
			query.setParameter(1, groupId);
			numberOfMembers = (Long)query.getSingleResult();
		}catch(Exception e)
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
		}
		return numberOfMembers;
	}


	@Override
	public long getDepartmentNoOfMembers(long departmentId) throws Exception {
		Long numberOfMembers = null;
		
		try
		{
			String sql = "select count(id) from depdb.employee_department_information where departmentinfo_id = ?1;";
			Query query =  em.createNativeQuery(sql);
			query.setParameter(1, departmentId);
			numberOfMembers = (Long)query.getSingleResult();
		}catch(Exception e)
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
		}
		return numberOfMembers;
	}


	@Override
	public List<EmployeeGroupInformation> getGroupMembers(long groupId)
			throws Exception {
		List<EmployeeGroupInformation> employeeGroupInformations = new ArrayList<EmployeeGroupInformation>();
		try
		{
			
			String queryString = "SELECT x FROM EmployeeGroupInformation x where  x.groupInformation.id = :groupIdParam ";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("groupIdParam", groupId);
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					EmployeeGroupInformation employeeGroupInformation = (EmployeeGroupInformation)o;
					employeeGroupInformations.add(employeeGroupInformation);
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return employeeGroupInformations;
	}


	@Override
	public List<EmployeeDepartmentInformation> getDepartmentMembers(
			long departmentId) throws Exception {
		List<EmployeeDepartmentInformation> employeeDepartmentInformations = new ArrayList<EmployeeDepartmentInformation>();
		
		try
		{
			
			String queryString = "SELECT x FROM EmployeeDepartmentInformation x where  x.departmentInformation.id = :departmentIdParam ";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("departmentIdParam", departmentId);
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					EmployeeDepartmentInformation employeeDepartmentInformation = (EmployeeDepartmentInformation)o;
					employeeDepartmentInformations.add(employeeDepartmentInformation);
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return employeeDepartmentInformations;
	}


	@Override
	public List<EmployeeCompanyInformation> getCompanyMembers(long companyId)
			throws Exception {
		List<EmployeeCompanyInformation> employeeDepartmentInformations = new ArrayList<EmployeeCompanyInformation>();
		
		try
		{
			
			String queryString = "SELECT x FROM EmployeeCompanyInformation x where  x.companyInformation.id = :companyIdParam ";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("companyIdParam", companyId);
			List<Object> objList = (List<Object>)query.getResultList();
			
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					EmployeeCompanyInformation employeeCompanyInformation = (EmployeeCompanyInformation)o;
					employeeDepartmentInformations.add(employeeCompanyInformation);
				}
			}
		}catch (Exception e) 
		{
			String errorMessage = e.getMessage();
			log.error(errorMessage);
			
		}
		return employeeDepartmentInformations;
	}


	
}
