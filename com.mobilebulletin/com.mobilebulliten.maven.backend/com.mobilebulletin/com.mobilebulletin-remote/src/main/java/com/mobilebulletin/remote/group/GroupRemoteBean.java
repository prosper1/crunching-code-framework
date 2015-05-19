package com.mobilebulletin.remote.group;



import com.mobilebulletin.jms.group.GroupRequestQueue;

import javax.ejb.Stateless;



import javax.jws.HandlerChain;
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



@WebService(serviceName = "MobileBulletin", portName = "GroupService", targetNamespace = "mobilebulletin")
@Stateless
public class GroupRemoteBean implements GroupRemoteService
{


    public AddGroupReply addGroup(AddGroupRequest request) throws Exception{
	    AddGroupReply response = new AddGroupReply();
		
		try
		{
			response = (AddGroupReply) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateGroupMembersReply updateGroupMembers(UpdateGroupMembersRequest request) throws Exception{
	    UpdateGroupMembersReply response = new UpdateGroupMembersReply();
		
		try
		{
			response = (UpdateGroupMembersReply) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateGroupInfoReply updateGroupInfo(UpdateGroupInfoRequest request) throws Exception{
	    UpdateGroupInfoReply response = new UpdateGroupInfoReply();
		
		try
		{
			response = (UpdateGroupInfoReply) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetGroupByIdReply getGroupById(GetGroupByIdRequest request) throws Exception{
	    GetGroupByIdReply response = new GetGroupByIdReply();
		
		try
		{
			response = (GetGroupByIdReply) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportGroupFromExcelReply importGroupFromExcel(ImportGroupFromExcelRequest request) throws Exception{
	    ImportGroupFromExcelReply response = new ImportGroupFromExcelReply();
		
		try
		{
			response = (ImportGroupFromExcelReply) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }

	public GetGroupsByCompanyIdReply getGroupsByCompanyId(
			GetGroupsByCompanyIdRequest request) throws Exception {
		GetGroupsByCompanyIdReply response = new GetGroupsByCompanyIdReply();
		
		try
		{
			response = (GetGroupsByCompanyIdReply) new GroupRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}	  
}	  


