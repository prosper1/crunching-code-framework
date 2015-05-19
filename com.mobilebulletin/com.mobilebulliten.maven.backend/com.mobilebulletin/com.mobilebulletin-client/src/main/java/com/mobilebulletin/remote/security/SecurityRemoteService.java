package com.mobilebulletin.remote.security;



import javax.ejb.Remote;




import javax.jws.HandlerChain;
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



@WebService(portName="SecurityServicePortType", targetNamespace="mobilebulletin")
@HandlerChain(file = "../../../../com/mobilebulletin/secure/webservices/security_handler.xml")
@Remote
public interface SecurityRemoteService
{
	


          public ActivateAccountReply activateAccount(ActivateAccountRequest request) throws Exception;

          public ChangePasswordReply changePassword(ChangePasswordRequest request) throws Exception;

          public CheckUserReply checkUser(CheckUserRequest request) throws Exception;

          public UpdateUserRoleReply updateUserRole(UpdateUserRoleRequest request) throws Exception;

          public GenerateTypesReply generateTypes(GenerateTypesRequest request) throws Exception;

          public UpdateUserInfoReply updateUserInfo(UpdateUserInfoRequest request) throws Exception;

          public SignUpUserReply signUpUser(SignUpUserRequest request) throws Exception;

          public SignInReply signIn(SignInRequest request) throws Exception;

          public ForgotPasswordReply forgotPassword(ForgotPasswordRequest request) throws Exception;

          public GetUserInfoReply getUserInfo(GetUserInfoRequest request) throws Exception;
}	  


