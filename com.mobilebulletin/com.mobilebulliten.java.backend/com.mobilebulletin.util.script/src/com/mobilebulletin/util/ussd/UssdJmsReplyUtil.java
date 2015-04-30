package com.mobilebulletin.util.ussd;

import java.util.List;

import com.mobilebulletin.util.JmsReplyUtil;

public class UssdJmsReplyUtil extends JmsReplyUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.jms.support;";
	private static String _PATH_LINE = "/Users/vutlhari/git2/pop-business/backend/com.mobilebulletin.jms/ejbModule/com/mobilebulletin/jms/support";
	private static String _CLASS_NAME_LINE = "Support";
	private static String _LOCAL_BEAN_PACKAGE_IMPORT = "import com.mobilebulletin.local.support.*;";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.support.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.support.*;";
	
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
