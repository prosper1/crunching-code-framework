package com.mobilebulletin.jms.employee;



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




import com.mobilebulletin.local.employee.*;
import com.mobilebulletin.request.employee.*;
import com.mobilebulletin.response.employee.*;




/***************************************************************************************************
 *                                                                                                  
 * @author EmployeeJmsUtil                                                              
 *
 * This class is used for all the Employee Queues for JMS purposes.
 * This is the Consumer class 
 ***************************************************************************************************/




@MessageDriven(name = "EmployeeMOBBReplyQueue",  
        activationConfig =  
             {  
                 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/EmployeeMOBBReplyQueue"),
                 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/EmployeeMOBBRequestQueue"), 
              })  
@ResourceAdapter("jms-ra.rar") 
@SuppressWarnings("serial")




public class EmployeeReplyQueue  implements MessageListener, MessageDrivenBean 
{
	private static final Logger log = Logger.getLogger(EmployeeReplyQueue.class.getName());
	
	  private Session session;
	  Context ctx;
	  @EJB
	  private EmployeeLocalService employeeLocalService;
	  


public EmployeeReplyQueue()
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


              if(receivedObject.getObject() instanceof AddEmployeeRequest)
               {
	                 AddEmployeeResponse response = new AddEmployeeResponse();	
	                 AddEmployeeRequest request = (AddEmployeeRequest)receivedObject.getObject();
	                 response = employeeLocalService.addEmployee(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof RemoveEmployeeRequest)
               {
	                 RemoveEmployeeResponse response = new RemoveEmployeeResponse();	
	                 RemoveEmployeeRequest request = (RemoveEmployeeRequest)receivedObject.getObject();
	                 response = employeeLocalService.removeEmployee(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof UpdateEmployeeRequest)
               {
	                 UpdateEmployeeResponse response = new UpdateEmployeeResponse();	
	                 UpdateEmployeeRequest request = (UpdateEmployeeRequest)receivedObject.getObject();
	                 response = employeeLocalService.updateEmployee(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof ImportEmployeesRequest)
               {
	                 ImportEmployeesResponse response = new ImportEmployeesResponse();	
	                 ImportEmployeesRequest request = (ImportEmployeesRequest)receivedObject.getObject();
	                 response = employeeLocalService.importEmployees(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof ImportEmployeesFromDatabaseRequest)
               {
	                 ImportEmployeesFromDatabaseResponse response = new ImportEmployeesFromDatabaseResponse();	
	                 ImportEmployeesFromDatabaseRequest request = (ImportEmployeesFromDatabaseRequest)receivedObject.getObject();
	                 response = employeeLocalService.importEmployeesFromDatabase(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetEmployeeByIdRequest)
               {
	                 GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();	
	                 GetEmployeeByIdRequest request = (GetEmployeeByIdRequest)receivedObject.getObject();
	                 response = employeeLocalService.getEmployeeById(request);	
	                 replyMessage.setObject(response);
                }else               if(receivedObject.getObject() instanceof GetEmployeesFromCompanyRequest)
               {
	                 GetEmployeesFromCompanyResponse response = new GetEmployeesFromCompanyResponse();	
	                 GetEmployeesFromCompanyRequest request = (GetEmployeesFromCompanyRequest)receivedObject.getObject();
	                 response = employeeLocalService.getEmployeesFromCompany(request);	
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


