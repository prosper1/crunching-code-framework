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


