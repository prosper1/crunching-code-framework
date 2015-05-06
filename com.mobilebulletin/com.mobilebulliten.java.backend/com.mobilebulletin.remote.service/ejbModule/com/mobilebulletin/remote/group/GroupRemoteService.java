package com.mobilebulletin.remote.group;



import javax.ejb.Remote;




import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.mobilebulletin.request.group.*;
import com.mobilebulletin.response.group.*;




/***************************************************************************************************
 *                                                                                                  
 * @author GroupRemoteUtil                                                              
 *
 * This class is used for all the Group services for EJB Remote purposes.
 * This is the Service class 
 ***************************************************************************************************/



@WebService
@SOAPBinding(style = Style.RPC)
@Remote
public interface GroupRemoteService
{
	


          public AddGroupResponse addGroup(AddGroupRequest request) throws Exception;

          public UpdateGroupMembersResponse updateGroupMembers(UpdateGroupMembersRequest request) throws Exception;

          public UpdateGroupInfoResponse updateGroupInfo(UpdateGroupInfoRequest request) throws Exception;

          public GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws Exception;

          public ImportGroupFromExcelResponse importGroupFromExcel(ImportGroupFromExcelRequest request) throws Exception;
}	  


