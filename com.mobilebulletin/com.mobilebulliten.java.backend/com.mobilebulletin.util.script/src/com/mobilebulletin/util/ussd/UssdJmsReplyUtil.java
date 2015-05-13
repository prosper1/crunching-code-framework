package com.mobilebulletin.util.ussd;

import java.util.List;

import com.mobilebulletin.util.JmsReplyUtil;

public class UssdJmsReplyUtil extends JmsReplyUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.jms.ussd;";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.jms/ejbModule/com/mobilebulletin/jms/ussd";
	private static String _CLASS_NAME_LINE = "USSD";
	private static String _LOCAL_BEAN_PACKAGE_IMPORT = "import com.mobilebulletin.local.ussd.*;";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.ussd.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.ussd.*;";
	
	public UssdJmsReplyUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation, String className,
			String localBeanPackageImport,String requestPackageImport, String responsePagckageImport) {
		super(replyRequestObjects, packageName, packageLocation, className,
				localBeanPackageImport,requestPackageImport, responsePagckageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return UssdListObjects.constractList();
	}
	public static void main(String[] args) {
		UssdJmsReplyUtil jmsUtil = new UssdJmsReplyUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CLASS_NAME_LINE,_LOCAL_BEAN_PACKAGE_IMPORT,_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		String classContent = jmsUtil.createFinalJMS();
		jmsUtil.executeClassCreation(_PATH_LINE,_CLASS_NAME_LINE,classContent);
	}

}
