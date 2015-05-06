package com.mobilebulletin.local.group;



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
import com.mobilebulletin.group.EmployeeGroupInformation;
import com.mobilebulletin.group.GroupInformation;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.utils.FreshHelper;
import com.mobilebulletin.local.utils.LocalHelper;
import com.mobilebulletin.response.util.SERVRESPONSE;




import com.mobilebulletin.request.department.model.DepartmentMemberInfo;
import com.mobilebulletin.request.group.*;
import com.mobilebulletin.request.group.model.GroupMemberInfo;
import com.mobilebulletin.response.department.GetDepartmentsByCompanyIdResponse;
import com.mobilebulletin.response.department.model.DepartmentInfo;
import com.mobilebulletin.response.employee.model.EmployeeInfo;
import com.mobilebulletin.response.group.*;
import com.mobilebulletin.response.group.model.GroupInfo;
import com.mobilebulletin.response.group.model.LightGroupInfo;




/***************************************************************************************************
 *                                                                                                  
 * @author GroupLocalUtil                                                              
 *
 * This class is used for all the Group beans for EJB Local purposes.
 * This is the Bean class 
 ***************************************************************************************************/




@Stateless
public class GroupLocalBean implements GroupLocalService
{
	private static final Logger log = Logger.getLogger(GroupLocalBean.class.getName());
	
	@PersistenceContext(unitName = "com.mobilebulletin.model")
	private EntityManager em;

	@EJB
	private CommonLocalService commonLocalService;


    public AddGroupResponse addGroup(AddGroupRequest request) throws Exception{
	      		AddGroupResponse response = new AddGroupResponse();
		
		try
		{
			Person currentUser = commonLocalService.getPersonById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestUserId()));
    		
			CompanyInformation companyInformation = commonLocalService.getCompanyById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
			
			if(currentUser != null && companyInformation != null){
				
				GroupInformation groupInformation = new GroupInformation();
				groupInformation.setCompanyInformation(companyInformation);
				groupInformation.setName(request.getName());
				groupInformation.setDescription(request.getDescription());
				LogActivity logActivity = LocalHelper.getLogActivity(currentUser, null);
				groupInformation.setLogActivity(logActivity);
				em.persist(groupInformation);
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

    public UpdateGroupMembersResponse updateGroupMembers(UpdateGroupMembersRequest request) throws Exception{
	      		UpdateGroupMembersResponse response = new UpdateGroupMembersResponse();
		
		try
		{
			Person currentUser = commonLocalService.getPersonById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestUserId()));
    		
			CompanyInformation companyInformation = commonLocalService.getCompanyById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
			
			GroupInformation groupInformation = commonLocalService.getGroupInformationById(FreshHelper.decryptPrimaryKeyBytes(request.getGroupId()));
			
			if(currentUser != null && companyInformation != null && groupInformation != null){
				
			
				for(GroupMemberInfo groupMemberInfo:request.getGroupMemberList()){
					if(groupMemberInfo.getMemberId() != null){
						UserInformation userInformation = commonLocalService.getUserById(FreshHelper.decryptPrimaryKeyBytes(groupMemberInfo.getMemberId()));
						if(userInformation != null){
							EmployeeGroupInformation employeeGroupInfo;
							long id = commonLocalService.checkUserExistInDepartmentInformation(userInformation.getId(), groupInformation.getId());
							if(id <= 0){
								employeeGroupInfo = new EmployeeGroupInformation();
							}else{
								employeeGroupInfo = commonLocalService.getEmployeeGroupInfoById(id);
							}
							employeeGroupInfo.setGroupInformation(groupInformation);
							employeeGroupInfo.setUserInformation(userInformation);
							LogActivity logActivity = LocalHelper.getLogActivity(currentUser, null);
							employeeGroupInfo.setLogActivity(logActivity);
							if(groupMemberInfo.getMemberRole() != null){
								TypeHierarchy typeHierarchy = commonLocalService.getTypeHierarchyByDescription(groupMemberInfo.getMemberRole());
								employeeGroupInfo.setGroupRole(typeHierarchy);
							}
							if(id <= 0)
								em.persist(employeeGroupInfo);
							else
								em.merge(employeeGroupInfo);
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

    public UpdateGroupInfoResponse updateGroupInfo(UpdateGroupInfoRequest request) throws Exception{
	      		UpdateGroupInfoResponse response = new UpdateGroupInfoResponse();
		
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

    public GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws Exception{
	      		GetGroupByIdResponse response = new GetGroupByIdResponse();
		
		try
		{
			GroupInformation groupInformation = 
					commonLocalService.getGroupInformationById(FreshHelper.decryptPrimaryKeyBytes(request.getGroupId()));
			GroupInfo groupInfo = new GroupInfo();
			groupInfo.setDescription(groupInformation.getDescription());
			groupInfo.setId(FreshHelper.encryptPrimaryKeyBytes(groupInformation.getId()));
			groupInfo.setName(groupInformation.getName());
			groupInfo.setEmployeeInfoList(new ArrayList<EmployeeInfo>());
			List<EmployeeGroupInformation> groupInformations = commonLocalService.getGroupMembers(groupInformation.getId());
			for(EmployeeGroupInformation employeeGroupInfo:groupInformations){
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
					if(employeeGroupInfo.getGroupRole() != null)
						employeeInfo.setRole(employeeGroupInfo.getGroupRole().getDescription());
					groupInfo.getEmployeeInfoList().add(employeeInfo);
				}
				
				
			}
			response.setGroupInfo(groupInfo);
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

    public ImportGroupFromExcelResponse importGroupFromExcel(ImportGroupFromExcelRequest request) throws Exception{
	      		ImportGroupFromExcelResponse response = new ImportGroupFromExcelResponse();
		
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
	public GetGroupsByCompanyIdResponse getGroupsByCompanyId(
			GetGroupsByCompanyIdRequest request) throws Exception {
		GetGroupsByCompanyIdResponse response = new GetGroupsByCompanyIdResponse();
		
		try
		{
			String queryString = "SELECT x FROM GroupInformation x where x.companyInformation.id = :companyIdParam ";    	
			Query query =  em.createQuery(queryString);
			query.setParameter("companyIdParam", FreshHelper.decryptPrimaryKeyBytes(request.getRequestCompanyId()));
			List<Object> objList = (List<Object>)query.getResultList();
			response.setGroupInfoList(new ArrayList<LightGroupInfo>());
			if(objList.size() > 0)
			{
				for(Object o : objList)
				{
					GroupInformation groupInformation = (GroupInformation)o;
					LightGroupInfo groupInfo = new LightGroupInfo();
					groupInfo.setId(FreshHelper.encryptPrimaryKeyBytes(groupInformation.getId()));
					groupInfo.setName(groupInformation.getName());
					groupInfo.setNumberOfMembers(commonLocalService.getGroupNoOfMembers(groupInformation.getId()));
					groupInfo.setTimeAgo(LocalHelper.getTimeSpanFromDate(groupInformation.getLogActivity().getCreatedOn()));
					response.getGroupInfoList().add(groupInfo);
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


