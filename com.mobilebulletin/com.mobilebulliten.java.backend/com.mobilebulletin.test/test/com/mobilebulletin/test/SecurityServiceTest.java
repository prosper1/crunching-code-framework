package com.mobilebulletin.test;



import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mobilebulletin.remote.security.SecurityRemoteService;
import com.mobilebulletin.request.security.ActivateAccountRequest;
import com.mobilebulletin.request.security.ChangePasswordRequest;
import com.mobilebulletin.request.security.CheckUserRequest;
import com.mobilebulletin.request.security.ForgotPasswordRequest;
import com.mobilebulletin.request.security.GenerateTypesRequest;
import com.mobilebulletin.request.security.GetUserInfoRequest;
import com.mobilebulletin.request.security.SignInRequest;
import com.mobilebulletin.request.security.SignUpUserRequest;
import com.mobilebulletin.request.security.UpdateUserInfoRequest;
import com.mobilebulletin.request.security.UpdateUserRoleRequest;
import com.mobilebulletin.response.security.ActivateAccountReply;
import com.mobilebulletin.response.security.ChangePasswordReply;
import com.mobilebulletin.response.security.CheckUserReply;
import com.mobilebulletin.response.security.ForgotPasswordReply;
import com.mobilebulletin.response.security.GenerateTypesReply;
import com.mobilebulletin.response.security.GetUserInfoReply;
import com.mobilebulletin.response.security.SignInReply;
import com.mobilebulletin.response.security.SignUpUserReply;
import com.mobilebulletin.response.security.UpdateUserInfoReply;
import com.mobilebulletin.response.security.UpdateUserRoleReply;
import com.mobilebulletin.webservice.client.SecurityServiceConnector;




/***************************************************************************************************
 *                                                                                                  
 * @author SecurityTestUtil                                                              
 *
 * This class is used for all the Security Test cases purposes.
 * This is the Test class 
 ***************************************************************************************************/



public class SecurityServiceTest
{
	private Object obj;
	

	@Before
	public void setUp() throws Exception 
	{
		  final String jndiName = "com.mobilebulletin/SecurityRemoteBean/remote";
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
	public void testActivateAccount() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		ActivateAccountRequest request = new ActivateAccountRequest();
		ActivateAccountReply response = new ActivateAccountReply();
		
		try
		{ 
			response = securityRemoteService.activateAccount(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	//@Test
	public void testChangePassword() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		ChangePasswordRequest request = new ChangePasswordRequest();
		ChangePasswordReply response = new ChangePasswordReply();
		
		try
		{ 
			response = securityRemoteService.changePassword(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	//@Test
	public void testCheckUser() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		CheckUserRequest request = new CheckUserRequest();
		CheckUserReply response = new CheckUserReply();
		
		try
		{ 
			response = securityRemoteService.checkUser(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	  //  assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	//@Test
	public void testUpdateUserRole() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		UpdateUserRoleRequest request = new UpdateUserRoleRequest();
		UpdateUserRoleReply response = new UpdateUserRoleReply();
		
		try
		{ 
			response = securityRemoteService.updateUserRole(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	@Test
	public void testGenerateTypes() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		GenerateTypesRequest request = new GenerateTypesRequest();
		GenerateTypesReply response = new GenerateTypesReply();
		
		try
		{ 
			response = securityRemoteService.generateTypes(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateUserInfo() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		UpdateUserInfoRequest request = new UpdateUserInfoRequest();
		UpdateUserInfoReply response = new UpdateUserInfoReply();
		
		try
		{ 
			response = securityRemoteService.updateUserInfo(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	//@Test
	public void testSignUpUser() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		SignUpUserRequest request = new SignUpUserRequest();
		SignUpUserReply response = new SignUpUserReply();
		
		try
		{ 
			response = securityRemoteService.signUpUser(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	//@Test
	public void testSignIn() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		SignInRequest request = new SignInRequest();
		SignInReply response = new SignInReply();
		
		try
		{ 
			response = securityRemoteService.signIn(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	//@Test
	public void testForgotPassword() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		ForgotPasswordRequest request = new ForgotPasswordRequest();
		ForgotPasswordReply response = new ForgotPasswordReply();
		
		try
		{ 
			response = securityRemoteService.forgotPassword(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	//@Test
	public void testGetUserInfo() 
	{
		SecurityRemoteService securityRemoteService = SecurityServiceConnector.getServicePort();
		
		GetUserInfoRequest request = new GetUserInfoRequest();
		GetUserInfoReply response = new GetUserInfoReply();
		
		try
		{ 
			response = securityRemoteService.getUserInfo(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getReply().getDescription());
	}

	@After
	public void tearDown() throws Exception 
	{
		obj = null;
	}

}	  

