package com.mobilebulletin.util;

import java.beans.Introspector;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RemoteUtil {
	
	private List<String> replyRequestObjects;
	private String packageName;
	private String packageLocation;
	private String category;
	private String requestPackageImport;
	private String responsePackageImport;
	
	private static String _NEXT_LINE = "\n";
	public RemoteUtil(List<String> replyRequestObjects,String packageName
			,String packageLocation,String category
			,String requestPackageImport,String responsePagckageImport){
		this.replyRequestObjects = replyRequestObjects;
		this.packageName = packageName;
		this.packageLocation = packageLocation;
		this.category = category;
		this.requestPackageImport = requestPackageImport;
		this.responsePackageImport = responsePagckageImport;
		
	}
	
	protected String createBeanImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports+="import com.mobilebulletin.jms."+category.toLowerCase()+"."+category+"RequestQueue;"+_NEXT_LINE;
		jmsImports+="import javax.ejb.Stateless;"+_NEXT_LINE;
		
		jmsImports  = jmsImports+_NEXT_LINE;
		return jmsImports;
	}
	
	protected String createServiceImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports+="import javax.ejb.Remote;"+_NEXT_LINE;
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	protected void createFinalBean(){
		String results = packageName+_NEXT_LINE+_NEXT_LINE;
		results+=createBeanImports();
		results+=createClassRelatedImports();
		results+=createBeanComments();
		
		results+=createBeanClass();
		executeClassCreation(packageLocation,category+"RemoteBean",results);
		
	}
	
	protected void createFinalService(){
		String results = packageName+_NEXT_LINE+_NEXT_LINE;
		results+=createServiceImports();
		results+=createClassRelatedImports();
		results+=createServiceComments();
		
		results+=createServiceClass();
		executeClassCreation(packageLocation,category+"RemoteService",results);
		
	}
	
	protected String createServices(){
		String results = _NEXT_LINE;
		for(String name:replyRequestObjects){
			results+=createService(name);
		}
		return results;
	}
	
	protected String createService(String name){
		String results = _NEXT_LINE;
		results+="          public "+name+"Response "+Introspector.decapitalize(name)+"("+name+"Request request) throws Exception;"+_NEXT_LINE;
		return results;
	}
	protected String createServiceClass(){
		String results = _NEXT_LINE+_NEXT_LINE;
		results+="@Remote"+_NEXT_LINE;
		results+="public interface "+category+"RemoteService"+_NEXT_LINE;
		results+="{"+_NEXT_LINE;
		results+="	"+_NEXT_LINE;
		results+= createServices();
		results+="}	  "+_NEXT_LINE;
		results  +=_NEXT_LINE+_NEXT_LINE;	  
		return results;
	}
	
	protected String createBeans(){
		String results = _NEXT_LINE;
		for(String name:replyRequestObjects){
			results+=createBean(name);
		}
		return results;
	}
	
	protected String createBean(String name){
		String results = _NEXT_LINE;
		results+="    public "+name+"Response "+Introspector.decapitalize(name)+"("+name+"Request request) throws Exception{"+_NEXT_LINE;
		results+="	    "+name+"Response response = new "+name+"Response();"+_NEXT_LINE;
		results+="		"+_NEXT_LINE;
		results+="		try"+_NEXT_LINE;
		results+="		{"+_NEXT_LINE;
		results+="			response = ("+name+"Response) new "+category+"RequestQueue().send2Queue(request);"+_NEXT_LINE;
		results+="		}catch(Exception e)"+_NEXT_LINE;
		results+="		{"+_NEXT_LINE;
		results+="			e.printStackTrace();"+_NEXT_LINE;
		results+="		}"+_NEXT_LINE;
		results+="		return response;"+_NEXT_LINE;
		results+="    }	  "+_NEXT_LINE;
		return results;
	}
	protected String createBeanClass(){
		String results = _NEXT_LINE+_NEXT_LINE;
		results+="@Stateless"+_NEXT_LINE;
		results+="public class "+category+"RemoteBean"+" implements "+category+"RemoteService"+_NEXT_LINE;
		results+="{"+_NEXT_LINE;
		results+= createBeans();
		results+="}	  "+_NEXT_LINE;
		results  +=_NEXT_LINE+_NEXT_LINE;	  
		return results;
	}
	
	protected String createServiceComments(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+"/***************************************************************************************************"+_NEXT_LINE;
		jmsImports= jmsImports+" *                                                                                                  "+_NEXT_LINE;
		jmsImports= jmsImports+" * @author "+category+"RemoteUtil                                                              "+_NEXT_LINE;
		jmsImports= jmsImports+" *"+_NEXT_LINE;
		jmsImports= jmsImports+" * This class is used for all the "+category+" services for EJB Remote purposes."+_NEXT_LINE;
		jmsImports= jmsImports+" * This is the Service class "+_NEXT_LINE;
		jmsImports= jmsImports+" ***************************************************************************************************/"+_NEXT_LINE;

		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	protected String createBeanComments(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+"/***************************************************************************************************"+_NEXT_LINE;
		jmsImports= jmsImports+" *                                                                                                  "+_NEXT_LINE;
		jmsImports= jmsImports+" * @author "+category+"RemoteUtil                                                              "+_NEXT_LINE;
		jmsImports= jmsImports+" *"+_NEXT_LINE;
		jmsImports= jmsImports+" * This class is used for all the "+category+" beans for EJB Remote purposes."+_NEXT_LINE;
		jmsImports= jmsImports+" * This is the Bean class "+_NEXT_LINE;
		jmsImports= jmsImports+" ***************************************************************************************************/"+_NEXT_LINE;

		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	protected String createClassRelatedImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+requestPackageImport+_NEXT_LINE;
		jmsImports= jmsImports+responsePackageImport+_NEXT_LINE;
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	protected void executeClassCreation(String path,String name,String classContent){
		try {
			
			FileUtils.writeStringToFile(new File(path+"/"+name+".java"),
					classContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
