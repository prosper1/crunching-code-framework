package com.mobilebulletin.util.ussdsecurity;

import java.util.List;

import com.mobilebulletin.util.RequestReplyUtil;

public class USSDSecurityRequestReplyUtil extends RequestReplyUtil{
	
	public USSDSecurityRequestReplyUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation,String category) {
		super(replyRequestObjects, packageName, packageLocation,category);
		// TODO Auto-generated constructor stub
	}
	private static String _PACKAGE_LINE = "package com.mobilebulletin";
	private static String _PATH_LINE = "/opt/crunchingcode/workspace/mobilebulliten/com.mobilebulletin.request.reply/src/com/mobilebulletin";
	private static String _CATEGORY_LINE = "Security";
	private static List<String> constractList(){		
		return USSDSecurityListObjects.constractList();
	}
	public static void main(String[] args) {
		USSDSecurityRequestReplyUtil jmsUtil = new USSDSecurityRequestReplyUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE);
		jmsUtil.finishJob();
	}
	
}
