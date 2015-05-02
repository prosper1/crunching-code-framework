package com.mobilebulletin.jms.support;



import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;




import com.mobilebulletin.request.support.*;




/***************************************************************************************************
 *                                                                                                  
 * @author SupportJmsRequestUtil                                                              
 *
 * This class is used for all the Support Queues for JMS purposes.
 * This is the Producer class 
 ***************************************************************************************************/




public class SupportRequestQueue implements Runnable
{
	private static final Logger log = Logger.getLogger(SupportRequestQueue.class.getName());
	
	private Session session;
	private InitialContext ctx;
	private MessageProducer messageProducer;
	private String replyQueueName;
	private Object object;
	private Object replyObject;
		  


	 private String createRandomString()
	 {
	     Random random = new Random(System.currentTimeMillis());
	     long randomLong = random.nextLong();
	     return Long.toHexString(randomLong);
	 }




	 public Object send2Queue(Object object) throws Exception
	 {		 
		  ctx = new InitialContext();
		  
		  String requestQueueName ="queue/SupportRequestQueue";
		  replyQueueName ="queue/SupportReplyQueue";
		  String connectionFactoryName = "/ConnectionFactory";
		  
		  //Sending Message MDB
		  Connection connection = null;
		  session = null;
		  Destination destination = null;
		  messageProducer = null;
		  this.object = object;
		  ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup(connectionFactoryName);
		  connection = connectionFactory.createConnection();
		  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		  destination =(Destination) ctx.lookup(requestQueueName);
		  messageProducer = session.createProducer(destination);
		  connection.start();
		  run();
		  
		  messageProducer.close();
		  session.close();
		  connection.close();
		  
		  return replyObject;
	}




	 public Object sendMessage() throws RuntimeException
	 {
		 Object resultObject = null;
		 
		 try 
		 {
			 String correlationId = this.createRandomString();
			 ObjectMessage objMsg = null;
			 


              if(object instanceof AddGuestSupportQueryRequest)
			{
				AddGuestSupportQueryRequest request = (AddGuestSupportQueryRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof AddUserSupportQueryRequest)
			{
				AddUserSupportQueryRequest request = (AddUserSupportQueryRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof UpdateSupportQueryRequest)
			{
				UpdateSupportQueryRequest request = (UpdateSupportQueryRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof GetSupportTicketByIdRequest)
			{
				GetSupportTicketByIdRequest request = (GetSupportTicketByIdRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof GetSupportStartUpRequest)
			{
				GetSupportStartUpRequest request = (GetSupportStartUpRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof GetSupportTicketsByStatusRequest)
			{
				GetSupportTicketsByStatusRequest request = (GetSupportTicketsByStatusRequest)object;
				objMsg = session.createObjectMessage(request);
			}

		  //TODO Autogenerator to complete
	
			Destination replyQueue = (Destination) ctx.lookup(replyQueueName);
			 objMsg.setJMSReplyTo(replyQueue);
			 objMsg.setJMSCorrelationID(correlationId);
			 String messgeSelector = "JMSCorrelationID = '" + correlationId + "'";
			 
			 MessageConsumer replyConsumer = session.createConsumer(replyQueue,messgeSelector);
			 
			 messageProducer.send(objMsg, javax.jms.DeliveryMode.PERSISTENT,   javax.jms.Message.DEFAULT_PRIORITY, 1800000);
			 log.info("++++++++++++++++++++++++++++++++++++++++++");
			 log.info("Message sent to Bean"+ objMsg);
			 log.info("messgeSelector name is : "+messgeSelector.toString());
			 log.info("++++++++++++++++++++++++++++++++++++++++++");
			 
			 Message replyMessage = null;
			 boolean wait = true;
			 try
			 {
				 Thread.sleep(2000);
			 }catch (InterruptedException e) 
			 {
				 e.printStackTrace();
				 throw new RuntimeException(e);
			 }
			 while(wait)
			 {
				   replyMessage = replyConsumer.receiveNoWait();
				   if(replyMessage == null)
				   {
					  try 
					  {
						  Thread.sleep(5000);
					  } catch (InterruptedException e) 
					  {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException(e);
					  }
				   }else{
					   wait = false;
				   }
			   }
			 
			   ObjectMessage objectMessage = (ObjectMessage) replyMessage;
			   resultObject = objectMessage.getObject();
			  // resultObject = replayObject;
			   log.info("Request Messge --> "+ objMsg);
			   log.info("Response Message --> "+ resultObject);
			  } catch (JMSException je) 
			  {
			   throw new RuntimeException(je);
			  } catch (NamingException ne) 
			  {
				  throw new RuntimeException(ne);
			  }
			  	return resultObject;
	}




	@Override
	public void run() {
		replyObject = sendMessage();
		
	}


}	  


