package com.mobilebulletin.util.ussdsecurity;

import java.util.ArrayList;
import java.util.List;

public class USSDSecurityListObjects {
	
	public static List<String> constractList(){
		List<String> list = new ArrayList<String>();
		list.add("ActivateAccount");
		
		list.add("ChangePassword");
		list.add("CheckUser");
		list.add("ChangeUserRole");
		
		list.add("GenerateTypes");
	
		list.add("UpdateUserInfo");
		list.add("SignUpUser");
		list.add("SignUpEscort");
		list.add("SignIn");
		list.add("ForgotPassword");
		list.add("SupportQuery");
		list.add("GetUserById");
		list.add("UserUploadProfilePicture");
		list.add("GetHistoryCityTownOrAreaByUserId");
		
		
		
		//5 last visited places
		
		return list;
	}
}
