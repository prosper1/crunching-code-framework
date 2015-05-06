package com.mobilebulletin.util.department;

import java.util.List;

import com.mobilebulletin.util.JmsReplyUtil;

public class DepartmentJmsReplyUtil extends JmsReplyUtil{
	private static String _PACKAGE_LINE = "package com.mobilebulletin.jms.department;";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.jms/ejbModule/com/mobilebulletin/jms/department";
	private static String _CLASS_NAME_LINE = "Department";
	private static String _LOCAL_BEAN_PACKAGE_IMPORT = "import com.mobilebulletin.local.department.*;";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.department.*;";
	private static String _RESPONSE_PACKAGE_IMPORT = "import com.mobilebulletin.response.department.*;";
	
	public DepartmentJmsReplyUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation, String className,
			String localBeanPackageImport,String requestPackageImport, String responsePagckageImport) {
		super(replyRequestObjects, packageName, packageLocation, className,
				localBeanPackageImport,requestPackageImport, responsePagckageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return DepartmentListObjects.constractList();
	}
	public static void main(String[] args) {
		DepartmentJmsReplyUtil jmsUtil = new DepartmentJmsReplyUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CLASS_NAME_LINE,_LOCAL_BEAN_PACKAGE_IMPORT,_REQUEST_PACKAGE_IMPORT,_RESPONSE_PACKAGE_IMPORT);
		String classContent = jmsUtil.createFinalJMS();
		jmsUtil.executeClassCreation(_PATH_LINE,_CLASS_NAME_LINE,classContent);
	}

}
