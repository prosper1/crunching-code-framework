package com.mobilebulletin.util.ussd;

import java.util.List;

import com.mobilebulletin.util.LocalUtil;

public class UssdLocalUtil extends LocalUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.local.ussd;";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.local.service/ejbModule/com/mobilebulletin/local/ussd";
	private static String _CATEGORY_LINE = "USSD";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.ussd.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.ussd.*;";
	
	public UssdLocalUtil(List<String> replyRequestObjects, String packageName,
			String packageLocation, String category,
			String requestPackageImport, String responsePagckageImport) {
		super(replyRequestObjects, packageName, packageLocation, category,
				requestPackageImport, responsePagckageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return UssdListObjects.constractList();
	}
	public static void main(String[] args) {
		UssdLocalUtil jmsUtil = new UssdLocalUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE,
				_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		jmsUtil.createFinalService();
		jmsUtil.createFinalBean();
	}

}
