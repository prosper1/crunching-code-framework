package com.mobilebulletin.jms.department;



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

import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.ResourceAdapter;







import com.mobilebulletin.local.department.*;
import com.mobilebulletin.request.department.*;
import com.mobilebulletin.response.department.*;




/***************************************************************************************************
 *                                                                                                  
 * @author DepartmentJmsUtil                                                              
 *
 * This class is used for all the Department Queues for JMS purposes.
 * This is the Consumer class 
 ***************************************************************************************************/




@MessageDriven(name = "DepartmentMOBBReplyQueue",  
        activationConfig =  
             {  
                 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/DepartmentMOBBReplyQueue"),
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/DepartmentMOBBRequestQueue"), 
              })  
@ResourceAdapter("jms-ra.rar") 
@SuppressWarnings("serial")




public class DepartmentReplyQueue  implements MessageListener, MessageDrivenBean 
{
	private static final Logger log = Logger.getLogger(DepartmentReplyQueue.class.getName());
	
	  private Session session;
	  Context ctx;
	  @EJB
	  private DepartmentLocalService departmentLocalService;
	  


public DepartmentReplyQueue()
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


              if(receivedObject.getObject() instanceof AddDepartmentRequest)
               {
	                 AddDepartmentReply response = new AddDepartmentReply();	
	                 AddDepartmentRequest request = (AddDepartmentRequest)receivedObject.getObject();
	                 response = departmentLocalService.addDepartment(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateDepartmentMembersRequest)
               {
	                 UpdateDepartmentMembersReply response = new UpdateDepartmentMembersReply();	
	                 UpdateDepartmentMembersRequest request = (UpdateDepartmentMembersRequest)receivedObject.getObject();
	                 response = departmentLocalService.updateDepartmentMembers(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateDepartmentInfoRequest)
               {
	                 UpdateDepartmentInfoReply response = new UpdateDepartmentInfoReply();	
	                 UpdateDepartmentInfoRequest request = (UpdateDepartmentInfoRequest)receivedObject.getObject();
	                 response = departmentLocalService.updateDepartmentInfo(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetDepartmentByIdRequest)
               {
	                 GetDepartmentByIdReply response = new GetDepartmentByIdReply();	
	                 GetDepartmentByIdRequest request = (GetDepartmentByIdRequest)receivedObject.getObject();
	                 response = departmentLocalService.getDepartmentById(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof ImportDepartmentFromExcelRequest)
               {
	                 ImportDepartmentFromExcelReply response = new ImportDepartmentFromExcelReply();	
	                 ImportDepartmentFromExcelRequest request = (ImportDepartmentFromExcelRequest)receivedObject.getObject();
	                 response = departmentLocalService.importDepartmentFromExcel(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetDepartmentsByCompanyIdRequest)
                {
                	GetDepartmentsByCompanyIdReply response = new GetDepartmentsByCompanyIdReply();	
	                 GetDepartmentsByCompanyIdRequest request = (GetDepartmentsByCompanyIdRequest)receivedObject.getObject();
	                 response = departmentLocalService.getDepartmentsByCompanyId(request);	
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


