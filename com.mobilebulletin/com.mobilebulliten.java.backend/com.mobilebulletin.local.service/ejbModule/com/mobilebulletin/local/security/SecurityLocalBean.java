package com.mobilebulletin.local.security;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.common.cms.UserInformation;
import com.common.communication.ContactInformation;
import com.common.communication.ContactReference;
import com.common.log.LogActivity;
import com.common.type.TypeCode;
import com.common.type.TypeHierarchy;
import com.mobilebulletin.company.CompanyInformation;
import com.mobilebulletin.company.EmployeeCompanyInformation;
import com.mobilebulletin.enumerator.ACTIVATION_STATUS_TYPE;
import com.mobilebulletin.enumerator.ADDRESSTYPE;
import com.mobilebulletin.enumerator.CONTACTTYPE;
import com.mobilebulletin.enumerator.GENDER;
import com.mobilebulletin.enumerator.LANGUAGE_TYPE;
import com.mobilebulletin.enumerator.ROLE_TYPE;
import com.mobilebulletin.enumerator.SUPPORT_MODULE_TYPE;
import com.mobilebulletin.enumerator.SUPPORT_STATUS;
import com.mobilebulletin.enumerator.SYSTEM_TYPE;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.utils.FreshHelper;
import com.mobilebulletin.local.utils.LocalHelper;
import com.mobilebulletin.local.utils.TypeFields;
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
			String nativeSql = "select distinct(p.id),u.uniqueusername," +
					"lower(cr.contact),lower(cr1.contact),u.useractive,tp3.description,u.activationcode from " +
					"commdb.contact_reference cr,commdb.contact_reference cr1," +
					"typedb.type_hier tp,typedb.type_hier tp1,typedb.type_hier tp3,commdb.contactinfo_contactref cicr," +
					"commdb.contactinfo_contactref cicr1,cmsdb.person p,cmsdb.user_info u   " +
					"where cr.contact_type_id = tp.id and cr1.contact_type_id = tp1.id and " +
					"cicr.contactref_id = cr.id and cicr1.contactref_id = cr1.id and " +
					"p.contactinformation_id = cicr.contactinfo_id and " +
					"p.contactinformation_id = cicr1.contactinfo_id and tp.description = 'Email' " +
					"and tp1.description = 'Cell' and p.id = u.id and lower(cr.contact) = ?1 and tp3.id = u.activationstatus_id;";
			Query query = em.createNativeQuery(nativeSql);
			query.setParameter(1, request.getUsername().toLowerCase());
			String password = null;
			List<Object> objList = (List<Object>) query.getResultList();

			for (Object o : objList) {
				Object[] os = (Object[]) o;
				Object object1 = os[0];
				Object object2 = os[1];
				Object object3 = os[2];
				Object object4 = os[3];
				Object object5 = os[4];
				Object object6 = os[5];
				Object object7 = os[6];
//				Object object8 = os[7];
				if (object1 != null) {
					response.setUserId(FreshHelper.encryptPrimaryKeyBytes((Long) object1));
				}
				if (object2 != null) {
					response.setUserFullName(object2.toString());
				}
				if (object3 != null) {
					response.setUsername(object3.toString());
				}
				if (object4 != null) {
					response.setCellNo(object4.toString());
				}
				if (object5 != null) {
					response.setUserActive((Boolean) object5);
				}
				 if (object6 != null) {
					 if (object6.toString().equalsIgnoreCase(SERVRESPONSE.AccountNotVerified.getDescription())) {
							response.setResponse(SERVRESPONSE.AccountNotVerified);
							response.setActivationStatus(SERVRESPONSE.AccountNotVerified.getDescription());
						} else {
							response.setResponse(SERVRESPONSE.AccountVerified);
							response.setActivationStatus(SERVRESPONSE.AccountVerified.getDescription());
						}
				 }
				 if (object7 != null) {
					 response.setActivationCode(object7.toString());
					
				 }
				response.setUserExist(true);
//				if (object8 != null) {
//					response.setUserRole(object8.toString());
//				}
				
				
			}
			if (objList == null || objList.size() <= 0) {
				response.setResponse(SERVRESPONSE.InvalidUsernamePassword);
				//throw new UserNotFoundException("Invalid Username/Password",null);
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
			for (TypeCode typeCode : TypeCode.values()) {
				TypeHierarchy parentEnumHierarchy = null;
				try {
					parentEnumHierarchy = commonLocalService
							.getTypeHierarchyByDescription(typeCode.toString());
				} catch (Exception e) {
					log.error("TypeHierarchy " + typeCode.toString()
							+ " not found.");
				}
				if (parentEnumHierarchy == null) {
					List<TypeFields> fields = new ArrayList<TypeFields>();
					if (typeCode.toString().equals(TypeCode.GENDER.toString())) {
						for (GENDER gender : GENDER.values()) {
							TypeFields typeFields = new TypeFields();
							typeFields.setChildCode(gender.getCode());
							typeFields.setChildDescription(gender
									.getDescription());
							typeFields.setOrdinal(gender.ordinal());
							fields.add(typeFields);
						}
					} else if (typeCode.toString().equals(
							TypeCode.ADDRESSTYPE.toString())) {
						for (ADDRESSTYPE addresstype : ADDRESSTYPE.values()) {
							TypeFields typeFields = new TypeFields();
							typeFields.setChildCode(addresstype.getCode());
							typeFields.setChildDescription(addresstype
									.getDescription());
							typeFields.setOrdinal(addresstype.ordinal());
							fields.add(typeFields);
						}
					} else if (typeCode.toString().equals(
							TypeCode.CONTACTTYPE.toString())) {
						for (CONTACTTYPE contacttype : CONTACTTYPE.values()) {
							TypeFields typeFields = new TypeFields();
							typeFields.setChildCode(contacttype.getCode());
							typeFields.setChildDescription(contacttype
									.getDescription());
							typeFields.setOrdinal(contacttype.ordinal());
							fields.add(typeFields);
						}
					}  else if (typeCode.toString().equals(
							TypeCode.SUPPORT_STATUS.toString())) {
						for (SUPPORT_STATUS contacttype : SUPPORT_STATUS.values()) {
							TypeFields typeFields = new TypeFields();
							typeFields.setChildCode(contacttype.getCode());
							typeFields.setChildDescription(contacttype
									.getDescription());
							typeFields.setOrdinal(contacttype.ordinal());
							fields.add(typeFields);
						}
					} else if (typeCode.toString().equals(
							TypeCode.SUPPORT_MODULE_TYPE.toString())) {
						for (SUPPORT_MODULE_TYPE contacttype : SUPPORT_MODULE_TYPE.values()) {
							TypeFields typeFields = new TypeFields();
							
							typeFields.setChildCode(contacttype.getCode());
							typeFields.setChildDescription(contacttype
									.getDescription());
							typeFields.setOrdinal(contacttype.ordinal());
							fields.add(typeFields);
						}
					} else if (typeCode.toString().equals(
							TypeCode.ACTIVATION_STATUS_TYPE.toString())) {
						for (ACTIVATION_STATUS_TYPE contacttype : ACTIVATION_STATUS_TYPE.values()) {
							TypeFields typeFields = new TypeFields();
							
							typeFields.setChildCode(contacttype.getCode());
							typeFields.setChildDescription(contacttype
									.getDescription());
							typeFields.setOrdinal(contacttype.ordinal());
							fields.add(typeFields);
						}
					} else if (typeCode.toString().equals(
							TypeCode.ROLE_TYPE.toString())) {
						for (ROLE_TYPE contacttype : ROLE_TYPE.values()) {
							TypeFields typeFields = new TypeFields();
							
							typeFields.setChildCode(contacttype.getCode());
							typeFields.setChildDescription(contacttype
									.getDescription());
							typeFields.setOrdinal(contacttype.ordinal());
							fields.add(typeFields);
						}
					} else if (typeCode.toString().equals(
							TypeCode.SYSTEM_TYPE.toString())) {
						for (SYSTEM_TYPE contacttype : SYSTEM_TYPE.values()) {
							TypeFields typeFields = new TypeFields();
							
							typeFields.setChildCode(contacttype.getCode());
							typeFields.setChildDescription(contacttype
									.getDescription());
							typeFields.setOrdinal(contacttype.ordinal());
							fields.add(typeFields);
						}
					} else if (typeCode.toString().equals(
							TypeCode.LANGUAGE_TYPE.toString())) {
						for (LANGUAGE_TYPE contacttype : LANGUAGE_TYPE.values()) {
							TypeFields typeFields = new TypeFields();
							
							typeFields.setChildCode(contacttype.getCode());
							typeFields.setChildDescription(contacttype
									.getDescription());
							typeFields.setOrdinal(contacttype.ordinal());
							fields.add(typeFields);
						}
					}
					
					
					
					

					if (fields != null && fields.size() > 0) {
						parentEnumHierarchy = FreshHelper.populateParentType(
								typeCode.toString(), fields);
						em.persist(parentEnumHierarchy);
					}
				}
			}

			
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
			if(request.getCompanyName() != null && !commonLocalService.checkCompanyExistByName(request.getCompanyName())){
				CheckUserRequest userExistRequest = new CheckUserRequest();
				CheckUserResponse userExistResponse = null;
	
//				if (request.getEmail() != null) {
//					userExistRequest.setUsername(request.getEmail());
//					userExistResponse = securityLocalService
//							.checkUser(userExistRequest);
//				}
				UserInformation userInformation = new UserInformation();
	
				if (request.getEmail() != null && request.getUsername() != null
						&& !commonLocalService.checkEmailExistByName(request.getEmail())
						&& !commonLocalService.checkUsernameExistByName(request.getUsername())) {
	
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
					
					CompanyInformation companyInformation = new CompanyInformation();
					companyInformation.setTradingName(request.getCompanyName());
					LogActivity logActivity = new LogActivity();
					logActivity.setCreatedBy(userInformation);
					logActivity.setCreatedOn(LocalHelper.getCurrentTime());
					userInformation.setLogActivity(logActivity);
					companyInformation.setLogActivity(logActivity);
					if(request.getWebsite() != null){
						ContactReference contactReference = new ContactReference();
						contactReference.setContact(request.getWebsite());
						TypeHierarchy contactResponse = commonLocalService
								.getTypeHierarchyByDescription(CONTACTTYPE.Website
										.getDescription());
						contactReference.setContactType(contactResponse);
						ContactInformation contactInformation2 = new ContactInformation();
						contactInformation2.setContactReferences(new ArrayList<ContactReference>());
						contactInformation2.getContactReferences().add(contactReference);
						companyInformation.setContactInformation(contactInformation2);
					}
					EmployeeCompanyInformation employeeCompanyInformation = new EmployeeCompanyInformation();
					employeeCompanyInformation.setCompanyInformation(companyInformation);
					employeeCompanyInformation.setUserInformation(userInformation);
					logActivity = new LogActivity();
					logActivity.setCreatedBy(userInformation);
					logActivity.setCreatedOn(LocalHelper.getCurrentTime());
					userInformation.setLogActivity(logActivity);
					employeeCompanyInformation.setLogActivity(logActivity);
					TypeHierarchy roleType = commonLocalService
							.getTypeHierarchyByDescription(ROLE_TYPE.Admin
									.getDescription());
					employeeCompanyInformation.setUserRoles(new ArrayList<TypeHierarchy>());
					employeeCompanyInformation.getUserRoles().add(roleType);
					em.persist(employeeCompanyInformation);
					
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
			}else{
				response.setResponse(SERVRESPONSE.CompanyAlreadyExists);
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
				//CheckUserResponse userExistResponse = securityLocalService.checkUser(userExistRequest);
		
				if (request.getUsername() != null 
						&& commonLocalService.checkUsernameExistByName(request.getUsername())) {
					UserInformation userInformation = commonLocalService.getUserByUniqueUsername(request.getUsername());
					//Set the response variables
					response.setEmail(userInformation.getUsername().getContact());
					response.setUserId(FreshHelper.encryptPrimaryKeyBytes(userInformation.getId()));
					response.setUsername(userInformation.getUniqueUsername());
					if(userInformation.getActivationStatus() != null)
						response.setActivationStatus(userInformation.getActivationStatus().getDescription());
					if(userInformation.getContactInformation() != null && userInformation.getContactInformation().getContactReferences() != null)
					for(ContactReference contactReference:userInformation.getContactInformation().getContactReferences()){
						if(contactReference.getContactType().getDescription().equalsIgnoreCase(CONTACTTYPE.Cell.getDescription()))
						response.setCellNo(contactReference.getContact());
					}
					
				
						String queryString = "select distinct(c.id ) from cmsdb.user_info c " +
								" where lower(c.uniqueusername) = ?1 " +
								"and c.password = ?2"; 	
						
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
			    	response.setResponse(SERVRESPONSE.InvalidUsernamePassword);
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
			String queryString = "select distinct(p.id),u.password from " +
					"cmsdb.user_info u,cmsdb.person p,commdb.contact_reference cr " +
					"where u.username_id = cr.id and p.id = u.id and lower(cr.contact) = ?1;";
		
			Query query =  em.createNativeQuery(queryString);
			query.setParameter(1, request.getUsername().toLowerCase());
			List<Object> result = (List<Object>)query.getResultList();
				
			if(result != null && result.size() > 0)
			{
				for(Object o:result)
				{
					Object[] os = (Object[])o;
					Object object1 = os[0];
					Object object2 = os[1];
						
					String password = FreshHelper.decryptBytes(object2.toString());
						
					Long userId = (Long) object1;
						
					//Send Forgot Password Mail
//					ForgotPasswordEmailRequest emailRequest = new ForgotPasswordEmailRequest();
//					emailRequest.setEmailToId(FreshHelper.encryptPrimaryKeyBytes(userId));
//					emailRequest.setName("");
//					emailRequest.setPassword(password);
//					new Email2POPRequestQueue().send2Queue(emailRequest);
						
					response.setResponse(SERVRESPONSE.Successful);
					break;
				}
			}else
			{
				response.setResponse(SERVRESPONSE.UserNotFound);
//				throw new com.pop.local.exception.UserNotFoundException();
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


