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
	


          public SignUpUSSDResponse signUpUSSD(SignUpUSSDRequest request) throws Exception;

          public InitialRequestUSSDResponse initialRequestUSSD(InitialRequestUSSDRequest request) throws Exception;

          public SignInUSSDResponse signInUSSD(SignInUSSDRequest request) throws Exception;

          public ForgotPinUSSDResponse forgotPinUSSD(ForgotPinUSSDRequest request) throws Exception;

          public UpdateLangaugeUSSDResponse updateLangaugeUSSD(UpdateLangaugeUSSDRequest request) throws Exception;

          public StopSMSNotificationUSSDResponse stopSMSNotificationUSSD(StopSMSNotificationUSSDRequest request) throws Exception;

          public SendSMSToDepartmentHeadUSSDResponse sendSMSToDepartmentHeadUSSD(SendSMSToDepartmentHeadUSSDRequest request) throws Exception;

          public SendSMSToGroupHeadUSSDResponse sendSMSToGroupHeadUSSD(SendSMSToGroupHeadUSSDRequest request) throws Exception;

          public SupportQueryUSSDResponse supportQueryUSSD(SupportQueryUSSDRequest request) throws Exception;

          public GetEmployeeInfoUSSDResponse getEmployeeInfoUSSD(GetEmployeeInfoUSSDRequest request) throws Exception;
}	  


