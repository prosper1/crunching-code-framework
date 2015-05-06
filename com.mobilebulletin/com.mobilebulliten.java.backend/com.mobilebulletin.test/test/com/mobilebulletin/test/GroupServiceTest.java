package com.mobilebulletin.test;



import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;

import com.mobilebulletin.remote.group.AddGroupRequest;
import com.mobilebulletin.remote.group.AddGroupResponse;
import com.mobilebulletin.remote.group.GetGroupByIdRequest;
import com.mobilebulletin.remote.group.GetGroupByIdResponse;
import com.mobilebulletin.remote.group.GroupRemoteService;
import com.mobilebulletin.remote.group.GroupRemoteServiceProxy;
import com.mobilebulletin.remote.group.ImportGroupFromExcelRequest;
import com.mobilebulletin.remote.group.ImportGroupFromExcelResponse;
import com.mobilebulletin.remote.group.UpdateGroupInfoRequest;
import com.mobilebulletin.remote.group.UpdateGroupInfoResponse;
import com.mobilebulletin.remote.group.UpdateGroupMembersRequest;
import com.mobilebulletin.remote.group.UpdateGroupMembersResponse;




/***************************************************************************************************
 *                                                                                                  
 * @author GroupTestUtil                                                              
 *
 * This class is used for all the Group Test cases purposes.
 * This is the Test class 
 ***************************************************************************************************/



public class GroupServiceTest
{
	private Object obj;
	

	@Before
	public void setUp() throws Exception 
	{
		  final String jndiName = "com.mobilebulletin/GroupRemoteBean/remote";
		  Properties properties = new Properties();
		  properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		  properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");
		  properties.put("java.naming.provider.url","localhost:1099");
		  //properties.put("java.naming.provider.url","192.168.10.10:1099");
		  Context ic = new InitialContext(properties);
		  
		  System.out.println("about to look up jndi name " + jndiName);
		  obj = ic.lookup(jndiName);
		  System.out.println("lookup returned " + obj);
		  
	}	



	//@Test
	public void testAddGroup() 
	{
		GroupRemoteService groupRemoteService = new GroupRemoteServiceProxy();
		
		AddGroupRequest request = new AddGroupRequest();
		AddGroupResponse response = new AddGroupResponse();
		
		try
		{ 
			response = groupRemoteService.addGroup(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateGroupMembers() 
	{
		GroupRemoteService groupRemoteService = new GroupRemoteServiceProxy();
		
		UpdateGroupMembersRequest request = new UpdateGroupMembersRequest();
		UpdateGroupMembersResponse response = new UpdateGroupMembersResponse();
		
		try
		{ 
			response = groupRemoteService.updateGroupMembers(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateGroupInfo() 
	{
		GroupRemoteService groupRemoteService = new GroupRemoteServiceProxy();
		
		UpdateGroupInfoRequest request = new UpdateGroupInfoRequest();
		UpdateGroupInfoResponse response = new UpdateGroupInfoResponse();
		
		try
		{ 
			response = groupRemoteService.updateGroupInfo(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testGetGroupById() 
	{
		GroupRemoteService groupRemoteService = new GroupRemoteServiceProxy();
		
		GetGroupByIdRequest request = new GetGroupByIdRequest();
		GetGroupByIdResponse response = new GetGroupByIdResponse();
		
		try
		{ 
			response = groupRemoteService.getGroupById(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testImportGroupFromExcel() 
	{
		GroupRemoteService groupRemoteService = new GroupRemoteServiceProxy();
		
		ImportGroupFromExcelRequest request = new ImportGroupFromExcelRequest();
		ImportGroupFromExcelResponse response = new ImportGroupFromExcelResponse();
		
		try
		{ 
			response = groupRemoteService.importGroupFromExcel(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	@After
	public void tearDown() throws Exception 
	{
		obj = null;
	}

}	  

