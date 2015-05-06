package com.mobilebulletin.util.department;

import java.util.List;

import com.mobilebulletin.util.RequestReplyUtil;

public class DepartmentRequestReplyUtil extends RequestReplyUtil{
	
	public DepartmentRequestReplyUtil(List<String> replyRequestObjects,
			String packageName, String packageLocation,String category) {
		super(replyRequestObjects, packageName, packageLocation,category);
		// TODO Auto-generated constructor stub
	}
	private static String _PACKAGE_LINE = "package com.mobilebulletin";
	private static String _PATH_LINE = "/opt/crunching-code-framework/com.mobilebulletin/com.mobilebulliten.java.backend/com.mobilebulletin.request.reply/src/com/mobilebulletin";
	private static String _CATEGORY_LINE = "Department";
	private static List<String> constractList(){		
		return DepartmentListObjects.constractList();
	}
	public static void main(String[] args) {
		DepartmentRequestReplyUtil jmsUtil = new DepartmentRequestReplyUtil(constractList(),_PACKAGE_LINE,_PATH_LINE,_CATEGORY_LINE);
		jmsUtil.finishJob();
	}
	
}
