package com.mobilebulletin.util.group;

import java.util.List;

import com.mobilebulletin.util.RemoteUtil;

public class GroupRemoteUtil extends RemoteUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.remote.group;";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.remote.service/ejbModule/com/mobilebulletin/remote/group";
	private static String _CATEGORY_LINE = "Group";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.group.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.group.*;";
	
	public GroupRemoteUtil(List<String> replyRequestObjects, String packageName,
			String packageLocation, String category,
			String requestPackageImport, String responsePagckageImport) {
		super(replyRequestObjects, packageName, packageLocation, category,
				requestPackageImport, responsePagckageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return GroupListObjects.constractList();
	}
	public static void main(String[] args) {
		GroupRemoteUtil jmsUtil = new GroupRemoteUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE,
				_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		jmsUtil.createFinalService();
		jmsUtil.createFinalBean();
	}

}
