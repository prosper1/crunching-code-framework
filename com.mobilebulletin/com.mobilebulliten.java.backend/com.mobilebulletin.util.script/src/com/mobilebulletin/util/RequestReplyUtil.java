package com.mobilebulletin.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RequestReplyUtil {
	private List<String> replyRequestObjects;
	private String packageName;
	private String packageLocation;
	private String category;
	public RequestReplyUtil(List<String> replyRequestObjects,String packageName
			,String packageLocation,String category){
		this.replyRequestObjects = replyRequestObjects;
		this.packageName = packageName;
		this.packageLocation = packageLocation;
		this.category = category;
	}
	protected String createClassReplyRequest(String packageName ,String path,String Name,boolean isResponse){
		String fullClassText = null;
			
			String nextLine = "\n";
			String imports = "import java.io.Serializable;"+nextLine+nextLine+nextLine;
			
			String superResponse = null;			
			String className = null;
			if(!isResponse){
				className = "public class "+Name +"Request implements Serializable{"+nextLine+nextLine;
				superResponse = "";
			}else{
				className = "public class "+Name +"Response extends SystemSuperResponse implements Serializable{"+nextLine+nextLine;
				superResponse = "import com.mobilebulletin.response.util.SystemSuperResponse;"+nextLine+nextLine+nextLine;			
			}
			String comments = "/**"+nextLine+
			 "* "+nextLine+
			 "*/"+nextLine;
			String uid = "private static final long serialVersionUID = 1L;"+nextLine+nextLine+nextLine+nextLine;
			String closing = "}";
			if(isResponse){
				packageName+=".response."+category.toLowerCase()+";"+nextLine+nextLine;
				path+="/response/"+category.toLowerCase()+"/";
			}else{
				packageName+=".request."+category.toLowerCase()+";"+nextLine+nextLine;
				path+="/request/"+category.toLowerCase()+"/";
			}
			fullClassText = packageName+imports+superResponse+className+comments+uid+closing;
			if(!isResponse){
				Name+="Request";
			}else{
				Name+="Response";
			}
			executeClassCreation(path,Name,fullClassText);
		
		return fullClassText;
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
	
	public void finishJob() {
			
		for(String name:replyRequestObjects){
			
				createClassReplyRequest(packageName,packageLocation, name, true);
			
				
				createClassReplyRequest(packageName,packageLocation, name, false);
				
			
		}
		
	}

}
