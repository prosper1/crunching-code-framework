package com.mobilebulletin.test;



import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mobilebulletin.remote.security.ActivateAccountRequest;
import com.mobilebulletin.remote.security.ActivateAccountResponse;
import com.mobilebulletin.remote.security.ChangePasswordRequest;
import com.mobilebulletin.remote.security.ChangePasswordResponse;
import com.mobilebulletin.remote.security.CheckUserRequest;
import com.mobilebulletin.remote.security.CheckUserResponse;
import com.mobilebulletin.remote.security.ForgotPasswordRequest;
import com.mobilebulletin.remote.security.ForgotPasswordResponse;
import com.mobilebulletin.remote.security.GenerateTypesRequest;
import com.mobilebulletin.remote.security.GenerateTypesResponse;
import com.mobilebulletin.remote.security.GetUserInfoRequest;
import com.mobilebulletin.remote.security.GetUserInfoResponse;
import com.mobilebulletin.remote.security.SecurityRemoteService;
import com.mobilebulletin.remote.security.SecurityRemoteServiceProxy;
import com.mobilebulletin.remote.security.SignInRequest;
import com.mobilebulletin.remote.security.SignInResponse;
import com.mobilebulletin.remote.security.SignUpUserRequest;
import com.mobilebulletin.remote.security.SignUpUserResponse;
import com.mobilebulletin.remote.security.UpdateUserInfoRequest;
import com.mobilebulletin.remote.security.UpdateUserInfoResponse;
import com.mobilebulletin.remote.security.UpdateUserRoleRequest;
import com.mobilebulletin.remote.security.UpdateUserRoleResponse;




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
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		ActivateAccountRequest request = new ActivateAccountRequest();
		ActivateAccountResponse response = new ActivateAccountResponse();
		
		try
		{ 
			response = securityRemoteService.activateAccount(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testChangePassword() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		ChangePasswordRequest request = new ChangePasswordRequest();
		ChangePasswordResponse response = new ChangePasswordResponse();
		
		try
		{ 
			response = securityRemoteService.changePassword(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testCheckUser() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		CheckUserRequest request = new CheckUserRequest();
		CheckUserResponse response = new CheckUserResponse();
		
		try
		{ 
			response = securityRemoteService.checkUser(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	  //  assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateUserRole() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		UpdateUserRoleRequest request = new UpdateUserRoleRequest();
		UpdateUserRoleResponse response = new UpdateUserRoleResponse();
		
		try
		{ 
			response = securityRemoteService.updateUserRole(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	@Test
	public void testGenerateTypes() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		GenerateTypesRequest request = new GenerateTypesRequest();
		GenerateTypesResponse response = new GenerateTypesResponse();
		
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
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		UpdateUserInfoRequest request = new UpdateUserInfoRequest();
		UpdateUserInfoResponse response = new UpdateUserInfoResponse();
		
		try
		{ 
			response = securityRemoteService.updateUserInfo(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testSignUpUser() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		SignUpUserRequest request = new SignUpUserRequest();
		SignUpUserResponse response = new SignUpUserResponse();
		
		try
		{ 
			response = securityRemoteService.signUpUser(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testSignIn() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		SignInRequest request = new SignInRequest();
		SignInResponse response = new SignInResponse();
		
		try
		{ 
			response = securityRemoteService.signIn(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testForgotPassword() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		ForgotPasswordRequest request = new ForgotPasswordRequest();
		ForgotPasswordResponse response = new ForgotPasswordResponse();
		
		try
		{ 
			response = securityRemoteService.forgotPassword(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testGetUserInfo() 
	{
		SecurityRemoteService securityRemoteService = new SecurityRemoteServiceProxy();
		
		GetUserInfoRequest request = new GetUserInfoRequest();
		GetUserInfoResponse response = new GetUserInfoResponse();
		
		try
		{ 
			response = securityRemoteService.getUserInfo(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	@After
	public void tearDown() throws Exception 
	{
		obj = null;
	}

}	  

