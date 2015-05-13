package com.mobilebulletin.local.security;



import javax.ejb.Local;




import com.mobilebulletin.request.security.*;
import com.mobilebulletin.response.security.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SecurityLocalUtil                                                              
 *
 * This class is used for all the Security services for EJB Local purposes.
 * This is the Service class 
 ***************************************************************************************************/




@Local
public interface SecurityLocalService
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


