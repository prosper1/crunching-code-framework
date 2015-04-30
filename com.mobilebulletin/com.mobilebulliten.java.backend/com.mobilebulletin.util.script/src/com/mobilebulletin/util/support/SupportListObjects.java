package com.mobilebulletin.util.support;

import java.util.ArrayList;
import java.util.List;

public class SupportListObjects {
	
	public static List<String> constractList(){
		List<String> list = new ArrayList<String>();
		list.add("AddGuestSupportQuery");
		
		list.add("AddUserSupportQuery");
		list.add("UpdateSupportQuery");
		list.add("GetSupportTicketById");
		
		list.add("GetSupportStartUp");
	
		list.add("GetSupportNameIdList");
		
		//5 last visited places
		
		return list;
	}
}
