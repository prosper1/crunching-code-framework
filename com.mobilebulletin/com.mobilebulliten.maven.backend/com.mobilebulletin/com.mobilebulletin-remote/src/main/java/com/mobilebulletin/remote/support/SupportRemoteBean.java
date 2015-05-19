package com.mobilebulletin.remote.support;



import javax.ejb.Stateless;
import javax.jws.WebService;

import com.mobilebulletin.jms.support.SupportRequestQueue;
import com.mobilebulletin.request.support.AddGuestSupportQueryRequest;
import com.mobilebulletin.request.support.AddUserSupportQueryRequest;
import com.mobilebulletin.request.support.GetSupportStartUpRequest;
import com.mobilebulletin.request.support.GetSupportTicketByIdRequest;
import com.mobilebulletin.request.support.GetSupportTicketsByStatusRequest;
import com.mobilebulletin.request.support.UpdateSupportQueryRequest;
import com.mobilebulletin.response.support.AddGuestSupportQueryReply;
import com.mobilebulletin.response.support.AddUserSupportQueryReply;
import com.mobilebulletin.response.support.GetSupportStartUpReply;
import com.mobilebulletin.response.support.GetSupportTicketByIdReply;
import com.mobilebulletin.response.support.GetSupportTicketsByStatusReply;
import com.mobilebulletin.response.support.UpdateSupportQueryReply;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportRemoteUtil                                                              
 *
 * This class is used for all the Support beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/



@WebService(serviceName = "MobileBulletin", portName = "SupportService", targetNamespace = "mobilebulletin")
@Stateless
public class SupportRemoteBean implements SupportRemoteService
{


    public AddGuestSupportQueryReply addGuestSupportQuery(AddGuestSupportQueryRequest request) throws Exception{
	    AddGuestSupportQueryReply response = new AddGuestSupportQueryReply();
		
		try
		{
			response = (AddGuestSupportQueryReply) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public AddUserSupportQueryReply addUserSupportQuery(AddUserSupportQueryRequest request) throws Exception{
	    AddUserSupportQueryReply response = new AddUserSupportQueryReply();
		
		try
		{
			response = (AddUserSupportQueryReply) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateSupportQueryReply updateSupportQuery(UpdateSupportQueryRequest request) throws Exception{
	    UpdateSupportQueryReply response = new UpdateSupportQueryReply();
		
		try
		{
			response = (UpdateSupportQueryReply) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetSupportTicketByIdReply getSupportTicketById(GetSupportTicketByIdRequest request) throws Exception{
	    GetSupportTicketByIdReply response = new GetSupportTicketByIdReply();
		
		try
		{
			response = (GetSupportTicketByIdReply) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetSupportStartUpReply getSupportStartUp(GetSupportStartUpRequest request) throws Exception{
	    GetSupportStartUpReply response = new GetSupportStartUpReply();
		
		try
		{
			response = (GetSupportStartUpReply) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetSupportTicketsByStatusReply getSupportTicketsByStatus(GetSupportTicketsByStatusRequest request) throws Exception{
	    GetSupportTicketsByStatusReply response = new GetSupportTicketsByStatusReply();
		
		try
		{
			response = (GetSupportTicketsByStatusReply) new SupportRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


