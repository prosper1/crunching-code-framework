package com.mobilebulletin.util.security;

import java.util.ArrayList;
import java.util.List;

public class SecurityListObjects {
	
	public static List<String> constractList(){
		List<String> list = new ArrayList<String>();
		list.add("ActivateAccount");
		
		list.add("ChangePassword");
		list.add("CheckUser");
		list.add("UpdateUserRole");
		
		list.add("GenerateTypes");
	
		list.add("UpdateUserInfo");
		list.add("SignUpUser");
//		list.add("SignUpEscort");
		list.add("SignIn");
		list.add("ForgotPassword");
//		list.add("SupportQuery");
		list.add("GetUserInfo");
		//list.add("UserUploadProfilePicture");
	//	list.add("GetHistoryCityTownOrAreaByUserId");
		
		
		
		//5 last visited places
		
		return list;
	}
}
