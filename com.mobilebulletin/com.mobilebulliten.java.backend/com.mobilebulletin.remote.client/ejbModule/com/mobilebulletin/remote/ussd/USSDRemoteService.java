package com.mobilebulletin.remote.ussd;



import javax.ejb.Remote;




import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.mobilebulletin.request.ussd.*;
import com.mobilebulletin.response.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDRemoteUtil                                                              
 *
 * This class is used for all the USSD services for EJB Remote purposes.
 * This is the Service class 
 ***************************************************************************************************/


@WebService(portName="USSDServicePortType", targetNamespace="mobilebulletin")
@HandlerChain(file = "../../../../com/mobilebulletin/secure/webservices/security_handler.xml")
@Remote
public interface USSDRemoteService
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


