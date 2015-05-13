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


    public SignUpUSSDResponse signUpUSSD(SignUpUSSDRequest request) throws Exception{
	      		SignUpUSSDResponse response = new SignUpUSSDResponse();
		
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

    public InitialRequestUSSDResponse initialRequestUSSD(InitialRequestUSSDRequest request) throws Exception{
	      		InitialRequestUSSDResponse response = new InitialRequestUSSDResponse();
		
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

    public SignInUSSDResponse signInUSSD(SignInUSSDRequest request) throws Exception{
	      		SignInUSSDResponse response = new SignInUSSDResponse();
		
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

    public ForgotPinUSSDResponse forgotPinUSSD(ForgotPinUSSDRequest request) throws Exception{
	      		ForgotPinUSSDResponse response = new ForgotPinUSSDResponse();
		
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

    public UpdateLangaugeUSSDResponse updateLangaugeUSSD(UpdateLangaugeUSSDRequest request) throws Exception{
	      		UpdateLangaugeUSSDResponse response = new UpdateLangaugeUSSDResponse();
		
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

    public StopSMSNotificationUSSDResponse stopSMSNotificationUSSD(StopSMSNotificationUSSDRequest request) throws Exception{
	      		StopSMSNotificationUSSDResponse response = new StopSMSNotificationUSSDResponse();
		
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

    public SendSMSToDepartmentHeadUSSDResponse sendSMSToDepartmentHeadUSSD(SendSMSToDepartmentHeadUSSDRequest request) throws Exception{
	      		SendSMSToDepartmentHeadUSSDResponse response = new SendSMSToDepartmentHeadUSSDResponse();
		
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

    public SendSMSToGroupHeadUSSDResponse sendSMSToGroupHeadUSSD(SendSMSToGroupHeadUSSDRequest request) throws Exception{
	      		SendSMSToGroupHeadUSSDResponse response = new SendSMSToGroupHeadUSSDResponse();
		
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

    public SupportQueryUSSDResponse supportQueryUSSD(SupportQueryUSSDRequest request) throws Exception{
	      		SupportQueryUSSDResponse response = new SupportQueryUSSDResponse();
		
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

    public GetEmployeeInfoUSSDResponse getEmployeeInfoUSSD(GetEmployeeInfoUSSDRequest request) throws Exception{
	      		GetEmployeeInfoUSSDResponse response = new GetEmployeeInfoUSSDResponse();
		
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


