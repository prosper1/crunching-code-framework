package com.mobilebulletin.local.department;



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

import com.common.cms.Person;
import com.common.cms.UserInformation;
import com.common.communication.ContactReference;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;
import com.mobilebulletin.company.CompanyInformation;
import com.mobilebulletin.department.DepartmentInformation;
import com.mobilebulletin.department.EmployeeDepartmentInformation;
import com.mobilebulletin.enumerator.CONTACTTYPE;
import com.mobilebulletin.group.GroupInformation;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.utils.FreshHelper;
import com.mobilebulletin.local.utils.LocalHelper;
import com.mobilebulletin.response.util.SERVRESPONSE;




import com.mobilebulletin.request.department.*;
import com.mobilebulletin.request.department.model.DepartmentMemberInfo;
import com.mobilebulletin.response.department.*;
import com.mobilebulletin.response.department.model.DepartmentInfo;
import com.mobilebulletin.response.department.model.LightDepartmentInfo;
import com.mobilebulletin.response.employee.model.EmployeeInfo;
import com.mobilebulletin.response.group.model.LightGroupInfo;




/***************************************************************************************************
 *                                                                                                  
 * @author DepartmentLocalUtil                                                              
 *
 * This class is used for all the Department beans for EJB Local purposes.
 * This is the Bean class 
 ***************************************************************************************************/




@Stateless
public class DepartmentLocalBean implements DepartmentLocalService
{
	private static final Logger log = Logger.getLogger(DepartmentLocalBean.class.getName());
	

	@PersistenceContext(unitName = "com.mobilebulletin.model")
	private EntityManager em;

	@EJB
	private CommonLocalService commonLocalService;
	
    public AddDepartmentResponse addDepartment(AddDepartmentRequest request) throws Exception{
	      		AddDepartmentResponse response = new AddDepartmentResponse();
		
		try
		{
			Person currentUser = commonLocalService.getPersonById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestUserId()));
    		
			CompanyInformation companyInformation = commonLocalService.getCompanyById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
			
			if(currentUser != null && companyInformation != null){
				
				DepartmentInformation departmentInformation = new DepartmentInformation();
				departmentInformation.setCompanyInformation(companyInformation);
				departmentInformation.setName(request.getName());
				departmentInformation.setDescription(request.getDescription());
				LogActivity logActivity = LocalHelper.getLogActivity(currentUser, null);
				departmentInformation.setLogActivity(logActivity);
				em.persist(departmentInformation);
				response.setResponse(SERVRESPONSE.Successful);
			}else{
				response.setResponse(SERVRESPONSE.ServerError);
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

    public UpdateDepartmentMembersResponse updateDepartmentMembers(UpdateDepartmentMembersRequest request) throws Exception{
	      		UpdateDepartmentMembersResponse response = new UpdateDepartmentMembersResponse();
		
		try
		{
			Person currentUser = commonLocalService.getPersonById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestUserId()));
    		
			CompanyInformation companyInformation = commonLocalService.getCompanyById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
			
			DepartmentInformation departmentInformation = commonLocalService.getDepartmentInformationById(FreshHelper.decryptPrimaryKeyBytes(request.getDepartmentId()));
			
			if(currentUser != null && companyInformation != null && departmentInformation != null){
				
			
				for(DepartmentMemberInfo departmentMemberInfo:request.getDepartmentMemberList()){
					if(departmentMemberInfo.getMemberId() != null){
						UserInformation userInformation = commonLocalService.getUserById(FreshHelper.decryptPrimaryKeyBytes(departmentMemberInfo.getMemberId()));
						if(userInformation != null){
							EmployeeDepartmentInformation employeeDepartmentInfo;
							long id = commonLocalService.checkUserExistInDepartmentInformation(userInformation.getId(), departmentInformation.getId());
							if(id <= 0){
								employeeDepartmentInfo = new EmployeeDepartmentInformation();
							}else{
								employeeDepartmentInfo = commonLocalService.getEmployeeDepartmentInfoById(id);
							}
							employeeDepartmentInfo.setDepartmentInformation(departmentInformation);
							employeeDepartmentInfo.setUserInformation(userInformation);
							if(departmentMemberInfo.getMemberRole() != null){
								TypeHierarchy typeHierarchy = commonLocalService.getTypeHierarchyByDescription(departmentMemberInfo.getMemberRole());
								employeeDepartmentInfo.setDepartmentRole(typeHierarchy);
							}
							LogActivity logActivity = LocalHelper.getLogActivity(currentUser, employeeDepartmentInfo.getLogActivity());
							employeeDepartmentInfo.setLogActivity(logActivity);
							
							if(id <= 0)
								em.persist(employeeDepartmentInfo);
							else
								em.merge(employeeDepartmentInfo);
						}
					}
		    		
				}
				
				
				response.setResponse(SERVRESPONSE.Successful);
			}else{
				response.setResponse(SERVRESPONSE.ServerError);
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

    public UpdateDepartmentInfoResponse updateDepartmentInfo(UpdateDepartmentInfoRequest request) throws Exception{
	      		UpdateDepartmentInfoResponse response = new UpdateDepartmentInfoResponse();
		
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

    public GetDepartmentByIdResponse getDepartmentById(GetDepartmentByIdRequest request) throws Exception{
	      		GetDepartmentByIdResponse response = new GetDepartmentByIdResponse();
		
		try
		{
			DepartmentInformation departmentInformation = 
					commonLocalService.getDepartmentInformationById(FreshHelper.decryptPrimaryKeyBytes(request.getDepartmentId()));
			DepartmentInfo departmentInfo = new DepartmentInfo();
			departmentInfo.setDescription(departmentInformation.getDescription());
			departmentInfo.setId(FreshHelper.encryptPrimaryKeyBytes(departmentInformation.getId()));
			departmentInfo.setName(departmentInformation.getName());
			departmentInfo.setEmployeeInfoList(new ArrayList<EmployeeInfo>());
			List<EmployeeDepartmentInformation> departmentInformations = commonLocalService.getDepartmentMembers(departmentInformation.getId());
			for(EmployeeDepartmentInformation employeeDepartmentInfo:departmentInformations){
				EmployeeInfo employeeInfo =new EmployeeInfo();
				if(employeeDepartmentInfo.getUserInformation() !=null){
					UserInformation userInformation = employeeDepartmentInfo.getUserInformation();
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
					if(employeeDepartmentInfo.getDepartmentRole() != null)
						employeeInfo.setRole(employeeDepartmentInfo.getDepartmentRole().getDescription());
					departmentInfo.getEmployeeInfoList().add(employeeInfo);
				}
				
			}
			response.setDepartmentInfo(departmentInfo);
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

    public ImportDepartmentFromExcelResponse importDepartmentFromExcel(ImportDepartmentFromExcelRequest request) throws Exception{
	      		ImportDepartmentFromExcelResponse response = new ImportDepartmentFromExcelResponse();
		
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

	@Override
	public GetDepartmentsByCompanyIdResponse getDepartmentsByCompanyId(
			GetDepartmentsByCompanyIdRequest request) throws Exception {
		GetDepartmentsByCompanyIdResponse response = new GetDepartmentsByCompanyIdResponse();
		
		try
		{
			String queryString = "SELECT x FROM DepartmentInformation x where x.companyInformation.id = :companyIdParam ";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("companyIdParam", FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
			List<Object> objList = (List<Object>)query.getResultList();
			response.setDepartmentInfoList(new ArrayList<LightDepartmentInfo>());
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					DepartmentInformation departmentInformation = (DepartmentInformation)o;
					LightDepartmentInfo departmentInfo = new LightDepartmentInfo();
					departmentInfo.setId(FreshHelper.encryptPrimaryKeyBytes(departmentInformation.getId()));
					departmentInfo.setName(departmentInformation.getName());
					departmentInfo.setNumberOfMembers(commonLocalService.getDepartmentNoOfMembers(departmentInformation.getId()));
					departmentInfo.setTimeAgo(LocalHelper.getTimeSpanFromDate(departmentInformation.getLogActivity().getCreatedOn()));
					response.getDepartmentInfoList().add(departmentInfo);
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


