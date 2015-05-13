package com.mobilebulletin.local.support;



import javax.ejb.Local;




import com.mobilebulletin.request.support.*;
import com.mobilebulletin.response.support.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportLocalUtil                                                              
 *
 * This class is used for all the Support services for EJB Local purposes.
 * This is the Service class 
 ***************************************************************************************************/




@Local
public interface SupportLocalService
{
	


          public AddGuestSupportQueryReply addGuestSupportQuery(AddGuestSupportQueryRequest request) throws Exception;

          public AddUserSupportQueryReply addUserSupportQuery(AddUserSupportQueryRequest request) throws Exception;

          public UpdateSupportQueryReply updateSupportQuery(UpdateSupportQueryRequest request) throws Exception;

          public GetSupportTicketByIdReply getSupportTicketById(GetSupportTicketByIdRequest request) throws Exception;

          public GetSupportStartUpReply getSupportStartUp(GetSupportStartUpRequest request) throws Exception;

          public GetSupportTicketsByStatusReply getSupportTicketsByStatus(GetSupportTicketsByStatusRequest request) throws Exception;
}	  


