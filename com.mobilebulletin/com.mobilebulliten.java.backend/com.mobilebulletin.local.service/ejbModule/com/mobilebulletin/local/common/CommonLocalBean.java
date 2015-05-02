package com.mobilebulletin.local.common;

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
import com.common.type.TypeHierarchy;
import com.mobilebulletin.company.CompanyInformation;

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


	
}
