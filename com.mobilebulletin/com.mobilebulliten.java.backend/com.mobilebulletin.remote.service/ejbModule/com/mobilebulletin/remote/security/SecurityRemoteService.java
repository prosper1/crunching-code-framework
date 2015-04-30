package com.mobilebulletin.remote.security;



import javax.ejb.Remote;




import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.mobilebulletin.request.security.*;
import com.mobilebulletin.response.security.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SecurityRemoteUtil                                                              
 *
 * This class is used for all the Security services for EJB Remote purposes.
 * This is the Service class 
 ***************************************************************************************************/



@WebService
@SOAPBinding(style = Style.RPC)
@Remote
public interface SecurityRemoteService
{
	


          public ActivateAccountResponse activateAccount(ActivateAccountRequest request) throws Exception;

          public ChangePasswordResponse changePassword(ChangePasswordRequest request) throws Exception;

          public CheckUserResponse checkUser(CheckUserRequest request) throws Exception;

          public UpdateUserRoleResponse updateUserRole(UpdateUserRoleRequest request) throws Exception;

          public GenerateTypesResponse generateTypes(GenerateTypesRequest request) throws Exception;

          public UpdateUserInfoResponse updateUserInfo(UpdateUserInfoRequest request) throws Exception;

          public SignUpUserResponse signUpUser(SignUpUserRequest request) throws Exception;

          public SignInResponse signIn(SignInRequest request) throws Exception;

          public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request) throws Exception;

          public GetUserInfoResponse getUserInfo(GetUserInfoRequest request) throws Exception;
}	  


