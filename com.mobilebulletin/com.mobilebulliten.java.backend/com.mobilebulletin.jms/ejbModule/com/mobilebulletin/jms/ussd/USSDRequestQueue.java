package com.mobilebulletin.jms.ussd;



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




import com.mobilebulletin.request.ussd.*;




/***************************************************************************************************
 *                                                                                                  
 * @author USSDJmsRequestUtil                                                              
 *
 * This class is used for all the USSD Queues for JMS purposes.
 * This is the Producer class 
 ***************************************************************************************************/




public class USSDRequestQueue implements Runnable
{
	private static final Logger log = Logger.getLogger(USSDRequestQueue.class.getName());
	
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
		  
		  String requestQueueName ="queue/USSDMOBBRequestQueue";
		  replyQueueName ="queue/USSDMOBBReplyQueue";
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
			 


              if(object instanceof SignUpUSSDRequest)
			{
				SignUpUSSDRequest request = (SignUpUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof InitialRequestUSSDRequest)
			{
				InitialRequestUSSDRequest request = (InitialRequestUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof SignInUSSDRequest)
			{
				SignInUSSDRequest request = (SignInUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof ForgotPinUSSDRequest)
			{
				ForgotPinUSSDRequest request = (ForgotPinUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof UpdateLangaugeUSSDRequest)
			{
				UpdateLangaugeUSSDRequest request = (UpdateLangaugeUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof StopSMSNotificationUSSDRequest)
			{
				StopSMSNotificationUSSDRequest request = (StopSMSNotificationUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof SendSMSToDepartmentHeadUSSDRequest)
			{
				SendSMSToDepartmentHeadUSSDRequest request = (SendSMSToDepartmentHeadUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof SendSMSToGroupHeadUSSDRequest)
			{
				SendSMSToGroupHeadUSSDRequest request = (SendSMSToGroupHeadUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof SupportQueryUSSDRequest)
			{
				SupportQueryUSSDRequest request = (SupportQueryUSSDRequest)object;
				objMsg = session.createObjectMessage(request);
			}else               if(object instanceof GetEmployeeInfoUSSDRequest)
			{
				GetEmployeeInfoUSSDRequest request = (GetEmployeeInfoUSSDRequest)object;
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


