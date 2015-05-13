package com.mobilebulletin.util.ussd;

import java.util.ArrayList;
import java.util.List;

public class UssdListObjects {
	
	public static List<String> constractList(){
		List<String> list = new ArrayList<String>();
		list.add("SignUpUSSD");
		
		list.add("InitialRequestUSSD");
		list.add("SignInUSSD");
		list.add("ForgotPinUSSD");
		
		list.add("UpdateLangaugeUSSD");
	
		list.add("StopSMSNotificationUSSD");
		list.add("SendSMSToDepartmentHeadUSSD");
		list.add("SendSMSToGroupHeadUSSD");
		list.add("SupportQueryUSSD");
		list.add("GetEmployeeInfoUSSD");
		
		
		//5 last visited places
		
		return list;
	}
}
