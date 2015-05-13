package com.mobilebulletin.webservice.handler;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	 private ReadProperties()
	    {
		 	InputStream in = getClass().getResourceAsStream("/properties/webservices.properties");
		 	properties = new Properties();
		 	try {
				properties.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	private static Properties  properties;
	    public static ReadProperties getSingletonObject() throws IOException
	    {
	      if (ref == null){
	          // it's ok, we can call this constructor
	          ref = new ReadProperties();
	          
	      }
	      return ref;
	    }

	    private static ReadProperties ref;
	
	  public static void main(String[] args) {
		  try{
		  System.out.println(ReadProperties.getUsernameProperty());
		  }catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  
	  protected static String getUsernameProperty() throws IOException{
		  Properties pro = ReadProperties.getProperties();
		  String p = pro.getProperty("username");
		  String username = new String(p);
		  return username;
	  }
	  
	  protected static String getPasswordProperty() throws IOException{
		  Properties pro = ReadProperties.getProperties();
		  String p = pro.getProperty("password");
		  String password = new String(p);
		  return password;
	  }
	 
	  private static Properties getProperties() throws IOException{
		  ReadProperties.getSingletonObject();
		  return ReadProperties.properties;
		 
	  }
	 
}
