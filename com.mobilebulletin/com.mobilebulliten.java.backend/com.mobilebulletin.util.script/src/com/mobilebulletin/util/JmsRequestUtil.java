package com.mobilebulletin.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class JmsRequestUtil {
	private List<String> replyRequestObjects;
	private String packageName;
	private String packageLocation;
	private String className;
	private String requestPackageImport;
	
	public JmsRequestUtil(List<String> replyRequestObjects,String packageName
			,String packageLocation,String className,String requestPackageImport
			){
		this.replyRequestObjects = replyRequestObjects;
		this.packageName = packageName;
		this.packageLocation = packageLocation;
		this.className = className;
		this.requestPackageImport = requestPackageImport;
		
		
	}
	private static String _NEXT_LINE = "\n";
	
	protected String createFinalJMS(){
		String results = packageName+_NEXT_LINE+_NEXT_LINE;
		results+=createJmsImports();
		results+=createJmsClassRelatedImports();
		results+=createJmsComments();
		
		results+=createJmsClass();
		return results;
	}
	
	protected String createJmsImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports+="import java.util.Random;"+_NEXT_LINE;
		jmsImports+=""+_NEXT_LINE;
		jmsImports+="import javax.jms.Connection;"+_NEXT_LINE;
		jmsImports+="import javax.jms.ConnectionFactory;"+_NEXT_LINE;
		jmsImports+="import javax.jms.Destination;"+_NEXT_LINE;
		jmsImports+="import javax.jms.JMSException;"+_NEXT_LINE;
		jmsImports+="import javax.jms.Message;"+_NEXT_LINE;
		jmsImports+="import javax.jms.MessageConsumer;"+_NEXT_LINE;
		jmsImports+="import javax.jms.MessageProducer;"+_NEXT_LINE;
		jmsImports+="import javax.jms.ObjectMessage;"+_NEXT_LINE;
		jmsImports+="import javax.jms.Session;"+_NEXT_LINE;
		jmsImports+="import javax.naming.InitialContext;"+_NEXT_LINE;
		jmsImports+="import javax.naming.NamingException;"+_NEXT_LINE;
		jmsImports+=""+_NEXT_LINE;
		jmsImports+="import org.jboss.logging.Logger;"+_NEXT_LINE;
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	protected String createJmsClassRelatedImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+requestPackageImport+_NEXT_LINE;
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	protected String createJmsComments(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+"/***************************************************************************************************"+_NEXT_LINE;
		jmsImports= jmsImports+" *                                                                                                  "+_NEXT_LINE;
		jmsImports= jmsImports+" * @author "+className+"JmsRequestUtil                                                              "+_NEXT_LINE;
		jmsImports= jmsImports+" *"+_NEXT_LINE;
		jmsImports= jmsImports+" * This class is used for all the "+className+" Queues for JMS purposes."+_NEXT_LINE;
		jmsImports= jmsImports+" * This is the Producer class "+_NEXT_LINE;
		jmsImports= jmsImports+" ***************************************************************************************************/"+_NEXT_LINE;

		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	
	
	protected String createJmsCreateRandomString(){
		String results  = _NEXT_LINE+_NEXT_LINE;
		results+="	 private String createRandomString()"+_NEXT_LINE;
		results+="	 {"+_NEXT_LINE;
		results+="	     Random random = new Random(System.currentTimeMillis());"+_NEXT_LINE;
		results+="	     long randomLong = random.nextLong();"+_NEXT_LINE;
		results+="	     return Long.toHexString(randomLong);"+_NEXT_LINE;
		results+="	 }"+_NEXT_LINE;
		results  = results+_NEXT_LINE+_NEXT_LINE;
		return results;
	
	}
	
	protected String createJmsSend2Queue(){
		String results  = _NEXT_LINE+_NEXT_LINE;
		results+="	 public Object send2Queue(Object object) throws Exception"+_NEXT_LINE;
		results+="	 {		 "+_NEXT_LINE;
		results+="		  ctx = new InitialContext();"+_NEXT_LINE;
		results+="		  "+_NEXT_LINE;
		results+="		  String requestQueueName =\"queue/"+className+"RequestQueue\";"+_NEXT_LINE;
		results+="		  replyQueueName =\"queue/"+className+"ReplyQueue\";"+_NEXT_LINE;
		results+="		  String connectionFactoryName = \"/ConnectionFactory\";"+_NEXT_LINE;
		results+="		  "+_NEXT_LINE;
		results+="		  //Sending Message MDB"+_NEXT_LINE;
		results+="		  Connection connection = null;"+_NEXT_LINE;
		results+="		  session = null;"+_NEXT_LINE;
		results+="		  Destination destination = null;"+_NEXT_LINE;
		results+="		  messageProducer = null;"+_NEXT_LINE;
		results+="		  this.object = object;"+_NEXT_LINE;
		results+="		  ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup(connectionFactoryName);"+_NEXT_LINE;
		results+="		  connection = connectionFactory.createConnection();"+_NEXT_LINE;
		results+="		  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);"+_NEXT_LINE;
		results+="		  destination =(Destination) ctx.lookup(requestQueueName);"+_NEXT_LINE;
		results+="		  messageProducer = session.createProducer(destination);"+_NEXT_LINE;
		results+="		  connection.start();"+_NEXT_LINE;
		results+="		  run();"+_NEXT_LINE;
		results+="		  "+_NEXT_LINE;
		results+="		  messageProducer.close();"+_NEXT_LINE;
		results+="		  session.close();"+_NEXT_LINE;
		results+="		  connection.close();"+_NEXT_LINE;
		results+="		  "+_NEXT_LINE;
		results+="		  return replyObject;"+_NEXT_LINE;
		results+="	}"+_NEXT_LINE;
		results  = results+_NEXT_LINE+_NEXT_LINE;
		return results;
	
	}
	
	protected String createJmsSendMessage(){
		String results  = _NEXT_LINE+_NEXT_LINE;
		results+="	 public Object sendMessage() throws RuntimeException"+_NEXT_LINE; 
		results+="	 {"+_NEXT_LINE;
		results+="		 Object resultObject = null;"+_NEXT_LINE;
		results+="		 "+_NEXT_LINE;
		results+="		 try "+_NEXT_LINE;
		results+="		 {"+_NEXT_LINE;
		results+="			 String correlationId = this.createRandomString();"+_NEXT_LINE;
		results+="			 ObjectMessage objMsg = null;"+_NEXT_LINE;
		results+="			 "+_NEXT_LINE;
		results+=createReplyRequests(replyRequestObjects);
		results=results+"		  //TODO Autogenerator to complete"+_NEXT_LINE;
		results+="	"+_NEXT_LINE;			
		results+="			Destination replyQueue = (Destination) ctx.lookup(replyQueueName);"+_NEXT_LINE;
		results+="			 objMsg.setJMSReplyTo(replyQueue);"+_NEXT_LINE;
		results+="			 objMsg.setJMSCorrelationID(correlationId);"+_NEXT_LINE;
		results+="			 String messgeSelector = \"JMSCorrelationID = '\" + correlationId + \"'\";"+_NEXT_LINE;
		results+="			 "+_NEXT_LINE;
		results+="			 MessageConsumer replyConsumer = session.createConsumer(replyQueue,messgeSelector);"+_NEXT_LINE;
		results+="			 "+_NEXT_LINE;
		results+="			 messageProducer.send(objMsg, javax.jms.DeliveryMode.PERSISTENT,   javax.jms.Message.DEFAULT_PRIORITY, 1800000);"+_NEXT_LINE;
		results+="			 log.info(\"++++++++++++++++++++++++++++++++++++++++++\");"+_NEXT_LINE;
		results+="			 log.info(\"Message sent to Bean\"+ objMsg);"+_NEXT_LINE;
		results+="			 log.info(\"messgeSelector name is : \"+messgeSelector.toString());"+_NEXT_LINE;
		results+="			 log.info(\"++++++++++++++++++++++++++++++++++++++++++\");"+_NEXT_LINE;
		results+="			 "+_NEXT_LINE;
		results+="			 Message replyMessage = null;"+_NEXT_LINE;
		results+="			 boolean wait = true;"+_NEXT_LINE;
		results+="			 try"+_NEXT_LINE;
		results+="			 {"+_NEXT_LINE;
		results+="				 Thread.sleep(2000);"+_NEXT_LINE;
		results+="			 }catch (InterruptedException e) "+_NEXT_LINE;
		results+="			 {"+_NEXT_LINE;
		results+="				 e.printStackTrace();"+_NEXT_LINE;
		results+="				 throw new RuntimeException(e);"+_NEXT_LINE;
		results+="			 }"+_NEXT_LINE;
		results+="			 while(wait)"+_NEXT_LINE;
		results+="			 {"+_NEXT_LINE;
		results+="				   replyMessage = replyConsumer.receiveNoWait();"+_NEXT_LINE;
		results+="				   if(replyMessage == null)"+_NEXT_LINE;
		results+="				   {"+_NEXT_LINE;
		results+="					  try "+_NEXT_LINE;
		results+="					  {"+_NEXT_LINE;
		results+="						  Thread.sleep(5000);"+_NEXT_LINE;
		results+="					  } catch (InterruptedException e) "+_NEXT_LINE;
		results+="					  {"+_NEXT_LINE;
		results+="						// TODO Auto-generated catch block"+_NEXT_LINE;
		results+="						e.printStackTrace();"+_NEXT_LINE;
		results+="						throw new RuntimeException(e);"+_NEXT_LINE;
		results+="					  }"+_NEXT_LINE;
		results+="				   }else{"+_NEXT_LINE;
		results+="					   wait = false;"+_NEXT_LINE;
		results+="				   }"+_NEXT_LINE;
		results+="			   }"+_NEXT_LINE;
		results+="			 "+_NEXT_LINE;
		results+="			   ObjectMessage objectMessage = (ObjectMessage) replyMessage;"+_NEXT_LINE;
		results+="			   resultObject = objectMessage.getObject();"+_NEXT_LINE;
		results+="			  // resultObject = replayObject;"+_NEXT_LINE;
		results+="			   log.info(\"Request Messge --> \"+ objMsg);"+_NEXT_LINE;
		results+="			   log.info(\"Response Message --> \"+ resultObject);"+_NEXT_LINE;
		results+="			  } catch (JMSException je) "+_NEXT_LINE;
		results+="			  {"+_NEXT_LINE;
		results+="			   throw new RuntimeException(je);"+_NEXT_LINE;
		results+="			  } catch (NamingException ne) "+_NEXT_LINE;
		results+="			  {"+_NEXT_LINE;
		results+="				  throw new RuntimeException(ne);"+_NEXT_LINE;
		results+="			  }"+_NEXT_LINE;
		results+="			  	return resultObject;"+_NEXT_LINE;
		results+="	}"+_NEXT_LINE;
		  
		
		results  = results+_NEXT_LINE+_NEXT_LINE;
		return results;
	
	}
	
	protected String createJmsRun(){
		String results = _NEXT_LINE+_NEXT_LINE;
		results+="	@Override"+_NEXT_LINE;
		results+="	public void run() {"+_NEXT_LINE;
		results+="		replyObject = sendMessage();"+_NEXT_LINE;
		results+="		"+_NEXT_LINE;
		results+="	}"+_NEXT_LINE;
		results  = results+_NEXT_LINE+_NEXT_LINE;	  
		return results;
		
	}
	
	protected String createJmsClass(){
		String results = _NEXT_LINE+_NEXT_LINE;
		results+="public class "+className+"RequestQueue implements Runnable"+_NEXT_LINE;
		results+="{"+_NEXT_LINE;
		results+="	private static final Logger log = Logger.getLogger("+className+"RequestQueue.class.getName());"+_NEXT_LINE;
		results+="	"+_NEXT_LINE;
		results+="	private Session session;"+_NEXT_LINE;
		results+="	private InitialContext ctx;"+_NEXT_LINE;
		results+="	private MessageProducer messageProducer;"+_NEXT_LINE;
		results+="	private String replyQueueName;"+_NEXT_LINE;
		results+="	private Object object;"+_NEXT_LINE;
		results+="	private Object replyObject;"+_NEXT_LINE;
		results+="		  "+_NEXT_LINE;
		results+= createJmsCreateRandomString();
		results+= createJmsSend2Queue();
		results+= createJmsSendMessage();
		results+= createJmsRun();
		
		results+="}	  "+_NEXT_LINE;
		results  +=_NEXT_LINE+_NEXT_LINE;	  
		return results;
		
	}
	
	protected String createReplyRequest(String name){
		String results ="              if(object instanceof "+name+"Request)"+_NEXT_LINE;
		results+="			{"+_NEXT_LINE;
		results+="				"+name+"Request request = ("+name+"Request)object;"+_NEXT_LINE;
		results+="				objMsg = session.createObjectMessage(request);"+_NEXT_LINE;
		results+="			}";
		  
		return results;
		
	}
	
	protected String createReplyRequests(List<String> replyRequestObjects){
		String results = _NEXT_LINE+_NEXT_LINE;
		
		
		for(int i=0;i < replyRequestObjects.size();i++){
			if(i == 0 ){
				results += createReplyRequest(replyRequestObjects.get(i));
			}else{
				results += "else "+createReplyRequest(replyRequestObjects.get(i));
			}
		}
		results  = results+_NEXT_LINE+_NEXT_LINE; 
		return results;
		
	}
	
	
	protected void executeClassCreation(String path,String name,String classContent){
		try {
			
			FileUtils.writeStringToFile(new File(path+"/"+name+"RequestQueue.java"),
					classContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finishJob() {
		String classContent = createFinalJMS();
		executeClassCreation(packageLocation,className,classContent);
	}
}
