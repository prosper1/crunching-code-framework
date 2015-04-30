package com.mobilebulletin.util;

import java.beans.Introspector;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class JmsReplyUtil {
	private List<String> replyRequestObjects;
	private String packageName;
	private String packageLocation;
	private String className;
	private String localBeanPackageImport;
	private String requestPackageImport;
	private String responsePagckageImport;
	
	private static String _NEXT_LINE = "\n";
	public JmsReplyUtil(List<String> replyRequestObjects,String packageName
			,String packageLocation,String className,String localBeanPackageImport
			,String requestPackageImport,String responsePagckageImport){
		this.replyRequestObjects = replyRequestObjects;
		this.packageName = packageName;
		this.packageLocation = packageLocation;
		this.className = className;
		this.localBeanPackageImport = localBeanPackageImport;
		this.requestPackageImport = requestPackageImport;
		this.responsePagckageImport = responsePagckageImport;
		
	}
	protected String createFinalJMS(){
		String results = packageName+_NEXT_LINE+_NEXT_LINE;
		results+=createJmsImports();
		results+=createJmsClassRelatedImports();
		results+=createJmsComments();
		results+=createJmsAnnotations();
		results+=createJmsClass();
		return results;
	}
	
	protected String createJmsImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.ejb.ActivationConfigProperty;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.ejb.EJB;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.ejb.EJBException;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.ejb.MessageDriven;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.ejb.MessageDrivenBean;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.ejb.MessageDrivenContext;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.Connection;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.ConnectionFactory;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.Destination;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.JMSException;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.Message;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.MessageListener;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.MessageProducer;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.ObjectMessage;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.jms.Session;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.naming.Context;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.naming.InitialContext;"+_NEXT_LINE;
		jmsImports= jmsImports+"import javax.naming.NamingException;"+_NEXT_LINE;
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+"import org.jboss.ejb3.annotation.ResourceAdapter;"+_NEXT_LINE;
		jmsImports= jmsImports+"import org.jboss.logging.Logger;"+_NEXT_LINE;
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	protected String createJmsClassRelatedImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+localBeanPackageImport+_NEXT_LINE;
		jmsImports= jmsImports+requestPackageImport+_NEXT_LINE;
		jmsImports= jmsImports+responsePagckageImport+_NEXT_LINE;
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	protected String createJmsComments(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+"/***************************************************************************************************"+_NEXT_LINE;
		jmsImports= jmsImports+" *                                                                                                  "+_NEXT_LINE;
		jmsImports= jmsImports+" * @author "+className+"JmsUtil                                                              "+_NEXT_LINE;
		jmsImports= jmsImports+" *"+_NEXT_LINE;
		jmsImports= jmsImports+" * This class is used for all the "+className+" Queues for JMS purposes."+_NEXT_LINE;
		jmsImports= jmsImports+" * This is the Consumer class "+_NEXT_LINE;
		jmsImports= jmsImports+" ***************************************************************************************************/"+_NEXT_LINE;

		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	protected String createJmsAnnotations(){
		String results  = _NEXT_LINE+_NEXT_LINE;
		results=results+"@MessageDriven(name = \""+className+"ReplyQueue\",  "+_NEXT_LINE;
		results=results+"        activationConfig =  "+_NEXT_LINE;
		results=results+"             {  "+_NEXT_LINE;
		results=results+"                 @ActivationConfigProperty(propertyName = \"destinationType\", propertyValue = \"javax.jms.Queue\"), "+_NEXT_LINE; 
		results=results+"                 @ActivationConfigProperty(propertyName = \"destination\", propertyValue = \"queue/"+className+"ReplyQueue\"),"+_NEXT_LINE; 
		results=results+"                 @ActivationConfigProperty(propertyName = \"destination\", propertyValue = \"queue/"+className+"RequestQueue\"), "+_NEXT_LINE;
		results=results+"              })  "+_NEXT_LINE;
		results=results+"@ResourceAdapter(\"jms-ra.rar\") "+_NEXT_LINE;
		results=results+"@SuppressWarnings(\"serial\")"+_NEXT_LINE;
		results  = results+_NEXT_LINE+_NEXT_LINE;
		return results;
	
	}
	
	protected String createJmsConstructor(){
		String results  = _NEXT_LINE+_NEXT_LINE;
		results=results+"public "+className+"ReplyQueue()"+_NEXT_LINE;
		results=results+"  {"+_NEXT_LINE;
		results=results+"     try "+_NEXT_LINE;
		results=results+"     {"+_NEXT_LINE;
		results=results+"    	 ctx = new InitialContext();"+_NEXT_LINE;
		results=results+"     } catch (NamingException e) "+_NEXT_LINE;
		results=results+"     {"+_NEXT_LINE;
		results=results+"    	 throw new RuntimeException(e);"+_NEXT_LINE;
		results=results+"     }"+_NEXT_LINE;
		results=results+"  }"+_NEXT_LINE;
		results  = results+_NEXT_LINE+_NEXT_LINE;
		return results;
	
	}
	
	protected String createJmsOnMessage(){
		String results  = _NEXT_LINE+_NEXT_LINE;
		results=results+"public void onMessage(Message message)"+_NEXT_LINE; 
		results=results+"  {"+_NEXT_LINE;
			  
		results=results+"	  Connection connection = null;"+_NEXT_LINE;
		results=results+"	  try "+_NEXT_LINE;
		results=results+"	  {"+_NEXT_LINE;
		results=results+"	    if (message instanceof ObjectMessage)"+_NEXT_LINE; 
		results=results+"	    {"+_NEXT_LINE;
		results=results+"	    	ObjectMessage receivedObject = (ObjectMessage) message;"+_NEXT_LINE;
		results=results+"	    	"+_NEXT_LINE;
		results=results+"	    	"+_NEXT_LINE;
		results=results+"		    log.info(\"****************************************************\");"+_NEXT_LINE;
		results=results+"		    log.info(\"Received Message \");"+_NEXT_LINE;
		results=results+"		    log.info(\"****************************************************\");"+_NEXT_LINE;
		results=results+"		    "+_NEXT_LINE;
		results=results+"		    //Send the reply"+_NEXT_LINE;
		results=results+"		    Destination replyDestination = message.getJMSReplyTo();"+_NEXT_LINE;
		results=results+"		    String correlationID = message.getJMSCorrelationID();"+_NEXT_LINE;
		results=results+"		    //ID which got from the client Message"+_NEXT_LINE;
		results=results+"		    log.info(\"input correlationID\"+ correlationID);"+_NEXT_LINE;
		results=results+"		    "+_NEXT_LINE;
		results=results+"		    ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup(\"/ConnectionFactory\");"+_NEXT_LINE;
		results=results+"		    connection = connectionFactory.createConnection();"+_NEXT_LINE;
		results=results+"		    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);"+_NEXT_LINE;
		results=results+"		    MessageProducer replyProducer = session.createProducer(replyDestination);"+_NEXT_LINE;
		results=results+"		    ObjectMessage replyMessage = session.createObjectMessage();"+_NEXT_LINE;
		results=results+"		    setCreateReplyObjectMessage(replyMessage,receivedObject);"+_NEXT_LINE;
		results=results+"		    "+_NEXT_LINE;
		results=results+"		     replyMessage.setJMSCorrelationID(correlationID);"+_NEXT_LINE;
		results=results+"		     replyProducer.send(replyMessage);"+_NEXT_LINE;
		results=results+"		     "+_NEXT_LINE;
		results=results+"		     log.info(\"****************************************************\");"+_NEXT_LINE;
		results=results+"		     log.info(\"Sent reply\");"+_NEXT_LINE;
		results=results+"		     log.info(\"\tTime:       \" + System.currentTimeMillis() + \" ms\");"+_NEXT_LINE;
		results=results+"		     log.info(\"\tMessage ID: \" + replyMessage.getJMSMessageID());"+_NEXT_LINE;
		results=results+"		     log.info(\"\tCorrel. ID: \" + replyMessage.getJMSCorrelationID());"+_NEXT_LINE;
		results=results+"		     log.info(\"\tReply to:   \" + replyMessage.getJMSReplyTo());"+_NEXT_LINE;
		results=results+"		     log.info(\"\tContents: \"+replyMessage );"+_NEXT_LINE;
		results=results+"		     log.info(\"****************************************************\");"+_NEXT_LINE;
		results=results+"		    } else "+_NEXT_LINE;
		results=results+"		    {"+_NEXT_LINE;
		results=results+"		         log.error(\"Expected an Object Message\");"+_NEXT_LINE;
		results=results+"		    }"+_NEXT_LINE;
		results=results+"		    connection.close();"+_NEXT_LINE;
		results=results+"		}catch (Throwable t) "+_NEXT_LINE;
		results=results+"		{"+_NEXT_LINE;
		results=results+"		    t.printStackTrace();"+_NEXT_LINE;
		results=results+"		}finally{}			"+_NEXT_LINE;
		results=results+"  }"+_NEXT_LINE;
		results  = results+_NEXT_LINE+_NEXT_LINE;
		return results;
	
	}
	
	protected String createJmsCreateReplyObjectMessage(){
		String results  = _NEXT_LINE+_NEXT_LINE;
		results=results+"public void setCreateReplyObjectMessage(ObjectMessage replyMessage,ObjectMessage receivedObject)"+_NEXT_LINE;
		results=results+"  {"+_NEXT_LINE;
		results=results+"	  try"+_NEXT_LINE;
		results=results+"	  {"+_NEXT_LINE;
		results+=createReplyRequests();
		results=results+"		  //TODO Autogenerator to complete"+_NEXT_LINE;
		results=results+"		  "+_NEXT_LINE;
		results=results+"	  }catch (JMSException e)"+_NEXT_LINE;
		results=results+"	  {"+_NEXT_LINE;
		results=results+"		  e.printStackTrace();"+_NEXT_LINE;
		results=results+"	  }catch (Exception e) "+_NEXT_LINE;
		results=results+"	  {"+_NEXT_LINE;
		results=results+"		  e.printStackTrace();"+_NEXT_LINE;
		results=results+"	  }"+_NEXT_LINE;
		results=results+"  }"+_NEXT_LINE;
		  
		
		results  = results+_NEXT_LINE+_NEXT_LINE;
		return results;
	
	}
	
	protected String createJmsClass(){
		String results = _NEXT_LINE+_NEXT_LINE;
		results=results+"public class "+className+"ReplyQueue  implements MessageListener, MessageDrivenBean "+_NEXT_LINE;
		results=results+"{"+_NEXT_LINE;
		results=results+"	private static final Logger log = Logger.getLogger("+className+"ReplyQueue.class.getName());"+_NEXT_LINE;
		results=results+"	"+_NEXT_LINE;
		results=results+"	  private Session session;"+_NEXT_LINE;
		results=results+"	  Context ctx;"+_NEXT_LINE;
		results=results+"	  @EJB"+_NEXT_LINE;
		results=results+"	  private "+className+"LocalService "+Introspector.decapitalize(className)+"LocalService;"+_NEXT_LINE;
		results=results+"	  "+_NEXT_LINE;
		results=results+ createJmsConstructor();
		results=results+ createJmsOnMessage();
		results=results+ createJmsCreateReplyObjectMessage();
		results=results+"	  public void ejbRemove() throws EJBException{}"+_NEXT_LINE;
		results=results+"	  public void setMessageDrivenContext(MessageDrivenContext arg0) throws EJBException{}"+_NEXT_LINE;
		results=results+"	  public void ejbCreate(){}"+_NEXT_LINE;
		results=results+"}	  "+_NEXT_LINE;
		results  = results+_NEXT_LINE+_NEXT_LINE;	  
		return results;
		
	}
	
	protected String createReplyRequest(String name){
		String results ="              if(receivedObject.getObject() instanceof "+name+"Request)"+_NEXT_LINE;
		results+="               {"+_NEXT_LINE;	
		results+="	                 "+name+"Response response = new "+name+"Response();	"+_NEXT_LINE;			 
		results+="	                 "+name+"Request request = ("+name+"Request)receivedObject.getObject();"+_NEXT_LINE;
		results+="	                 response = "+Introspector.decapitalize(className)+"LocalService."+Introspector.decapitalize(name)+"(request);	"+_NEXT_LINE;	  
		results+="	                 replyMessage.setObject(response);"+_NEXT_LINE;
		results+="                }";
		  
		return results;
		
	}
	
	protected String createReplyRequests(){
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
			
			FileUtils.writeStringToFile(new File(path+"/"+name+"ReplyQueue.java"),
					classContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finishJob() {
		String classContent = createFinalJMS();
		executeClassCreation(packageLocation,classContent,classContent);
	}
	
}
