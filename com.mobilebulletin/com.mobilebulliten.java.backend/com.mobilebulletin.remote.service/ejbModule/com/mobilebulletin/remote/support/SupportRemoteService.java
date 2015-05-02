package com.mobilebulletin.remote.support;



import javax.ejb.Remote;




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



@WebService
@SOAPBinding(style = Style.RPC)
@Remote
public interface SupportRemoteService
{
	


          public AddGuestSupportQueryResponse addGuestSupportQuery(AddGuestSupportQueryRequest request) throws Exception;

          public AddUserSupportQueryResponse addUserSupportQuery(AddUserSupportQueryRequest request) throws Exception;

          public UpdateSupportQueryResponse updateSupportQuery(UpdateSupportQueryRequest request) throws Exception;

          public GetSupportTicketByIdResponse getSupportTicketById(GetSupportTicketByIdRequest request) throws Exception;

          public GetSupportStartUpResponse getSupportStartUp(GetSupportStartUpRequest request) throws Exception;

          public GetSupportTicketsByStatusResponse getSupportTicketsByStatus(GetSupportTicketsByStatusRequest request) throws Exception;
}	  


