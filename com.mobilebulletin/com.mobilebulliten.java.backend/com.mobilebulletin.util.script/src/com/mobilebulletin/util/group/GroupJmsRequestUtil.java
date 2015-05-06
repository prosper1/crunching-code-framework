package com.mobilebulletin.util.group;

import java.util.List;

import com.mobilebulletin.util.JmsRequestUtil;

public class GroupJmsRequestUtil extends JmsRequestUtil{
	
	private static String _PACKAGE_LINE = "package com.mobilebulletin.jms.group;";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.jms/ejbModule/com/mobilebulletin/jms/group";
	private static String _CLASS_NAME_LINE = "Group";
	private static String _REQUEST_PACKAGE_IMPORT = "import com.mobilebulletin.request.group.*;";
	
	public GroupJmsRequestUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation, String className,
			String requestPackageImport) {
		super(replyRequestObjects, packageName, packageLocation, className,
				requestPackageImport);
		// TODO Auto-generated constructor stub
	}
	private static List<String> constractList(){		
		return GroupListObjects.constractList();
	}
	public static void main(String[] args) {
		GroupJmsRequestUtil outletPurposeJmsUtil = new GroupJmsRequestUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CLASS_NAME_LINE,_REQUEST_PACKAGE_IMPORT);
		String classContent = outletPurposeJmsUtil.createFinalJMS();
		outletPurposeJmsUtil.executeClassCreation(_PATH_LINE,_CLASS_NAME_LINE,classContent);
	}
}
