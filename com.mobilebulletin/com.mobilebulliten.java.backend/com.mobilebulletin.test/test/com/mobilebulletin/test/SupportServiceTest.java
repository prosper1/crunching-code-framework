package com.mobilebulletin.test;



import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;

import com.mobilebulletin.remote.support.AddGuestSupportQueryRequest;
import com.mobilebulletin.remote.support.AddGuestSupportQueryResponse;
import com.mobilebulletin.remote.support.AddUserSupportQueryRequest;
import com.mobilebulletin.remote.support.AddUserSupportQueryResponse;
import com.mobilebulletin.remote.support.GetSupportStartUpRequest;
import com.mobilebulletin.remote.support.GetSupportStartUpResponse;
import com.mobilebulletin.remote.support.GetSupportTicketByIdRequest;
import com.mobilebulletin.remote.support.GetSupportTicketByIdResponse;
import com.mobilebulletin.remote.support.GetSupportTicketsByStatusRequest;
import com.mobilebulletin.remote.support.GetSupportTicketsByStatusResponse;
import com.mobilebulletin.remote.support.SupportRemoteService;
import com.mobilebulletin.remote.support.SupportRemoteServiceProxy;
import com.mobilebulletin.remote.support.UpdateSupportQueryRequest;
import com.mobilebulletin.remote.support.UpdateSupportQueryResponse;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportTestUtil                                                              
 *
 * This class is used for all the Support Test cases purposes.
 * This is the Test class 
 ***************************************************************************************************/



public class SupportServiceTest
{
	private Object obj;
	

	@Before
	public void setUp() throws Exception 
	{
		  final String jndiName = "com.mobilebulletin/SupportRemoteBean/remote";
		  Properties properties = new Properties();
		  properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		  properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");
		  properties.put("java.naming.provider.url","localhost:1099");
		  //properties.put("java.naming.provider.url","192.168.10.10:1099");
		  Context ic = new InitialContext(properties);
		  
		  System.out.println("about to look up jndi name " + jndiName);
		  obj = ic.lookup(jndiName);
		  System.out.println("lookup returned " + obj);
		  
	}	



	//@Test
	public void testAddGuestSupportQuery() 
	{
		SupportRemoteService supportRemoteService = new SupportRemoteServiceProxy();
		
		AddGuestSupportQueryRequest request = new AddGuestSupportQueryRequest();
		AddGuestSupportQueryResponse response = new AddGuestSupportQueryResponse();
		
		try
		{ 
			response = supportRemoteService.addGuestSupportQuery(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testAddUserSupportQuery() 
	{
		SupportRemoteService supportRemoteService = new SupportRemoteServiceProxy();
		
		AddUserSupportQueryRequest request = new AddUserSupportQueryRequest();
		AddUserSupportQueryResponse response = new AddUserSupportQueryResponse();
		
		try
		{ 
			response = supportRemoteService.addUserSupportQuery(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateSupportQuery() 
	{
		SupportRemoteService supportRemoteService = new SupportRemoteServiceProxy();
		
		UpdateSupportQueryRequest request = new UpdateSupportQueryRequest();
		UpdateSupportQueryResponse response = new UpdateSupportQueryResponse();
		
		try
		{ 
			response = supportRemoteService.updateSupportQuery(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testGetSupportTicketById() 
	{
		SupportRemoteService supportRemoteService = new SupportRemoteServiceProxy();
		
		GetSupportTicketByIdRequest request = new GetSupportTicketByIdRequest();
		GetSupportTicketByIdResponse response = new GetSupportTicketByIdResponse();
		
		try
		{ 
			response = supportRemoteService.getSupportTicketById(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testGetSupportStartUp() 
	{
		SupportRemoteService supportRemoteService = new SupportRemoteServiceProxy();
		
		GetSupportStartUpRequest request = new GetSupportStartUpRequest();
		GetSupportStartUpResponse response = new GetSupportStartUpResponse();
		
		try
		{ 
			response = supportRemoteService.getSupportStartUp(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testGetSupportTicketsByStatus() 
	{
		SupportRemoteService supportRemoteService = new SupportRemoteServiceProxy();
		
		GetSupportTicketsByStatusRequest request = new GetSupportTicketsByStatusRequest();
		GetSupportTicketsByStatusResponse response = new GetSupportTicketsByStatusResponse();
		
		try
		{ 
			response = supportRemoteService.getSupportTicketsByStatus(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	@After
	public void tearDown() throws Exception 
	{
		obj = null;
	}

}	  

