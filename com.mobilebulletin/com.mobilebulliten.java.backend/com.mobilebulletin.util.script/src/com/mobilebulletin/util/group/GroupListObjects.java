package com.mobilebulletin.util.group;

import java.util.ArrayList;
import java.util.List;

public class GroupListObjects {
	
	public static List<String> constractList(){
		List<String> list = new ArrayList<String>();
		list.add("AddGroup");
		
		list.add("UpdateGroupMembers");
		list.add("UpdateGroupInfo");
		list.add("GetGroupById");
		
		list.add("ImportGroupFromExcel");
	
		
		
		return list;
	}
}
