package com.mobilebulletin.util.ussdsecurity;

import java.util.List;

import com.mobilebulletin.util.JmsReplyUtil;

public class USSDSecurityJmsReplyUtil extends JmsReplyUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.jms.security;";
	private static String _PATH_LINE = "/opt/crunchingcode/workspace/mobilebulliten/com.mobilebulletin.jms/ejbModule/com/mobilebulletin/jms/security";
	private static String _CLASS_NAME_LINE = "Security";
	private static String _LOCAL_BEAN_PACKAGE_IMPORT = "import com.mobilebulletin.local.security.*;";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.security.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.security.*;";
	
	public USSDSecurityJmsReplyUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation, String className,
			String localBeanPackageImport,String requestPackageImport, String responsePagckageImport) {
		super(replyRequestObjects, packageName, packageLocation, className,
				localBeanPackageImport,requestPackageImport, responsePagckageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return USSDSecurityListObjects.constractList();
	}
	public static void main(String[] args) {
		USSDSecurityJmsReplyUtil jmsUtil = new USSDSecurityJmsReplyUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CLASS_NAME_LINE,_LOCAL_BEAN_PACKAGE_IMPORT,_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		String classContent = jmsUtil.createFinalJMS();
		jmsUtil.executeClassCreation(_PATH_LINE,_CLASS_NAME_LINE,classContent);
	}

}