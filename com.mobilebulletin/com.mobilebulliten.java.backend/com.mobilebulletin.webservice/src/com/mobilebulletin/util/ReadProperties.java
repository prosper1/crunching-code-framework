package com.mobilebulletin.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	 private ReadProperties()
	    {
		 	InputStream in = getClass().getResourceAsStream("/properties/local.properties");
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
		  System.out.println(ReadProperties.getHostProperty());
		  }catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  
	  
	  
	  public static String getHostProperty() {
		  try{
			  Properties pro = ReadProperties.getProperties();
			  String p = pro.getProperty("url.host");
			  String urlHost = new String(p);
		  return urlHost;
		  }catch(IOException e){
			  
		  }
		  return null;
	  }
	 
	  public static Properties getProperties() throws IOException{
		  ReadProperties.getSingletonObject();
		  return ReadProperties.properties;
		 
	  }
	 
}
