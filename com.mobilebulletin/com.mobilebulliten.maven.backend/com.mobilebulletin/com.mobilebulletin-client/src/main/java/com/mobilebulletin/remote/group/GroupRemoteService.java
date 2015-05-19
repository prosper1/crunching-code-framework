package com.mobilebulletin.remote.group;



import javax.ejb.Remote;




import javax.jws.HandlerChain;
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



@WebService(portName="GroupServicePortType", targetNamespace="mobilebulletin")
@HandlerChain(file = "../../../../com/mobilebulletin/secure/webservices/security_handler.xml")
@Remote
public interface GroupRemoteService
{
	


          public AddGroupReply addGroup(AddGroupRequest request) throws Exception;

          public UpdateGroupMembersReply updateGroupMembers(UpdateGroupMembersRequest request) throws Exception;

          public UpdateGroupInfoReply updateGroupInfo(UpdateGroupInfoRequest request) throws Exception;

          public GetGroupByIdReply getGroupById(GetGroupByIdRequest request) throws Exception;

          public ImportGroupFromExcelReply importGroupFromExcel(ImportGroupFromExcelRequest request) throws Exception;
          
          public GetGroupsByCompanyIdReply getGroupsByCompanyId(GetGroupsByCompanyIdRequest request) throws Exception;
}	  


