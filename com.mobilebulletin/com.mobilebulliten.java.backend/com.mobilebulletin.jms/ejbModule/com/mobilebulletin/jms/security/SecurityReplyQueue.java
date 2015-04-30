package com.mobilebulletin.jms.security;



import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.jboss.ejb3.annotation.ResourceAdapter;
import org.jboss.logging.Logger;




import com.mobilebulletin.local.security.*;
import com.mobilebulletin.request.security.*;
import com.mobilebulletin.response.security.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SecurityJmsUtil                                                              
 *
 * This class is used for all the Security Queues for JMS purposes.
 * This is the Consumer class 
 ***************************************************************************************************/




@MessageDriven(name = "SecurityReplyQueue",  
        activationConfig =  
             {  
                 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/SecurityReplyQueue"),
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/SecurityRequestQueue"), 
              })  
@ResourceAdapter("jms-ra.rar") 
@SuppressWarnings("serial")




public class SecurityReplyQueue  implements MessageListener, MessageDrivenBean 
{
	private static final Logger log = Logger.getLogger(SecurityReplyQueue.class.getName());
	
	  private Session session;
	  Context ctx;
	  @EJB
	  private SecurityLocalService securityLocalService;
	  


public SecurityReplyQueue()
  {
     try 
     {
    	 ctx = new InitialContext();
     } catch (NamingException e) 
     {
    	 throw new RuntimeException(e);
     }
  }




public void onMessage(Message message)
  {
	  Connection connection = null;
	  try 
	  {
	    if (message instanceof ObjectMessage)
	    {
	    	ObjectMessage receivedObject = (ObjectMessage) message;
	    	
	    	
		    log.info("****************************************************");
		    log.info("Received Message ");
		    log.info("****************************************************");
		    
		    //Send the reply
		    Destination replyDestination = message.getJMSReplyTo();
		    String correlationID = message.getJMSCorrelationID();
		    //ID which got from the client Message
		    log.info("input correlationID"+ correlationID);
		    
		    ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("/ConnectionFactory");
		    connection = connectionFactory.createConnection();
		    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		    MessageProducer replyProducer = session.createProducer(replyDestination);
		    ObjectMessage replyMessage = session.createObjectMessage();
		    setCreateReplyObjectMessage(replyMessage,receivedObject);
		    
		     replyMessage.setJMSCorrelationID(correlationID);
		     replyProducer.send(replyMessage);
		     
		     log.info("****************************************************");
		     log.info("Sent reply");
		     log.info("	Time:       " + System.currentTimeMillis() + " ms");
		     log.info("	Message ID: " + replyMessage.getJMSMessageID());
		     log.info("	Correl. ID: " + replyMessage.getJMSCorrelationID());
		     log.info("	Reply to:   " + replyMessage.getJMSReplyTo());
		     log.info("	Contents: "+replyMessage );
		     log.info("****************************************************");
		    } else 
		    {
		         log.error("Expected an Object Message");
		    }
		    connection.close();
		}catch (Throwable t) 
		{
		    t.printStackTrace();
		}finally{}			
  }




public void setCreateReplyObjectMessage(ObjectMessage replyMessage,ObjectMessage receivedObject)
  {
	  try
	  {


              if(receivedObject.getObject() instanceof ActivateAccountRequest)
               {
	                 ActivateAccountResponse response = new ActivateAccountResponse();	
	                 ActivateAccountRequest request = (ActivateAccountRequest)receivedObject.getObject();
	                 response = securityLocalService.activateAccount(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof ChangePasswordRequest)
               {
	                 ChangePasswordResponse response = new ChangePasswordResponse();	
	                 ChangePasswordRequest request = (ChangePasswordRequest)receivedObject.getObject();
	                 response = securityLocalService.changePassword(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof CheckUserRequest)
               {
	                 CheckUserResponse response = new CheckUserResponse();	
	                 CheckUserRequest request = (CheckUserRequest)receivedObject.getObject();
	                 response = securityLocalService.checkUser(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateUserRoleRequest)
               {
	                 UpdateUserRoleResponse response = new UpdateUserRoleResponse();	
	                 UpdateUserRoleRequest request = (UpdateUserRoleRequest)receivedObject.getObject();
	                 response = securityLocalService.updateUserRole(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GenerateTypesRequest)
               {
	                 GenerateTypesResponse response = new GenerateTypesResponse();	
	                 GenerateTypesRequest request = (GenerateTypesRequest)receivedObject.getObject();
	                 response = securityLocalService.generateTypes(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateUserInfoRequest)
               {
	                 UpdateUserInfoResponse response = new UpdateUserInfoResponse();	
	                 UpdateUserInfoRequest request = (UpdateUserInfoRequest)receivedObject.getObject();
	                 response = securityLocalService.updateUserInfo(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof SignUpUserRequest)
               {
	                 SignUpUserResponse response = new SignUpUserResponse();	
	                 SignUpUserRequest request = (SignUpUserRequest)receivedObject.getObject();
	                 response = securityLocalService.signUpUser(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof SignInRequest)
               {
	                 SignInResponse response = new SignInResponse();	
	                 SignInRequest request = (SignInRequest)receivedObject.getObject();
	                 response = securityLocalService.signIn(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof ForgotPasswordRequest)
               {
	                 ForgotPasswordResponse response = new ForgotPasswordResponse();	
	                 ForgotPasswordRequest request = (ForgotPasswordRequest)receivedObject.getObject();
	                 response = securityLocalService.forgotPassword(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetUserInfoRequest)
               {
	                 GetUserInfoResponse response = new GetUserInfoResponse();	
	                 GetUserInfoRequest request = (GetUserInfoRequest)receivedObject.getObject();
	                 response = securityLocalService.getUserInfo(request);	
	                 replyMessage.setObject(response);
                }

		  //TODO Autogenerator to complete
		  
	  }catch (JMSException e)
	  {
		  e.printStackTrace();
	  }catch (Exception e) 
	  {
		  e.printStackTrace();
	  }
  }


	  public void ejbRemove() throws EJBException{}
	  public void setMessageDrivenContext(MessageDrivenContext arg0) throws EJBException{}
	  public void ejbCreate(){}
}	  


