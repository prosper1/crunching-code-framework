package com.mobilebulletin.util.security;

import java.util.List;

import com.mobilebulletin.util.RequestReplyUtil;

public class SecurityRequestReplyUtil extends RequestReplyUtil{
	
	public SecurityRequestReplyUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation,String category) {
		super(replyRequestObjects, packageName, packageLocation,category);
		// TODO Auto-generated constructor stub
	}
	private static String _PACKAGE_LINE = "package com.mobilebulletin";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.request.reply/src/com/mobilebulletin";
	private static String _CATEGORY_LINE = "Security";
	private static List<String> constractList(){		
		return SecurityListObjects.constractList();
	}
	public static void main(String[] args) {
		SecurityRequestReplyUtil jmsUtil = new SecurityRequestReplyUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE);
		jmsUtil.finishJob();
	}
	
}
