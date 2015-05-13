package com.mobilebulletin.jms.ussd;



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




import com.mobilebulletin.local.ussd.*;
import com.mobilebulletin.request.ussd.*;
import com.mobilebulletin.response.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDJmsUtil                                                              
 *
 * This class is used for all the USSD Queues for JMS purposes.
 * This is the Consumer class 
 ***************************************************************************************************/




@MessageDriven(name = "USSDMOBBReplyQueue",  
        activationConfig =  
             {  
                 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/USSDMOBBReplyQueue"),
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/USSDMOBBRequestQueue"), 
              })  
@ResourceAdapter("jms-ra.rar") 
@SuppressWarnings("serial")




public class USSDReplyQueue  implements MessageListener, MessageDrivenBean 
{
	private static final Logger log = Logger.getLogger(USSDReplyQueue.class.getName());
	
	  private Session session;
	  Context ctx;
	  @EJB
	  private USSDLocalService USSDLocalService;
	  


public USSDReplyQueue()
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


              if(receivedObject.getObject() instanceof SignUpUSSDRequest)
               {
	                 SignUpUSSDResponse response = new SignUpUSSDResponse();	
	                 SignUpUSSDRequest request = (SignUpUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.signUpUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof InitialRequestUSSDRequest)
               {
	                 InitialRequestUSSDResponse response = new InitialRequestUSSDResponse();	
	                 InitialRequestUSSDRequest request = (InitialRequestUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.initialRequestUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof SignInUSSDRequest)
               {
	                 SignInUSSDResponse response = new SignInUSSDResponse();	
	                 SignInUSSDRequest request = (SignInUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.signInUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof ForgotPinUSSDRequest)
               {
	                 ForgotPinUSSDResponse response = new ForgotPinUSSDResponse();	
	                 ForgotPinUSSDRequest request = (ForgotPinUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.forgotPinUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateLangaugeUSSDRequest)
               {
	                 UpdateLangaugeUSSDResponse response = new UpdateLangaugeUSSDResponse();	
	                 UpdateLangaugeUSSDRequest request = (UpdateLangaugeUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.updateLangaugeUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof StopSMSNotificationUSSDRequest)
               {
	                 StopSMSNotificationUSSDResponse response = new StopSMSNotificationUSSDResponse();	
	                 StopSMSNotificationUSSDRequest request = (StopSMSNotificationUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.stopSMSNotificationUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof SendSMSToDepartmentHeadUSSDRequest)
               {
	                 SendSMSToDepartmentHeadUSSDResponse response = new SendSMSToDepartmentHeadUSSDResponse();	
	                 SendSMSToDepartmentHeadUSSDRequest request = (SendSMSToDepartmentHeadUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.sendSMSToDepartmentHeadUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof SendSMSToGroupHeadUSSDRequest)
               {
	                 SendSMSToGroupHeadUSSDResponse response = new SendSMSToGroupHeadUSSDResponse();	
	                 SendSMSToGroupHeadUSSDRequest request = (SendSMSToGroupHeadUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.sendSMSToGroupHeadUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof SupportQueryUSSDRequest)
               {
	                 SupportQueryUSSDResponse response = new SupportQueryUSSDResponse();	
	                 SupportQueryUSSDRequest request = (SupportQueryUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.supportQueryUSSD(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetEmployeeInfoUSSDRequest)
               {
	                 GetEmployeeInfoUSSDResponse response = new GetEmployeeInfoUSSDResponse();	
	                 GetEmployeeInfoUSSDRequest request = (GetEmployeeInfoUSSDRequest)receivedObject.getObject();
	                 response = USSDLocalService.getEmployeeInfoUSSD(request);	
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


