package com.mobilebulletin.util.department;

import java.util.List;

import com.mobilebulletin.util.RemoteUtil;

public class DepartmentRemoteUtil extends RemoteUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.remote.department;";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.remote.service/ejbModule/com/mobilebulletin/remote/department";
	private static String _CATEGORY_LINE = "Department";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.department.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.department.*;";
	
	public DepartmentRemoteUtil(List<String> replyRequestObjects, String packageName,
			String packageLocation, String category,
			String requestPackageImport, String responsePagckageImport) {
		super(replyRequestObjects, packageName, packageLocation, category,
				requestPackageImport, responsePagckageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return DepartmentListObjects.constractList();
	}
	public static void main(String[] args) {
		DepartmentRemoteUtil jmsUtil = new DepartmentRemoteUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE,
				_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		jmsUtil.createFinalService();
		jmsUtil.createFinalBean();
	}

}
