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
	


          public AddGroupReply addGroup(AddGroupRequest request) throws Exception;

          public UpdateGroupMembersReply updateGroupMembers(UpdateGroupMembersRequest request) throws Exception;

          public UpdateGroupInfoReply updateGroupInfo(UpdateGroupInfoRequest request) throws Exception;

          public GetGroupByIdReply getGroupById(GetGroupByIdRequest request) throws Exception;

          public ImportGroupFromExcelReply importGroupFromExcel(ImportGroupFromExcelRequest request) throws Exception;
          
          public GetGroupsByCompanyIdReply getGroupsByCompanyId(GetGroupsByCompanyIdRequest request) throws Exception;
}	  


