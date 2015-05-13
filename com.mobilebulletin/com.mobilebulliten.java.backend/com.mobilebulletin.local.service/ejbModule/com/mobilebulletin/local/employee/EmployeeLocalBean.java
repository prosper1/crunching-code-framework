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
import com.mobilebulletin.group.EmployeeGroupInformation;
import com.mobilebulletin.group.GroupInformation;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.utils.FreshHelper;
import com.mobilebulletin.local.utils.LocalHelper;
import com.mobilebulletin.response.security.CheckUserReply;
import com.mobilebulletin.response.util.SERVRESPONSE;




import com.mobilebulletin.request.employee.*;
import com.mobilebulletin.request.security.CheckUserRequest;
import com.mobilebulletin.response.department.model.DepartmentInfo;
import com.mobilebulletin.response.employee.*;
import com.mobilebulletin.response.employee.model.EmployeeInfo;




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

    public AddEmployeeReply addEmployee(AddEmployeeRequest request) throws Exception{
	      		AddEmployeeReply response = new AddEmployeeReply();
		
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

    public RemoveEmployeeReply removeEmployee(RemoveEmployeeRequest request) throws Exception{
	      		RemoveEmployeeReply response = new RemoveEmployeeReply();
		
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

    public UpdateEmployeeReply updateEmployee(UpdateEmployeeRequest request) throws Exception{
	      		UpdateEmployeeReply response = new UpdateEmployeeReply();
		
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

    public ImportEmployeesReply importEmployees(ImportEmployeesRequest request) throws Exception{
	      		ImportEmployeesReply response = new ImportEmployeesReply();
		
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

    public ImportEmployeesFromDatabaseReply importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception{
	      		ImportEmployeesFromDatabaseReply response = new ImportEmployeesFromDatabaseReply();
		
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

    public GetEmployeeByIdReply getEmployeeById(GetEmployeeByIdRequest request) throws Exception{
	      		GetEmployeeByIdReply response = new GetEmployeeByIdReply();
		
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

    public GetEmployeesFromCompanyReply getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception{
	      		GetEmployeesFromCompanyReply response = new GetEmployeesFromCompanyReply();
		
		try
		{
			
			response.setEmployeeInfoList(new ArrayList<EmployeeInfo>());
			List<EmployeeCompanyInformation> employeeCompanyInformations = commonLocalService.getCompanyMembers(FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
			for(EmployeeCompanyInformation employeeGroupInfo:employeeCompanyInformations){
				EmployeeInfo employeeInfo =new EmployeeInfo();
				if(employeeGroupInfo.getUserInformation() !=null){
					UserInformation userInformation = employeeGroupInfo.getUserInformation();
					if(userInformation.getContactInformation() != null 
							&& userInformation.getContactInformation().getContactReferences() != null){
						for(ContactReference contactReference:userInformation.getContactInformation().getContactReferences()){
							if(contactReference.getContactType() != null)
								if(contactReference.getContactType().getDescription().equalsIgnoreCase(CONTACTTYPE.Cell.getDescription()))
									employeeInfo.setCellNo(contactReference.getContact());
								else if(contactReference.getContactType().getDescription().equalsIgnoreCase(CONTACTTYPE.Email.getDescription()))
									employeeInfo.setEmail(contactReference.getContact());
						}
					}
					employeeInfo.setEmployeeNo(userInformation.getEmployeeNo());
					employeeInfo.setFirstname(userInformation.getFirstname());
					employeeInfo.setId(FreshHelper.encryptPrimaryKeyBytes(userInformation.getId()));
					employeeInfo.setInitials(userInformation.getInitials());
					if(userInformation.getLangaugeType() != null)
						employeeInfo.setLangauge(userInformation.getLangaugeType().getDescription());
					employeeInfo.setLastname(userInformation.getLastname());
					if(employeeGroupInfo.getUserRoles() != null)
						employeeInfo.setRole(employeeGroupInfo.getUserRoles().get(0).getDescription());
					response.getEmployeeInfoList().add(employeeInfo);
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
}	  


