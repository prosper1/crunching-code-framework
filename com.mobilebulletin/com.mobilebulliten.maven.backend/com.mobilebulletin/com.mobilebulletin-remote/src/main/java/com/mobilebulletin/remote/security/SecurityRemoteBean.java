package com.mobilebulletin.remote.security;



import com.mobilebulletin.jms.security.SecurityRequestQueue;

import javax.ejb.Stateless;



import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.mobilebulletin.request.security.*;
import com.mobilebulletin.response.security.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SecurityRemoteUtil                                                              
 *
 * This class is used for all the Security beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/



@WebService(serviceName = "MobileBulletin", portName = "SecurityService", targetNamespace = "mobilebulletin")
@Stateless
public class SecurityRemoteBean implements SecurityRemoteService
{


    public ActivateAccountReply activateAccount(ActivateAccountRequest request) throws Exception{
	    ActivateAccountReply response = new ActivateAccountReply();
		
		try
		{
			response = (ActivateAccountReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ChangePasswordReply changePassword(ChangePasswordRequest request) throws Exception{
	    ChangePasswordReply response = new ChangePasswordReply();
		
		try
		{
			response = (ChangePasswordReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public CheckUserReply checkUser(CheckUserRequest request) throws Exception{
	    CheckUserReply response = new CheckUserReply();
		
		try
		{
			response = (CheckUserReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateUserRoleReply updateUserRole(UpdateUserRoleRequest request) throws Exception{
	    UpdateUserRoleReply response = new UpdateUserRoleReply();
		
		try
		{
			response = (UpdateUserRoleReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GenerateTypesReply generateTypes(GenerateTypesRequest request) throws Exception{
	    GenerateTypesReply response = new GenerateTypesReply();
		
		try
		{
			response = (GenerateTypesReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateUserInfoReply updateUserInfo(UpdateUserInfoRequest request) throws Exception{
	    UpdateUserInfoReply response = new UpdateUserInfoReply();
		
		try
		{
			response = (UpdateUserInfoReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SignUpUserReply signUpUser(SignUpUserRequest request) throws Exception{
	    SignUpUserReply response = new SignUpUserReply();
		
		try
		{
			response = (SignUpUserReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SignInReply signIn(SignInRequest request) throws Exception{
	    SignInReply response = new SignInReply();
		
		try
		{
			response = (SignInReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ForgotPasswordReply forgotPassword(ForgotPasswordRequest request) throws Exception{
	    ForgotPasswordReply response = new ForgotPasswordReply();
		
		try
		{
			response = (ForgotPasswordReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetUserInfoReply getUserInfo(GetUserInfoRequest request) throws Exception{
	    GetUserInfoReply response = new GetUserInfoReply();
		
		try
		{
			response = (GetUserInfoReply) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


