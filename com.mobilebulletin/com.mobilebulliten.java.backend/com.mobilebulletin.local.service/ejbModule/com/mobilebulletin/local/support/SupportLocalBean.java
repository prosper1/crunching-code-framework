package com.mobilebulletin.local.support;



import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import com.common.cms.GuestInformation;
import com.common.cms.Person;
import com.common.communication.ContactInformation;
import com.common.communication.ContactReference;
import com.common.log.LogActivity;
import com.common.notes.AdditionalNotes;
import com.common.support.SupportTicket;
import com.common.type.TypeHierarchy;
import com.mobilebulletin.enumerator.CONTACTTYPE;
import com.mobilebulletin.enumerator.SUPPORT_STATUS;
import com.mobilebulletin.local.common.CommonLocalService;
import com.mobilebulletin.local.security.SecurityLocalService;
import com.mobilebulletin.local.utils.FreshHelper;
import com.mobilebulletin.local.utils.LocalHelper;
import com.mobilebulletin.request.security.CheckUserRequest;
import com.mobilebulletin.request.support.AddGuestSupportQueryRequest;
import com.mobilebulletin.request.support.AddUserSupportQueryRequest;
import com.mobilebulletin.request.support.GetSupportStartUpRequest;
import com.mobilebulletin.request.support.GetSupportTicketByIdRequest;
import com.mobilebulletin.request.support.GetSupportTicketsByStatusRequest;
import com.mobilebulletin.request.support.UpdateSupportQueryRequest;
import com.mobilebulletin.response.security.CheckUserResponse;
import com.mobilebulletin.response.support.AddGuestSupportQueryResponse;
import com.mobilebulletin.response.support.AddUserSupportQueryResponse;
import com.mobilebulletin.response.support.GetSupportStartUpResponse;
import com.mobilebulletin.response.support.GetSupportTicketByIdResponse;
import com.mobilebulletin.response.support.GetSupportTicketsByStatusResponse;
import com.mobilebulletin.response.support.UpdateSupportQueryResponse;
import com.mobilebulletin.response.util.SERVRESPONSE;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportLocalUtil                                                              
 *
 * This class is used for all the Support beans for EJB Local purposes.
 * This is the Bean class 
 ***************************************************************************************************/




@Stateless
public class SupportLocalBean implements SupportLocalService
{
	private static final Logger log = Logger.getLogger(SupportLocalBean.class.getName());
	
	@PersistenceContext(unitName = "com.mobilebulletin.model")
	private EntityManager em;

	@EJB
	private CommonLocalService commonLocalService;
	
	@EJB
	private SecurityLocalService securityLocalService;

    public AddGuestSupportQueryResponse addGuestSupportQuery(AddGuestSupportQueryRequest request) throws Exception{
	      		AddGuestSupportQueryResponse response = new AddGuestSupportQueryResponse();
		
		try
		{
			 Random rand = new Random(); 
			 int pickedNumber = rand.nextInt(100000) + 10000;
			 String supportId = "SUPPORT"+pickedNumber;
			 
			 String email = null; //= HTMLHelper.constructSupportOutEmailHtml(request.getName()+" "+
					 //request.getSurname() , supportId, request.getSupportContent(), request.getEmail(), request.getHeading());
			 
			 CheckUserRequest userExistRequest = new CheckUserRequest();
			 userExistRequest.setUsername(request.getEmail());
			 CheckUserResponse userExistResponse = securityLocalService.checkUser(userExistRequest);
			 GuestInformation userInformation = null;
			 SupportTicket supportTicket = new SupportTicket();
			 Long userId = 0L;
			 LogActivity logActivity = null;
			 if(!userExistResponse.isUserExist()){
				 userInformation = new GuestInformation();
				 userInformation.setFullnameAndSurname(request.getFullname());
				 ContactInformation contactInformation = new ContactInformation();
				 contactInformation.setContactReferences(new ArrayList<ContactReference>());
					
			 //Add Email To contact information
				 ContactReference emailContactReference = new ContactReference();
				 emailContactReference.setContact(request.getEmail());
				 TypeHierarchy hierarchy = commonLocalService.getTypeHierarchyByDescription(CONTACTTYPE.Email.getDescription());
				 emailContactReference.setContactType(hierarchy);
				 contactInformation.getContactReferences().add(emailContactReference);
			 
				 userInformation.setContactInformation(contactInformation);
				 supportTicket.setEmail(request.getEmail());
				 supportTicket.setFullname(request.getFullname());
				 supportTicket.setSupportContent(request.getSupportContent());
				 supportTicket.setHeading(request.getHeading());
				 supportTicket.setSupportTickectId(supportId);
//				 TypeHierarchy type = commonLocalService
//							.getTypeHierarchyByDescription(request.getClientName());
				 logActivity = LocalHelper.getLogActivity(userInformation, userInformation.getLogActivity());
				 userInformation.setLogActivity(logActivity); 
				 em.persist(userInformation);
				 userId = commonLocalService.getCurrentSequenceIdByName("cm_seq_person");
					
			 }else {
				 Person p = commonLocalService.getPersonById(FreshHelper.decryptPrimaryKeyBytes(userExistResponse.getUserId()));
				 supportTicket.setEmail(request.getEmail());
				 supportTicket.setFullname(request.getFullname());
				 supportTicket.setSupportContent(request.getSupportContent());
				 supportTicket.setHeading(request.getHeading());
				 supportTicket.setSupportTickectId(supportId);
				 userId = p.getId();
			 }
				
				
			 
			 
			 TypeHierarchy supportStatus  = commonLocalService.getTypeHierarchyByDescription(SUPPORT_STATUS.OPENED.getDescription());
			 
			 supportTicket.setSupportStatus(supportStatus);
			 supportTicket.setCreatedByGuest(true);
//			 TypeHierarchy type = commonLocalService
//						.getTypeHierarchyByDescription(request.getClientName());
			logActivity = LocalHelper.getLogActivity(userInformation, null);
			supportTicket.setLogActivity(logActivity);
			 
			 
			 
			 
			 em.persist(supportTicket);
			 
			 	
//				SupportEmailRequest emailRequest = new SupportEmailRequest();
//				emailRequest.setHeading(request.getHeading());
//				emailRequest.setSupportQuery(request.getSupportContent());
//				emailRequest.setSupportId(supportId);
//				emailRequest.setEmailToId(userId);
//				new Email2RequestQueue().send2Queue(emailRequest);
				
			 
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

    public AddUserSupportQueryResponse addUserSupportQuery(AddUserSupportQueryRequest request) throws Exception{
	      		AddUserSupportQueryResponse response = new AddUserSupportQueryResponse();
		
	    		Person user = commonLocalService.getPersonById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestUserId()));
	    		
	    		if(user != null)
	    		{
	    			try
	    			{
	    				 Date now = new Date();
	    				 Random rand = new Random(); 
	    				 int pickedNumber = rand.nextInt(100000) + 10000;
	    				 String supportId = "SUPPORT"+pickedNumber;
	    				 
	    				 SupportTicket supportTicket = new SupportTicket();
	    				 supportTicket.setPerson(user);
	    				 supportTicket.setCreatedByGuest(false);
	    				 supportTicket.setSupportContent(request.getSupportContent());
	    				 supportTicket.setSupportTickectId(supportId);
	    				 supportTicket.setHeading(request.getHeading());
	    				 TypeHierarchy supportStatus  = commonLocalService.getTypeHierarchyByDescription(SUPPORT_STATUS.OPENED.getDescription());
	    				 
	    				 supportTicket.setSupportStatus(supportStatus);
	    				 TypeHierarchy supportModuleType  = commonLocalService.getTypeHierarchyByDescription(SUPPORT_STATUS.OPENED.getDescription());
	    				 
		    			 supportTicket.setSupportModule(supportModuleType);
//	    				 TypeHierarchy type = commonLocalService
//	    							.getTypeHierarchyByDescription(request.getClientName());
	    				LogActivity logActivity = LocalHelper.getLogActivity(user, null);
	    				supportTicket.setLogActivity(logActivity);
	    				 
	    				 supportTicket.setLogActivity(logActivity);
	    				 
	    				 em.persist(supportTicket);
	    				 
	    				 String email = null;//HTMLHelper.constructSupportInEmailHtml(user.getFirstname()+" "+
	    						// user.getLastname(), supportId, request.getUserId(), user.getUserActivation().getUsername(), request.getSupportContent(), request.getHeading());
	    				 
//	    				 SupportEmailRequest emailRequest = new SupportEmailRequest();
//	    					emailRequest.setHeading(request.getHeading());
//	    					emailRequest.setSupportQuery(request.getSupportContent());
//	    					emailRequest.setSupportId(supportId);
//	    					emailRequest.setEmailToId(user.getId());
//	    					new Email2RequestQueue().send2Queue(emailRequest);
	    					
	    				 response.setResponse(SERVRESPONSE.Successful);	
	    			}catch (Exception e)
	    			{
	    				response.setResponse(SERVRESPONSE.ServerError);
	    				String errorMessage = e.getMessage();
	    				log.error(errorMessage);
	    				
	    			}
	    		}else
	    		{
	    			response.setResponse(SERVRESPONSE.ServerError);
	    		}
		return response;
    }	  

    public UpdateSupportQueryResponse updateSupportQuery(UpdateSupportQueryRequest request) throws Exception{
	      		UpdateSupportQueryResponse response = new UpdateSupportQueryResponse();
		
		try
		{
			Person currentUser = commonLocalService.getPersonById(FreshHelper.decryptPrimaryKeyBytes(request.getRequestUserId()));
    		
			SupportTicket supportTicket = commonLocalService.getSupportTicketById(FreshHelper.decryptPrimaryKeyBytes(request.getSupportId()));
    		
			if(currentUser != null && supportTicket != null){
				AdditionalNotes additionalNotes = new AdditionalNotes();
				if(supportTicket.getAdditionalNotes() == null || supportTicket.getAdditionalNotes().isEmpty()){
					supportTicket.setAdditionalNotes(new ArrayList<AdditionalNotes>());
					if(request.getSupportComment() != null && !request.getSupportComment().isEmpty() ){
						supportTicket.getAdditionalNotes().add(additionalNotes);
						additionalNotes.setNotes(request.getSupportComment());
						LogActivity logActivity = LocalHelper.getLogActivity(currentUser, null);
						additionalNotes.setLogActivity(logActivity);
					}
				}
				
				if(request.getSupportStatus() != null){
					TypeHierarchy typeHierarchy = commonLocalService.getTypeHierarchyByDescription(request.getSupportStatus());
					supportTicket.setSupportStatus(typeHierarchy);
				}
				LogActivity logActivity = LocalHelper.getLogActivity(currentUser, supportTicket.getLogActivity());
				supportTicket.setLogActivity(logActivity);
				em.merge(supportTicket);
				response.setResponse(SERVRESPONSE.Successful);
			}else{
			
				response.setResponse(SERVRESPONSE.ServerError);
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

    public GetSupportTicketByIdResponse getSupportTicketById(GetSupportTicketByIdRequest request) throws Exception{
	      		GetSupportTicketByIdResponse response = new GetSupportTicketByIdResponse();
		
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

    public GetSupportStartUpResponse getSupportStartUp(GetSupportStartUpRequest request) throws Exception{
	      		GetSupportStartUpResponse response = new GetSupportStartUpResponse();
		
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

    public GetSupportTicketsByStatusResponse getSupportTicketsByStatus(GetSupportTicketsByStatusRequest request) throws Exception{
	      		GetSupportTicketsByStatusResponse response = new GetSupportTicketsByStatusResponse();
		
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


