package com.mobilebulletin.util.ussdsecurity;

import java.util.List;

import com.mobilebulletin.util.JmsRequestUtil;

public class USSDSecurityJmsRequestUtil extends JmsRequestUtil{
	
	private static String _PACKAGE_LINE = "package com.mobilebulletin.jms.security;";
	private static String _PATH_LINE = "/opt/crunchingcode/workspace/mobilebulliten/com.mobilebulletin.jms/ejbModule/com/mobilebulletin/jms/security";
	private static String _CLASS_NAME_LINE = "Security";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.security.*;";
	
	public USSDSecurityJmsRequestUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation, String className,
			String requestPackageImport) {
		super(replyRequestObjects, packageName, packageLocation, className,
				requestPackageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return USSDSecurityListObjects.constractList();
	}
	public static void main(String[] args) {
		USSDSecurityJmsRequestUtil outletPurposeJmsUtil = new USSDSecurityJmsRequestUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CLASS_NAME_LINE,_REQUEST_PACKAGE_IMPORT);
		String classContent = outletPurposeJmsUtil.createFinalJMS();
		outletPurposeJmsUtil.executeClassCreation(_PATH_LINE,_CLASS_NAME_LINE,classContent);
	}
}
