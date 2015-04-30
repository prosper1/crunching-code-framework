package com.mobilebulletin.util.ussdsecurity;

import java.util.List;

import com.mobilebulletin.util.RemoteUtil;

public class USSDSecurityRemoteUtil extends RemoteUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.remote.security;";
	private static String _PATH_LINE = "/opt/crunchingcode/workspace/mobilebulliten/com.mobilebulletin.remote.service/ejbModule/com/mobilebulletin/remote/security";
	private static String _CATEGORY_LINE = "Security";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.security.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.security.*;";
	
	public USSDSecurityRemoteUtil(List<String> replyRequestObjects, String packageName,
			String packageLocation, String category,
			String requestPackageImport, String responsePagckageImport) {
		super(replyRequestObjects, packageName, packageLocation, category,
				requestPackageImport, responsePagckageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return USSDSecurityListObjects.constractList();
	}
	public static void main(String[] args) {
		USSDSecurityRemoteUtil jmsUtil = new USSDSecurityRemoteUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE,
				_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		jmsUtil.createFinalService();
		jmsUtil.createFinalBean();
	}

}