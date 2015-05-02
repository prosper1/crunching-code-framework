package com.mobilebulletin.remote.support;



import com.mobilebulletin.jms.support.SupportRequestQueue;

import javax.ejb.Stateless;



import javax.jws.WebService;

import com.mobilebulletin.request.support.*;
import com.mobilebulletin.response.support.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportRemoteUtil                                                              
 *
 * This class is used for all the Support beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/



@WebService(endpointInterface = "com.mobilebulletin.remote.support.SupportRemoteService")
@Stateless
public class SupportRemoteBean implements SupportRemoteService
{


    public AddGuestSupportQueryResponse addGuestSupportQuery(AddGuestSupportQueryRequest request) throws Exception{
	    AddGuestSupportQueryResponse response = new AddGuestSupportQueryResponse();
		
		try
		{
			response = (AddGuestSupportQueryResponse) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public AddUserSupportQueryResponse addUserSupportQuery(AddUserSupportQueryRequest request) throws Exception{
	    AddUserSupportQueryResponse response = new AddUserSupportQueryResponse();
		
		try
		{
			response = (AddUserSupportQueryResponse) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateSupportQueryResponse updateSupportQuery(UpdateSupportQueryRequest request) throws Exception{
	    UpdateSupportQueryResponse response = new UpdateSupportQueryResponse();
		
		try
		{
			response = (UpdateSupportQueryResponse) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetSupportTicketByIdResponse getSupportTicketById(GetSupportTicketByIdRequest request) throws Exception{
	    GetSupportTicketByIdResponse response = new GetSupportTicketByIdResponse();
		
		try
		{
			response = (GetSupportTicketByIdResponse) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetSupportStartUpResponse getSupportStartUp(GetSupportStartUpRequest request) throws Exception{
	    GetSupportStartUpResponse response = new GetSupportStartUpResponse();
		
		try
		{
			response = (GetSupportStartUpResponse) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetSupportTicketsByStatusResponse getSupportTicketsByStatus(GetSupportTicketsByStatusRequest request) throws Exception{
	    GetSupportTicketsByStatusResponse response = new GetSupportTicketsByStatusResponse();
		
		try
		{
			response = (GetSupportTicketsByStatusResponse) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


