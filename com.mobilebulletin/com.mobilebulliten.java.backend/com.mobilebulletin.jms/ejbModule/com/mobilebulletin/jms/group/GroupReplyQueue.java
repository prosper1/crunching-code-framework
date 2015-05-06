package com.mobilebulletin.jms.group;



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




import com.mobilebulletin.local.group.*;
import com.mobilebulletin.request.group.*;
import com.mobilebulletin.response.group.*;




/***************************************************************************************************
 *                                                                                                  
 * @author GroupJmsUtil                                                              
 *
 * This class is used for all the Group Queues for JMS purposes.
 * This is the Consumer class 
 ***************************************************************************************************/




@MessageDriven(name = "GroupMOBBReplyQueue",  
        activationConfig =  
             {  
                 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/GroupMOBBReplyQueue"),
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/GroupMOBBRequestQueue"), 
              })  
@ResourceAdapter("jms-ra.rar") 
@SuppressWarnings("serial")




public class GroupReplyQueue  implements MessageListener, MessageDrivenBean 
{
	private static final Logger log = Logger.getLogger(GroupReplyQueue.class.getName());
	
	  private Session session;
	  Context ctx;
	  @EJB
	  private GroupLocalService groupLocalService;
	  


public GroupReplyQueue()
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


              if(receivedObject.getObject() instanceof AddGroupRequest)
               {
	                 AddGroupResponse response = new AddGroupResponse();	
	                 AddGroupRequest request = (AddGroupRequest)receivedObject.getObject();
	                 response = groupLocalService.addGroup(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateGroupMembersRequest)
               {
	                 UpdateGroupMembersResponse response = new UpdateGroupMembersResponse();	
	                 UpdateGroupMembersRequest request = (UpdateGroupMembersRequest)receivedObject.getObject();
	                 response = groupLocalService.updateGroupMembers(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateGroupInfoRequest)
               {
	                 UpdateGroupInfoResponse response = new UpdateGroupInfoResponse();	
	                 UpdateGroupInfoRequest request = (UpdateGroupInfoRequest)receivedObject.getObject();
	                 response = groupLocalService.updateGroupInfo(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetGroupByIdRequest)
               {
	                 GetGroupByIdResponse response = new GetGroupByIdResponse();	
	                 GetGroupByIdRequest request = (GetGroupByIdRequest)receivedObject.getObject();
	                 response = groupLocalService.getGroupById(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof ImportGroupFromExcelRequest)
               {
	                 ImportGroupFromExcelResponse response = new ImportGroupFromExcelResponse();	
	                 ImportGroupFromExcelRequest request = (ImportGroupFromExcelRequest)receivedObject.getObject();
	                 response = groupLocalService.importGroupFromExcel(request);	
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


