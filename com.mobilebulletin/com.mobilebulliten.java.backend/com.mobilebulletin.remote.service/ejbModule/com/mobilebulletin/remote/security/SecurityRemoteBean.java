package com.mobilebulletin.remote.security;



import com.mobilebulletin.jms.security.SecurityRequestQueue;

import javax.ejb.Stateless;



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



@WebService(endpointInterface = "com.mobilebulletin.remote.security.SecurityRemoteService")
@Stateless
public class SecurityRemoteBean implements SecurityRemoteService
{


    public ActivateAccountResponse activateAccount(ActivateAccountRequest request) throws Exception{
	    ActivateAccountResponse response = new ActivateAccountResponse();
		
		try
		{
			response = (ActivateAccountResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ChangePasswordResponse changePassword(ChangePasswordRequest request) throws Exception{
	    ChangePasswordResponse response = new ChangePasswordResponse();
		
		try
		{
			response = (ChangePasswordResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public CheckUserResponse checkUser(CheckUserRequest request) throws Exception{
	    CheckUserResponse response = new CheckUserResponse();
		
		try
		{
			response = (CheckUserResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateUserRoleResponse updateUserRole(UpdateUserRoleRequest request) throws Exception{
	    UpdateUserRoleResponse response = new UpdateUserRoleResponse();
		
		try
		{
			response = (UpdateUserRoleResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GenerateTypesResponse generateTypes(GenerateTypesRequest request) throws Exception{
	    GenerateTypesResponse response = new GenerateTypesResponse();
		
		try
		{
			response = (GenerateTypesResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateUserInfoResponse updateUserInfo(UpdateUserInfoRequest request) throws Exception{
	    UpdateUserInfoResponse response = new UpdateUserInfoResponse();
		
		try
		{
			response = (UpdateUserInfoResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SignUpUserResponse signUpUser(SignUpUserRequest request) throws Exception{
	    SignUpUserResponse response = new SignUpUserResponse();
		
		try
		{
			response = (SignUpUserResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SignInResponse signIn(SignInRequest request) throws Exception{
	    SignInResponse response = new SignInResponse();
		
		try
		{
			response = (SignInResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request) throws Exception{
	    ForgotPasswordResponse response = new ForgotPasswordResponse();
		
		try
		{
			response = (ForgotPasswordResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetUserInfoResponse getUserInfo(GetUserInfoRequest request) throws Exception{
	    GetUserInfoResponse response = new GetUserInfoResponse();
		
		try
		{
			response = (GetUserInfoResponse) new SecurityRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


