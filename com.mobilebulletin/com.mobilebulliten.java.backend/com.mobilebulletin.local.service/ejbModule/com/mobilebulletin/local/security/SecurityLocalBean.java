package com.mobilebulletin.local.security;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.jboss.logging.Logger;

import com.common.cms.UserInformation;
import com.common.communication.ContactInformation;
import com.common.communication.ContactReference;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;
import com.mobilebulletin.enumerator.CONTACTTYPE;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.utils.LocalHelper;
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
import com.mobilebulletin.response.security.ActivateAccountResponse;
import com.mobilebulletin.response.security.ChangePasswordResponse;
import com.mobilebulletin.response.security.CheckUserResponse;
import com.mobilebulletin.response.security.ForgotPasswordResponse;
import com.mobilebulletin.response.security.GenerateTypesResponse;
import com.mobilebulletin.response.security.GetUserInfoResponse;
import com.mobilebulletin.response.security.SignInResponse;
import com.mobilebulletin.response.security.SignUpUserResponse;
import com.mobilebulletin.response.security.UpdateUserInfoResponse;
import com.mobilebulletin.response.security.UpdateUserRoleResponse;
import com.mobilebulletin.response.util.SERVRESPONSE;




/***************************************************************************************************
 *                                                                                                  
 * @author SecurityLocalUtil                                                              
 *
 * This class is used for all the Security beans for EJB Local purposes.
 * This is the Bean class 
 ***************************************************************************************************/




@Stateless
public class SecurityLocalBean implements SecurityLocalService
{
	private static final Logger log = Logger.getLogger(SecurityLocalBean.class.getName());
	
	@PersistenceContext(unitName = "com.mobilebulletin.model")
	private EntityManager em;

	@EJB
	private CommonLocalService commonLocalService;
	@EJB
	private SecurityLocalService securityLocalService;

    public ActivateAccountResponse activateAccount(ActivateAccountRequest request) throws Exception{
	      		ActivateAccountResponse response = new ActivateAccountResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public ChangePasswordResponse changePassword(ChangePasswordRequest request) throws Exception{
	      		ChangePasswordResponse response = new ChangePasswordResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public CheckUserResponse checkUser(CheckUserRequest request) throws Exception{
	      		CheckUserResponse response = new CheckUserResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public UpdateUserRoleResponse updateUserRole(UpdateUserRoleRequest request) throws Exception{
	      		UpdateUserRoleResponse response = new UpdateUserRoleResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public GenerateTypesResponse generateTypes(GenerateTypesRequest request) throws Exception{
	      		GenerateTypesResponse response = new GenerateTypesResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public UpdateUserInfoResponse updateUserInfo(UpdateUserInfoRequest request) throws Exception{
	      		UpdateUserInfoResponse response = new UpdateUserInfoResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public SignUpUserResponse signUpUser(SignUpUserRequest request) throws Exception{
	      		SignUpUserResponse response = new SignUpUserResponse();
		
		try
		{
			CheckUserRequest userExistRequest = new CheckUserRequest();
			CheckUserResponse userExistResponse = null;

			if (request.getEmail() != null) {
				userExistRequest.setUsername(request.getEmail());
				userExistResponse = securityLocalService
						.checkUser(userExistRequest);
			}
			UserInformation userInformation = new UserInformation();

			if (userExistResponse != null && !userExistResponse.isUserExist()) {

				userInformation.setPassword(request.getPassword());

				if (request.getUsername() != null) {
					userInformation.setUniqueUsername(request.getUsername());
				}
			
				ContactInformation contactInformation = new ContactInformation();
				List<ContactReference> contactReferences = new ArrayList<ContactReference>();

				if (request.getCellNo() != null) {
					ContactReference cellContactReference = new ContactReference();
					TypeHierarchy cellContactResponse = commonLocalService
							.getTypeHierarchyByDescription(CONTACTTYPE.Cell
									.getDescription());
					cellContactReference.setContactType(cellContactResponse);
					cellContactReference.setContact(request.getCellNo());
					contactReferences.add(cellContactReference);
				}

				ContactReference emailContactReference = new ContactReference();
				TypeHierarchy emailContactResponse = commonLocalService
						.getTypeHierarchyByDescription(CONTACTTYPE.Email
								.getDescription());
				emailContactReference.setContactType(emailContactResponse);
				emailContactReference.setContact(request.getEmail());
				contactReferences.add(emailContactReference);
				contactInformation.setContactReferences(contactReferences);
				userInformation.setContactInformation(contactInformation);
				userInformation.setUsername(emailContactReference);
				// TypeHierarchy userStatus = commonLocalService
				// .getTypeHierarchyByDescription(USER_STATUS.USER
				// .getDescription());
				// userInformation.setUserStatus(userStatus);

//				userInformation.setDateOfBirth(LocalHelper
//						.getDateFromRemoteString(request.getDateOfBirth()));
//				TypeHierarchy type = commonLocalService
//						.getTypeHierarchyByDescription(request.getGender());
//				userInformation.setGenderType(type);

				LogActivity activity = new LogActivity();
				activity.setCreatedBy(userInformation);
				activity.setCreatedOn(LocalHelper.getCurrentTime());
				userInformation.setLogActivity(activity);

				userInformation.setEmailOptOut(false);
				
				String activationCode = LocalHelper.getActivationCode();
				userInformation.setActivationCode(activationCode);
				em.persist(userInformation);
				
//				ActivationEmailRequest emailRequest = new ActivationEmailRequest();
//				emailRequest.setEmailToId(FreshHelper.encryptPrimaryKeyBytes(userInformation.getId()));
//				emailRequest.setName(userInformation.getFirstname()+" "+userInformation.getLastname());
//				emailRequest.setUsername(userInformation.getUsername().getContact());
//				emailRequest.setActivationCode(activationCode);
//				new Email2TARequestQueue().send2Queue(emailRequest);

				response.setResponse(SERVRESPONSE.RegisterUserSuccessful);
			} else {

				response.setResponse(SERVRESPONSE.UserAlreadyExists);
			}
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public SignInResponse signIn(SignInRequest request) throws Exception{
	      		SignInResponse response = new SignInResponse();
		
		try
		{
			CheckUserRequest userExistRequest = new CheckUserRequest();
			
			if(request.getUsername() != null)
			{
				userExistRequest.setUsername(request.getUsername());
				CheckUserResponse userExistResponse = securityLocalService.checkUser(userExistRequest);
		
				if(userExistResponse.isUserExist())
				{
					//Set the response variables
					response.setUserFullName(userExistResponse.getUserFullName());
					response.setUserId(userExistResponse.getUserId());
					response.setUsername(userExistResponse.getUsername());
					response.setGender(userExistResponse.getGender());
					response.setCellNo(userExistResponse.getCellNo());
					
					if(userExistResponse.isUserActive())
					{
						String queryString = "select distinct(c.id ) from cmsdb.user_info c, " +
								"commdb.contact_reference cr,typedb.type_hier tp where lower(cr.contact) = ?1 " +
								"and c.username_id = cr.id and c.password = ?2 and tp.description = 'Email' " +
								"and cr.contact_type_id = tp.id;"; 	
						
						Query query =  em.createNativeQuery(queryString);
						query.setParameter(1, request.getUsername());
						query.setParameter(2, request.getPassword());
						
						List<Object> objList = (List<Object>)query.getResultList();
						
						if(objList != null && objList.size() > 0)
						{
							for(Object o:objList)
							{
								response.setResponse(SERVRESPONSE.LoginSuccessful);
								
//								CheckImageExistByPersonIdRequest existByPersonIdRequest = new CheckImageExistByPersonIdRequest();
//								existByPersonIdRequest.setId(response.getUserId());
//								CheckImageExistByPersonIdResponse existByPersonIdResponse = imageLocalService.checkImageExistByPersonId(existByPersonIdRequest);
//								String path;
//								File f;
//								if (OSValidator.isWindows()) {
//									path ="\\"+FreshHelper.decryptPrimaryKeyBytes(response.getUserId())+"\\"+FreshHelper.decryptPrimaryKeyBytes(existByPersonIdResponse.getImageId())+"\\"+existByPersonIdResponse.getImageName();
//									f = new File(
//											"C:\\\\opt\\ftt_images_from_jackrabbit\\TAILOR_APP\\PROFILE_IMAGE"
//													+ path);
//								} else {
//
//									path = "/"+FreshHelper.decryptPrimaryKeyBytes(response.getUserId())+"/"+FreshHelper.decryptPrimaryKeyBytes(existByPersonIdResponse.getImageId())+"/"+existByPersonIdResponse.getImageName();
//									f = new File(
//											"/opt/ftt_images_from_jackrabbit/TAILOR_APP/PROFILE_IMAGE"
//													+ path);
//
//								}
//								if (!f.exists() && existByPersonIdResponse.isExist()) {
//									GetChroppedPersonImageByIdRequest companyImageByIdRequest = new GetChroppedPersonImageByIdRequest();
//									companyImageByIdRequest.setFileName(existByPersonIdResponse.getImageName());
//									companyImageByIdRequest.setImageId(FreshHelper.decryptPrimaryKeyBytes(existByPersonIdResponse.getImageId()));
//									companyImageByIdRequest.setPersonId(FreshHelper.decryptPrimaryKeyBytes(response.getUserId()));
//									GetChroppedPersonImageByIdResponse personImageByIdResponse = jrabbitImageLocalService
//											.getChroppedPersonImageById(companyImageByIdRequest);
////									response.setResponse(personImageByIdResponse.getResponse());
//								}
//								if(existByPersonIdResponse.isExist())
//									response.setImagePath(path);
//							    break;
							}
						}else
						{
							response.setResponse(SERVRESPONSE.LoginFailed);
						}
					}else
					{
//						if(userExistResponse.getActivationCode() != null && !userExistResponse.getActivationCode().equalsIgnoreCase("")){
//							ActivationEmailRequest emailRequest = new ActivationEmailRequest();
//							emailRequest.setActivationCode(userExistResponse.getActivationCode());
//							emailRequest.setName(userExistResponse.getUserFullName());
//							emailRequest.setUsername(userExistResponse.getUsername());
//							emailRequest.setEmailToId(userExistResponse.getUserId());
//							new Email2RequestQueue().send2Queue(emailRequest);
//						}else{
//							RegisterErrorEmailRequest emailRequest = new RegisterErrorEmailRequest();
//							emailRequest.setName(userExistResponse.getUserFullName());
//							emailRequest.setUsername(userExistResponse.getUsername());
//							emailRequest.setEmailToId(userExistResponse.getUserId());
//							new Email2RequestQueue().send2Queue(emailRequest);
//						}
						response.setResponse(SERVRESPONSE.UserNotActive);
					}
				}else
			    {
			    	response.setResponse(SERVRESPONSE.UserNotFound);
			    }
			}
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request) throws Exception{
	      		ForgotPasswordResponse response = new ForgotPasswordResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public GetUserInfoResponse getUserInfo(GetUserInfoRequest request) throws Exception{
	      		GetUserInfoResponse response = new GetUserInfoResponse();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  
}	  


