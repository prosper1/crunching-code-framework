package com.mobilebulletin.remote.group;



import com.mobilebulletin.jms.group.GroupRequestQueue;

import javax.ejb.Stateless;



import javax.jws.WebService;

import com.mobilebulletin.request.group.*;
import com.mobilebulletin.response.group.*;




/***************************************************************************************************
 *                                                                                                  
 * @author GroupRemoteUtil                                                              
 *
 * This class is used for all the Group beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/



@WebService(endpointInterface = "com.mobilebulletin.remote.group.GroupRemoteService")
@Stateless
public class GroupRemoteBean implements GroupRemoteService
{


    public AddGroupResponse addGroup(AddGroupRequest request) throws Exception{
	    AddGroupResponse response = new AddGroupResponse();
		
		try
		{
			response = (AddGroupResponse) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateGroupMembersResponse updateGroupMembers(UpdateGroupMembersRequest request) throws Exception{
	    UpdateGroupMembersResponse response = new UpdateGroupMembersResponse();
		
		try
		{
			response = (UpdateGroupMembersResponse) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateGroupInfoResponse updateGroupInfo(UpdateGroupInfoRequest request) throws Exception{
	    UpdateGroupInfoResponse response = new UpdateGroupInfoResponse();
		
		try
		{
			response = (UpdateGroupInfoResponse) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws Exception{
	    GetGroupByIdResponse response = new GetGroupByIdResponse();
		
		try
		{
			response = (GetGroupByIdResponse) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportGroupFromExcelResponse importGroupFromExcel(ImportGroupFromExcelRequest request) throws Exception{
	    ImportGroupFromExcelResponse response = new ImportGroupFromExcelResponse();
		
		try
		{
			response = (ImportGroupFromExcelResponse) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }

	@Override
	public GetGroupsByCompanyIdResponse getGroupsByCompanyId(
			GetGroupsByCompanyIdRequest request) throws Exception {
		GetGroupsByCompanyIdResponse response = new GetGroupsByCompanyIdResponse();
		
		try
		{
			response = (GetGroupsByCompanyIdResponse) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}	  
}	  


