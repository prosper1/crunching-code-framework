package com.mobilebulletin.local.group;



import javax.ejb.Local;






import com.mobilebulletin.request.group.*;
import com.mobilebulletin.response.group.*;




/***************************************************************************************************
 *                                                                                                  
 * @author GroupLocalUtil                                                              
 *
 * This class is used for all the Group services for EJB Local purposes.
 * This is the Service class 
 ***************************************************************************************************/




@Local
public interface GroupLocalService
{
	


          public AddGroupResponse addGroup(AddGroupRequest request) throws Exception;

          public UpdateGroupMembersResponse updateGroupMembers(UpdateGroupMembersRequest request) throws Exception;

          public UpdateGroupInfoResponse updateGroupInfo(UpdateGroupInfoRequest request) throws Exception;

          public GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws Exception;

          public ImportGroupFromExcelResponse importGroupFromExcel(ImportGroupFromExcelRequest request) throws Exception;
          
          public GetGroupsByCompanyIdResponse getGroupsByCompanyId(GetGroupsByCompanyIdRequest request) throws Exception;
}	  


