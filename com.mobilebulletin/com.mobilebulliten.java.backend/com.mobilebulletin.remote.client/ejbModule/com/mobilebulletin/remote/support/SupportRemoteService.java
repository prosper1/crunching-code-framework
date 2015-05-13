package com.mobilebulletin.remote.support;



import javax.ejb.Remote;




import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.mobilebulletin.request.support.*;
import com.mobilebulletin.response.support.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportRemoteUtil                                                              
 *
 * This class is used for all the Support services for EJB Remote purposes.
 * This is the Service class 
 ***************************************************************************************************/



@WebService(portName="SupportServicePortType", targetNamespace="mobilebulletin")
@HandlerChain(file = "../../../../com/mobilebulletin/secure/webservices/security_handler.xml")
@Remote
public interface SupportRemoteService
{
	


          public AddGuestSupportQueryReply addGuestSupportQuery(AddGuestSupportQueryRequest request) throws Exception;

          public AddUserSupportQueryReply addUserSupportQuery(AddUserSupportQueryRequest request) throws Exception;

          public UpdateSupportQueryReply updateSupportQuery(UpdateSupportQueryRequest request) throws Exception;

          public GetSupportTicketByIdReply getSupportTicketById(GetSupportTicketByIdRequest request) throws Exception;

          public GetSupportStartUpReply getSupportStartUp(GetSupportStartUpRequest request) throws Exception;

          public GetSupportTicketsByStatusReply getSupportTicketsByStatus(GetSupportTicketsByStatusRequest request) throws Exception;
}	  


