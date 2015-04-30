package com.mobilebulletin.util;

import java.beans.Introspector;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class TestUtil {
	
	private List<String> replyRequestObjects;
	private String packageName;
	private String packageLocation;
	private String category;
	private String requestPackageImport;
	private String responsePackageImport;
	
	private static String _NEXT_LINE = "\n";
	public TestUtil(List<String> replyRequestObjects,String packageName
			,String packageLocation,String category
			,String requestPackageImport,String responsePagckageImport){
		this.replyRequestObjects = replyRequestObjects;
		this.packageName = packageName;
		this.packageLocation = packageLocation;
		this.category = category;
		this.requestPackageImport = requestPackageImport;
		this.responsePackageImport = responsePagckageImport;
		
	}
	
	protected String createTestImports(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports+="import static org.junit.Assert.assertEquals;"+_NEXT_LINE;
		jmsImports+="		"+_NEXT_LINE;
		jmsImports+="import java.text.DateFormat;"+_NEXT_LINE;
		jmsImports+="import java.text.SimpleDateFormat;"+_NEXT_LINE;
		jmsImports+="import java.util.Date;"+_NEXT_LINE;
		jmsImports+="import java.util.Properties;"+_NEXT_LINE;
		jmsImports+=""+_NEXT_LINE;
		jmsImports+="import javax.naming.Context;"+_NEXT_LINE;
		jmsImports+="import javax.naming.InitialContext;"+_NEXT_LINE;
		jmsImports+=""+_NEXT_LINE;
		jmsImports+="import org.junit.After;"+_NEXT_LINE;
		jmsImports+="import org.junit.Before;"+_NEXT_LINE;
		jmsImports+="import org.junit.Test;"+_NEXT_LINE;
		jmsImports+=""+_NEXT_LINE;
		jmsImports+="import com.mobilebulletin.remote."+category.toLowerCase()+"."+category+"RemoteService;"+_NEXT_LINE;
		
		jmsImports+="import com.mobilebulletin.response.util.SERVRESPONSE;"+_NEXT_LINE;
		
		jmsImports  = jmsImports+_NEXT_LINE+_NEXT_LINE;
		return jmsImports;
	}
	
	
	
	protected void createFinalTest(){
		String results = packageName+_NEXT_LINE+_NEXT_LINE;
		results+=createTestImports();
		results+=createClassRelatedImports();
		results+=createTestComments();
		
		results+=createTestClass();
		executeClassCreation(packageLocation,category+"ServiceTest",results);
		
	}
	
	
	
	protected String createTestCases(){
		String results = _NEXT_LINE;
		for(String name:replyRequestObjects){
			results+=createTestCase(name);
		}
		return results;
	}

	protected String createTestCase(String name){
		String results = _NEXT_LINE;
		results+="	//@Test"+_NEXT_LINE;
		results+="	public void test"+name+"() "+_NEXT_LINE;
		results+="	{"+_NEXT_LINE;
		results+="		"+category+"RemoteService "+Introspector.decapitalize(category)+"RemoteService = new "+category+"RemoteServiceProxy();"+_NEXT_LINE;
		results+="		"+_NEXT_LINE;
		results+="		"+name+"Request request = new "+name+"Request();"+_NEXT_LINE;
		results+="		"+name+"Response response = new "+name+"Response();"+_NEXT_LINE;
		results+="		"+_NEXT_LINE;
		results+="		try"+_NEXT_LINE;
		results+="		{ "+_NEXT_LINE;
		results+="			response = "+Introspector.decapitalize(category)+"RemoteService."+Introspector.decapitalize(name)+"(request);"+_NEXT_LINE;
		results+="		} catch (Exception e) "+_NEXT_LINE;
		results+="		{"+_NEXT_LINE;
		results+="			e.printStackTrace();"+_NEXT_LINE;
		results+="		}"+_NEXT_LINE;
		results+="	    assertEquals(\"Result\", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());"+_NEXT_LINE;
		results+="	}"+_NEXT_LINE;
		return results;
	}
	protected String createTestClass(){
		String results = _NEXT_LINE;
		results+="public class "+category+"ServiceTest"+_NEXT_LINE;
		results+="{"+_NEXT_LINE;
		results+="	private Object obj;"+_NEXT_LINE;
		results+="	"+_NEXT_LINE;
		results+= createBefore();
		results+= createTestCases();
		results+= createAfter();
		results+="}	  "+_NEXT_LINE;
		results  +=_NEXT_LINE;	  
		return results;
	}
	
	protected String createBefore(){
		String results = _NEXT_LINE;
		results+="	@Before"+_NEXT_LINE;
		results+="	public void setUp() throws Exception "+_NEXT_LINE;
		results+="	{"+_NEXT_LINE;
		results+="		  final String jndiName = \"com.mobilebulletin/"+category+"RemoteBean/remote\";"+_NEXT_LINE;
		results+="		  Properties properties = new Properties();"+_NEXT_LINE;
		results+="		  properties.put(\"java.naming.factory.initial\",\"org.jnp.interfaces.NamingContextFactory\");"+_NEXT_LINE;
		results+="		  properties.put(\"java.naming.factory.url.pkgs\",\"=org.jboss.naming:org.jnp.interfaces\");"+_NEXT_LINE;
		results+="		  properties.put(\"java.naming.provider.url\",\"localhost:1099\");"+_NEXT_LINE;
		results+="		  //properties.put(\"java.naming.provider.url\",\"192.168.10.10:1099\");"+_NEXT_LINE;
		results+="		  Context ic = new InitialContext(properties);"+_NEXT_LINE;
		results+="		  "+_NEXT_LINE;
		results+="		  System.out.println(\"about to look up jndi name \" + jndiName);"+_NEXT_LINE;
		results+="		  obj = ic.lookup(jndiName);"+_NEXT_LINE;
		results+="		  System.out.println(\"lookup returned \" + obj);"+_NEXT_LINE;
		results+="		  "+_NEXT_LINE;
		results+="	}	"+_NEXT_LINE;
		results  +=_NEXT_LINE;	  
		return results;
	}
	
	protected String createAfter(){
		String results = _NEXT_LINE;
		results+="	@After"+_NEXT_LINE;
		results+="	public void tearDown() throws Exception "+_NEXT_LINE;
		results+="	{"+_NEXT_LINE;
		results+="		obj = null;"+_NEXT_LINE;
		results+="	}"+_NEXT_LINE;
		results  +=_NEXT_LINE;	  
		return results;
	}
	
	
	protected String createTestComments(){
		String jmsImports  = _NEXT_LINE+_NEXT_LINE;
		jmsImports= jmsImports+"/***************************************************************************************************"+_NEXT_LINE;
		jmsImports= jmsImports+" *                                                                                                  "+_NEXT_LINE;
		jmsImports= jmsImports+" * @author "+category+"TestUtil                                                              "+_NEXT_LINE;
		jmsImports= jmsImports+" *"+_NEXT_LINE;
		jmsImports= jmsImports+" * This class is used for all the "+category+" Test cases purposes."+_NEXT_LINE;
		jmsImports= jmsImports+" * This is the Test class "+_NEXT_LINE;
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
