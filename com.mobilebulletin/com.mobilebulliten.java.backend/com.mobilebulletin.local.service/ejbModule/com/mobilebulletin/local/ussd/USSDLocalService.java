package com.mobilebulletin.local.ussd;



import javax.ejb.Local;




import com.mobilebulletin.request.ussd.*;
import com.mobilebulletin.response.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDLocalUtil                                                              
 *
 * This class is used for all the USSD services for EJB Local purposes.
 * This is the Service class 
 ***************************************************************************************************/




@Local
public interface USSDLocalService
{
	


          public SignUpUSSDReply signUpUSSD(SignUpUSSDRequest request) throws Exception;

          public InitialRequestUSSDReply initialRequestUSSD(InitialRequestUSSDRequest request) throws Exception;

          public SignInUSSDReply signInUSSD(SignInUSSDRequest request) throws Exception;

          public ForgotPinUSSDReply forgotPinUSSD(ForgotPinUSSDRequest request) throws Exception;

          public UpdateLangaugeUSSDReply updateLangaugeUSSD(UpdateLangaugeUSSDRequest request) throws Exception;

          public StopSMSNotificationUSSDReply stopSMSNotificationUSSD(StopSMSNotificationUSSDRequest request) throws Exception;

          public SendSMSToDepartmentHeadUSSDReply sendSMSToDepartmentHeadUSSD(SendSMSToDepartmentHeadUSSDRequest request) throws Exception;

          public SendSMSToGroupHeadUSSDReply sendSMSToGroupHeadUSSD(SendSMSToGroupHeadUSSDRequest request) throws Exception;

          public SupportQueryUSSDReply supportQueryUSSD(SupportQueryUSSDRequest request) throws Exception;

          public GetEmployeeInfoUSSDReply getEmployeeInfoUSSD(GetEmployeeInfoUSSDRequest request) throws Exception;
}	  


