package com.mobilebulletin.local.ussd;



import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.common.cms.UserInformation;
import com.common.log.LogActivity;
import com.common.type.TypeHierarchy;
import com.itextpdf.text.xml.xmp.LangAlt;
import com.mobilebulletin.enumerator.CONTACTTYPE;
import com.mobilebulletin.enumerator.LANGUAGE_TYPE;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.utils.LocalHelper;
import com.mobilebulletin.response.util.SERVRESPONSE;




import com.mobilebulletin.request.ussd.*;
import com.mobilebulletin.response.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDLocalUtil                                                              
 *
 * This class is used for all the USSD beans for EJB Local purposes.
 * This is the Bean class 
 ***************************************************************************************************/




@Stateless
public class USSDLocalBean implements USSDLocalService
{
	private static final Logger log = Logger.getLogger(USSDLocalBean.class.getName());
	
	@PersistenceContext(unitName = "com.mobilebulletin.model")
	private EntityManager em;

	@EJB
	private CommonLocalService commonLocalService;


    public SignUpUSSDReply signUpUSSD(SignUpUSSDRequest request) throws Exception{
	      		SignUpUSSDReply response = new SignUpUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public InitialRequestUSSDReply initialRequestUSSD(InitialRequestUSSDRequest request) throws Exception{
	      		InitialRequestUSSDReply response = new InitialRequestUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public SignInUSSDReply signInUSSD(SignInUSSDRequest request) throws Exception{
	      		SignInUSSDReply response = new SignInUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public ForgotPinUSSDReply forgotPinUSSD(ForgotPinUSSDRequest request) throws Exception{
	      		ForgotPinUSSDReply response = new ForgotPinUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public UpdateLangaugeUSSDReply updateLangaugeUSSD(UpdateLangaugeUSSDRequest request) throws Exception{
	      		UpdateLangaugeUSSDReply response = new UpdateLangaugeUSSDReply();
		
		try
		{
			UserInformation employeeInfo = commonLocalService.getEmployeeByCellNo(request.getRequestCellNumber());
			TypeHierarchy langauge = commonLocalService
					.getTypeHierarchyByDescription(request.getLangauge());
			if(employeeInfo != null && langauge != null){
				employeeInfo.setLangaugeType(langauge);
				LogActivity logActivity = LocalHelper.getLogActivity(employeeInfo, employeeInfo.getLogActivity());
				employeeInfo.setLogActivity(logActivity);
				em.merge(employeeInfo);
				response.setResponse(SERVRESPONSE.Successful);
			}else{
				response.setResponse(SERVRESPONSE.UpdateFailed);
			}
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public StopSMSNotificationUSSDReply stopSMSNotificationUSSD(StopSMSNotificationUSSDRequest request) throws Exception{
	      		StopSMSNotificationUSSDReply response = new StopSMSNotificationUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public SendSMSToDepartmentHeadUSSDReply sendSMSToDepartmentHeadUSSD(SendSMSToDepartmentHeadUSSDRequest request) throws Exception{
	      		SendSMSToDepartmentHeadUSSDReply response = new SendSMSToDepartmentHeadUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public SendSMSToGroupHeadUSSDReply sendSMSToGroupHeadUSSD(SendSMSToGroupHeadUSSDRequest request) throws Exception{
	      		SendSMSToGroupHeadUSSDReply response = new SendSMSToGroupHeadUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public SupportQueryUSSDReply supportQueryUSSD(SupportQueryUSSDRequest request) throws Exception{
	      		SupportQueryUSSDReply response = new SupportQueryUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  

    public GetEmployeeInfoUSSDReply getEmployeeInfoUSSD(GetEmployeeInfoUSSDRequest request) throws Exception{
	      		GetEmployeeInfoUSSDReply response = new GetEmployeeInfoUSSDReply();
		
		try
		{
			
			
			response.setResponse(SERVRESPONSE.Successful);
		}catch(Exception e)
		{
			response.setResponse(SERVRESPONSE.ServerError);
			response.setServValidation(e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return response;
    }	  
}	  


