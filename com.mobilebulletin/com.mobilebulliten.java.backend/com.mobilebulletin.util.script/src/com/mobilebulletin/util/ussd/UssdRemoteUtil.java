package com.mobilebulletin.util.ussd;

import java.util.List;

import com.mobilebulletin.util.RemoteUtil;

public class UssdRemoteUtil extends RemoteUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.remote.support;";
	private static String _PATH_LINE = "/Users/vutlhari/git2/pop-business/backend/com.mobilebulletin.remote.service/ejbModule/com/mobilebulletin/remote/support";
	private static String _CATEGORY_LINE = "Support";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.support.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.support.*;";
	
	public UssdRemoteUtil(List<String> replyRequestObjects, String packageName,
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
		UssdRemoteUtil jmsUtil = new UssdRemoteUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE,
				_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		jmsUtil.createFinalService();
		jmsUtil.createFinalBean();
	}

}
