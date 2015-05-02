package com.mobilebulletin.local.employee;



import java.text.Format;
import java.text.SimpleDateFormat;
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
import com.common.type.TypeHierarchy;
import com.mobilebulletin.company.CompanyInformation;
import com.mobilebulletin.company.EmployeeCompanyInformation;
import com.mobilebulletin.enumerator.CONTACTTYPE;
import com.mobilebulletin.enumerator.LANGUAGE_TYPE;
import com.mobilebulletin.enumerator.ROLE_TYPE;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.utils.FreshHelper;
import com.mobilebulletin.local.utils.LocalHelper;
import com.mobilebulletin.response.security.CheckUserResponse;
import com.mobilebulletin.response.util.SERVRESPONSE;




import com.mobilebulletin.request.employee.*;
import com.mobilebulletin.request.security.CheckUserRequest;
import com.mobilebulletin.response.employee.*;




/***************************************************************************************************
 *                                                                                                  
 * @author EmployeeLocalUtil                                                              
 *
 * This class is used for all the Employee beans for EJB Local purposes.
 * This is the Bean class 
 ***************************************************************************************************/




@Stateless
public class EmployeeLocalBean implements EmployeeLocalService
{
	private static final Logger log = Logger.getLogger(EmployeeLocalBean.class.getName());
	
	@PersistenceContext(unitName = "com.mobilebulletin.model")
	private EntityManager em;

	@EJB
	private CommonLocalService commonLocalService;

    public AddEmployeeResponse addEmployee(AddEmployeeRequest request) throws Exception{
	      		AddEmployeeResponse response = new AddEmployeeResponse();
		
		try
		{
			UserInformation currentUser = 
					commonLocalService.getUserById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestUserId()));
			if(request.getRequestCompanyId() != null 
					&& commonLocalService.getCompanyById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId())) != null){
				
				UserInformation userInformation = new UserInformation();
	
				if (request.getEmail() != null && request.getCellNo() != null
						&& !commonLocalService.checkEmailExistByName(request.getEmail())
						&& !commonLocalService.checkCellNoExistByCellNo(request.getCellNo())) {
	
					
				
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
					userInformation.setEmployeeNo(request.getEmployeeNo());
					userInformation.setFirstname(request.getFirstname());
					userInformation.setInitials(request.getInitials());
					userInformation.setLastname(request.getLastname());
					TypeHierarchy langaugeType = commonLocalService
							.getTypeHierarchyByDescription(request.getLangauge());
					userInformation.setLangaugeType(langaugeType);
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
					activity.setCreatedBy(currentUser);
					activity.setCreatedOn(LocalHelper.getCurrentTime());
					userInformation.setLogActivity(activity);
	
					userInformation.setEmailOptOut(false);
					
					String activationCode = LocalHelper.getActivationCode();
					userInformation.setActivationCode(activationCode);
					
					CompanyInformation companyInformation = commonLocalService.getCompanyById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
					
					
					
					EmployeeCompanyInformation employeeCompanyInformation = new EmployeeCompanyInformation();
					employeeCompanyInformation.setCompanyInformation(companyInformation);
					employeeCompanyInformation.setUserInformation(userInformation);
					LogActivity logActivity = LocalHelper.getLogActivity(currentUser, employeeCompanyInformation.getLogActivity());
					
					employeeCompanyInformation.setLogActivity(logActivity);
					TypeHierarchy roleType = commonLocalService
							.getTypeHierarchyByDescription(ROLE_TYPE.Employee
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
				response.setResponse(SERVRESPONSE.CompanyNotFound);
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

    public RemoveEmployeeResponse removeEmployee(RemoveEmployeeRequest request) throws Exception{
	      		RemoveEmployeeResponse response = new RemoveEmployeeResponse();
		
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

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request) throws Exception{
	      		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		
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

    public ImportEmployeesResponse importEmployees(ImportEmployeesRequest request) throws Exception{
	      		ImportEmployeesResponse response = new ImportEmployeesResponse();
		
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

    public ImportEmployeesFromDatabaseResponse importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception{
	      		ImportEmployeesFromDatabaseResponse response = new ImportEmployeesFromDatabaseResponse();
		
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

    public GetEmployeeByIdResponse getEmployeeById(GetEmployeeByIdRequest request) throws Exception{
	      		GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
		
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

    public GetEmployeesFromCompanyResponse getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception{
	      		GetEmployeesFromCompanyResponse response = new GetEmployeesFromCompanyResponse();
		
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


