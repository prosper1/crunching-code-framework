package com.mobilebulletin.test;



import static org.junit.Assert.assertEquals;
		
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mobilebulletin.remote.ussd.USSDRemoteService;
import com.mobilebulletin.response.util.SERVRESPONSE;




import com.mobilebulletin.request.ussd.*;
import com.mobilebulletin.response.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDTestUtil                                                              
 *
 * This class is used for all the USSD Test cases purposes.
 * This is the Test class 
 ***************************************************************************************************/



public class USSDServiceTest
{
	private Object obj;
	

	@Before
	public void setUp() throws Exception 
	{
		  final String jndiName = "com.mobilebulletin/USSDRemoteBean/remote";
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
	public void testSignUpUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		SignUpUSSDRequest request = new SignUpUSSDRequest();
		SignUpUSSDResponse response = new SignUpUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.signUpUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testInitialRequestUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		InitialRequestUSSDRequest request = new InitialRequestUSSDRequest();
		InitialRequestUSSDResponse response = new InitialRequestUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.initialRequestUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testSignInUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		SignInUSSDRequest request = new SignInUSSDRequest();
		SignInUSSDResponse response = new SignInUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.signInUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testForgotPinUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		ForgotPinUSSDRequest request = new ForgotPinUSSDRequest();
		ForgotPinUSSDResponse response = new ForgotPinUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.forgotPinUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateLangaugeUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		UpdateLangaugeUSSDRequest request = new UpdateLangaugeUSSDRequest();
		UpdateLangaugeUSSDResponse response = new UpdateLangaugeUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.updateLangaugeUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testStopSMSNotificationUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		StopSMSNotificationUSSDRequest request = new StopSMSNotificationUSSDRequest();
		StopSMSNotificationUSSDResponse response = new StopSMSNotificationUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.stopSMSNotificationUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testSendSMSToDepartmentHeadUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		SendSMSToDepartmentHeadUSSDRequest request = new SendSMSToDepartmentHeadUSSDRequest();
		SendSMSToDepartmentHeadUSSDResponse response = new SendSMSToDepartmentHeadUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.sendSMSToDepartmentHeadUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testSendSMSToGroupHeadUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		SendSMSToGroupHeadUSSDRequest request = new SendSMSToGroupHeadUSSDRequest();
		SendSMSToGroupHeadUSSDResponse response = new SendSMSToGroupHeadUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.sendSMSToGroupHeadUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testSupportQueryUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		SupportQueryUSSDRequest request = new SupportQueryUSSDRequest();
		SupportQueryUSSDResponse response = new SupportQueryUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.supportQueryUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testGetEmployeeInfoUSSD() 
	{
		USSDRemoteService USSDRemoteService = new USSDRemoteServiceProxy();
		
		GetEmployeeInfoUSSDRequest request = new GetEmployeeInfoUSSDRequest();
		GetEmployeeInfoUSSDResponse response = new GetEmployeeInfoUSSDResponse();
		
		try
		{ 
			response = USSDRemoteService.getEmployeeInfoUSSD(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	@After
	public void tearDown() throws Exception 
	{
		obj = null;
	}

}	  

