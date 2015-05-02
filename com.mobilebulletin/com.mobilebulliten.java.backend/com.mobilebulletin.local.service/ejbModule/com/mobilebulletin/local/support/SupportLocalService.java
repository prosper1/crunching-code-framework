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
	


          public AddGuestSupportQueryResponse addGuestSupportQuery(AddGuestSupportQueryRequest request) throws Exception;

          public AddUserSupportQueryResponse addUserSupportQuery(AddUserSupportQueryRequest request) throws Exception;

          public UpdateSupportQueryResponse updateSupportQuery(UpdateSupportQueryRequest request) throws Exception;

          public GetSupportTicketByIdResponse getSupportTicketById(GetSupportTicketByIdRequest request) throws Exception;

          public GetSupportStartUpResponse getSupportStartUp(GetSupportStartUpRequest request) throws Exception;

          public GetSupportTicketsByStatusResponse getSupportTicketsByStatus(GetSupportTicketsByStatusRequest request) throws Exception;
}	  


