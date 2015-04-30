package com.mobilebulletin.local.utils;

import org.jboss.logging.Logger;

public class OSValidator {
	private static final Logger log = Logger.getLogger(OSValidator.class.getName());
	
	public static void main(String[] args)
	{
		if(isWindows()){
			log.info("This is Windows");
		}else if(isMac()){
			log.info("This is Mac");
		}else if(isUnix()){
			log.info("This is Unix or Linux");
		}else{
			log.info("Your OS is not support!!");
		}
	}
 
	public static boolean isWindows(){
 
		String os = System.getProperty("os.name").toLowerCase();
		//windows
	    return (os.indexOf( "win" ) >= 0); 
 
	}
 
	public static boolean isMac(){
 
		String os = System.getProperty("os.name").toLowerCase();
		//Mac
	    return (os.indexOf( "mac" ) >= 0); 
 
	}
 
	public static boolean isUnix(){
 
		String os = System.getProperty("os.name").toLowerCase();
		//linux or unix
	    return (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0);
 
	}
}
