package com.mobilebulletin.jms.support;



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




import com.mobilebulletin.local.support.*;
import com.mobilebulletin.request.support.*;
import com.mobilebulletin.response.support.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportJmsUtil                                                              
 *
 * This class is used for all the Support Queues for JMS purposes.
 * This is the Consumer class 
 ***************************************************************************************************/




@MessageDriven(name = "SupportReplyQueue",  
        activationConfig =  
             {  
                 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/SupportReplyQueue"),
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/SupportRequestQueue"), 
              })  
@ResourceAdapter("jms-ra.rar") 
@SuppressWarnings("serial")




public class SupportReplyQueue  implements MessageListener, MessageDrivenBean 
{
	private static final Logger log = Logger.getLogger(SupportReplyQueue.class.getName());
	
	  private Session session;
	  Context ctx;
	  @EJB
	  private SupportLocalService supportLocalService;
	  


public SupportReplyQueue()
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


              if(receivedObject.getObject() instanceof AddGuestSupportQueryRequest)
               {
	                 AddGuestSupportQueryResponse response = new AddGuestSupportQueryResponse();	
	                 AddGuestSupportQueryRequest request = (AddGuestSupportQueryRequest)receivedObject.getObject();
	                 response = supportLocalService.addGuestSupportQuery(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof AddUserSupportQueryRequest)
               {
	                 AddUserSupportQueryResponse response = new AddUserSupportQueryResponse();	
	                 AddUserSupportQueryRequest request = (AddUserSupportQueryRequest)receivedObject.getObject();
	                 response = supportLocalService.addUserSupportQuery(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateSupportQueryRequest)
               {
	                 UpdateSupportQueryResponse response = new UpdateSupportQueryResponse();	
	                 UpdateSupportQueryRequest request = (UpdateSupportQueryRequest)receivedObject.getObject();
	                 response = supportLocalService.updateSupportQuery(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetSupportTicketByIdRequest)
               {
	                 GetSupportTicketByIdResponse response = new GetSupportTicketByIdResponse();	
	                 GetSupportTicketByIdRequest request = (GetSupportTicketByIdRequest)receivedObject.getObject();
	                 response = supportLocalService.getSupportTicketById(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetSupportStartUpRequest)
               {
	                 GetSupportStartUpResponse response = new GetSupportStartUpResponse();	
	                 GetSupportStartUpRequest request = (GetSupportStartUpRequest)receivedObject.getObject();
	                 response = supportLocalService.getSupportStartUp(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetSupportTicketsByStatusRequest)
               {
	                 GetSupportTicketsByStatusResponse response = new GetSupportTicketsByStatusResponse();	
	                 GetSupportTicketsByStatusRequest request = (GetSupportTicketsByStatusRequest)receivedObject.getObject();
	                 response = supportLocalService.getSupportTicketsByStatus(request);	
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


