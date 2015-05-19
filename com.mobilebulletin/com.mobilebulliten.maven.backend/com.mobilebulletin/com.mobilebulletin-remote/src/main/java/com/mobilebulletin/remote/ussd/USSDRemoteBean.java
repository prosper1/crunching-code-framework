package com.mobilebulletin.remote.ussd;



import com.mobilebulletin.jms.ussd.USSDRequestQueue;

import javax.ejb.Stateless;



import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.mobilebulletin.request.ussd.*;
import com.mobilebulletin.response.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDRemoteUtil                                                              
 *
 * This class is used for all the USSD beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/



@WebService(serviceName = "MobileBulletin", portName = "USSDService", targetNamespace = "mobilebulletin")
@Stateless
public class USSDRemoteBean implements USSDRemoteService
{


    public SignUpUSSDReply signUpUSSD(SignUpUSSDRequest request) throws Exception{
	    SignUpUSSDReply response = new SignUpUSSDReply();
		
		try
		{
			response = (SignUpUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public InitialRequestUSSDReply initialRequestUSSD(InitialRequestUSSDRequest request) throws Exception{
	    InitialRequestUSSDReply response = new InitialRequestUSSDReply();
		
		try
		{
			response = (InitialRequestUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SignInUSSDReply signInUSSD(SignInUSSDRequest request) throws Exception{
	    SignInUSSDReply response = new SignInUSSDReply();
		
		try
		{
			response = (SignInUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ForgotPinUSSDReply forgotPinUSSD(ForgotPinUSSDRequest request) throws Exception{
	    ForgotPinUSSDReply response = new ForgotPinUSSDReply();
		
		try
		{
			response = (ForgotPinUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateLangaugeUSSDReply updateLangaugeUSSD(UpdateLangaugeUSSDRequest request) throws Exception{
	    UpdateLangaugeUSSDReply response = new UpdateLangaugeUSSDReply();
		
		try
		{
			response = (UpdateLangaugeUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public StopSMSNotificationUSSDReply stopSMSNotificationUSSD(StopSMSNotificationUSSDRequest request) throws Exception{
	    StopSMSNotificationUSSDReply response = new StopSMSNotificationUSSDReply();
		
		try
		{
			response = (StopSMSNotificationUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SendSMSToDepartmentHeadUSSDReply sendSMSToDepartmentHeadUSSD(SendSMSToDepartmentHeadUSSDRequest request) throws Exception{
	    SendSMSToDepartmentHeadUSSDReply response = new SendSMSToDepartmentHeadUSSDReply();
		
		try
		{
			response = (SendSMSToDepartmentHeadUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SendSMSToGroupHeadUSSDReply sendSMSToGroupHeadUSSD(SendSMSToGroupHeadUSSDRequest request) throws Exception{
	    SendSMSToGroupHeadUSSDReply response = new SendSMSToGroupHeadUSSDReply();
		
		try
		{
			response = (SendSMSToGroupHeadUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SupportQueryUSSDReply supportQueryUSSD(SupportQueryUSSDRequest request) throws Exception{
	    SupportQueryUSSDReply response = new SupportQueryUSSDReply();
		
		try
		{
			response = (SupportQueryUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetEmployeeInfoUSSDReply getEmployeeInfoUSSD(GetEmployeeInfoUSSDRequest request) throws Exception{
	    GetEmployeeInfoUSSDReply response = new GetEmployeeInfoUSSDReply();
		
		try
		{
			response = (GetEmployeeInfoUSSDReply) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


