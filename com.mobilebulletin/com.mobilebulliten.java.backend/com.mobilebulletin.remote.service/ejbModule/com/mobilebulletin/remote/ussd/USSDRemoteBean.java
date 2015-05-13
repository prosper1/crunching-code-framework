package com.mobilebulletin.remote.ussd;



import com.mobilebulletin.jms.ussd.USSDRequestQueue;
import javax.ejb.Stateless;



import com.mobilebulletin.request.ussd.*;
import com.mobilebulletin.response.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDRemoteUtil                                                              
 *
 * This class is used for all the USSD beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/




@Stateless
public class USSDRemoteBean implements USSDRemoteService
{


    public SignUpUSSDResponse signUpUSSD(SignUpUSSDRequest request) throws Exception{
	    SignUpUSSDResponse response = new SignUpUSSDResponse();
		
		try
		{
			response = (SignUpUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public InitialRequestUSSDResponse initialRequestUSSD(InitialRequestUSSDRequest request) throws Exception{
	    InitialRequestUSSDResponse response = new InitialRequestUSSDResponse();
		
		try
		{
			response = (InitialRequestUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SignInUSSDResponse signInUSSD(SignInUSSDRequest request) throws Exception{
	    SignInUSSDResponse response = new SignInUSSDResponse();
		
		try
		{
			response = (SignInUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ForgotPinUSSDResponse forgotPinUSSD(ForgotPinUSSDRequest request) throws Exception{
	    ForgotPinUSSDResponse response = new ForgotPinUSSDResponse();
		
		try
		{
			response = (ForgotPinUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateLangaugeUSSDResponse updateLangaugeUSSD(UpdateLangaugeUSSDRequest request) throws Exception{
	    UpdateLangaugeUSSDResponse response = new UpdateLangaugeUSSDResponse();
		
		try
		{
			response = (UpdateLangaugeUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public StopSMSNotificationUSSDResponse stopSMSNotificationUSSD(StopSMSNotificationUSSDRequest request) throws Exception{
	    StopSMSNotificationUSSDResponse response = new StopSMSNotificationUSSDResponse();
		
		try
		{
			response = (StopSMSNotificationUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SendSMSToDepartmentHeadUSSDResponse sendSMSToDepartmentHeadUSSD(SendSMSToDepartmentHeadUSSDRequest request) throws Exception{
	    SendSMSToDepartmentHeadUSSDResponse response = new SendSMSToDepartmentHeadUSSDResponse();
		
		try
		{
			response = (SendSMSToDepartmentHeadUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SendSMSToGroupHeadUSSDResponse sendSMSToGroupHeadUSSD(SendSMSToGroupHeadUSSDRequest request) throws Exception{
	    SendSMSToGroupHeadUSSDResponse response = new SendSMSToGroupHeadUSSDResponse();
		
		try
		{
			response = (SendSMSToGroupHeadUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public SupportQueryUSSDResponse supportQueryUSSD(SupportQueryUSSDRequest request) throws Exception{
	    SupportQueryUSSDResponse response = new SupportQueryUSSDResponse();
		
		try
		{
			response = (SupportQueryUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetEmployeeInfoUSSDResponse getEmployeeInfoUSSD(GetEmployeeInfoUSSDRequest request) throws Exception{
	    GetEmployeeInfoUSSDResponse response = new GetEmployeeInfoUSSDResponse();
		
		try
		{
			response = (GetEmployeeInfoUSSDResponse) new USSDRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


