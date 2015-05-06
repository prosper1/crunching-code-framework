package com.mobilebulletin.test;



import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;

import com.mobilebulletin.remote.department.AddDepartmentRequest;
import com.mobilebulletin.remote.department.AddDepartmentResponse;
import com.mobilebulletin.remote.department.DepartmentRemoteService;
import com.mobilebulletin.remote.department.DepartmentRemoteServiceProxy;
import com.mobilebulletin.remote.department.GetDepartmentByIdRequest;
import com.mobilebulletin.remote.department.GetDepartmentByIdResponse;
import com.mobilebulletin.remote.department.ImportDepartmentFromExcelRequest;
import com.mobilebulletin.remote.department.ImportDepartmentFromExcelResponse;
import com.mobilebulletin.remote.department.UpdateDepartmentInfoRequest;
import com.mobilebulletin.remote.department.UpdateDepartmentInfoResponse;
import com.mobilebulletin.remote.department.UpdateDepartmentMembersRequest;
import com.mobilebulletin.remote.department.UpdateDepartmentMembersResponse;




/***************************************************************************************************
 *                                                                                                  
 * @author DepartmentTestUtil                                                              
 *
 * This class is used for all the Department Test cases purposes.
 * This is the Test class 
 ***************************************************************************************************/



public class DepartmentServiceTest
{
	private Object obj;
	

	@Before
	public void setUp() throws Exception 
	{
		  final String jndiName = "com.mobilebulletin/DepartmentRemoteBean/remote";
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
	public void testAddDepartment() 
	{
		DepartmentRemoteService departmentRemoteService = new DepartmentRemoteServiceProxy();
		
		AddDepartmentRequest request = new AddDepartmentRequest();
		AddDepartmentResponse response = new AddDepartmentResponse();
		
		try
		{ 
			response = departmentRemoteService.addDepartment(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateDepartmentMembers() 
	{
		DepartmentRemoteService departmentRemoteService = new DepartmentRemoteServiceProxy();
		
		UpdateDepartmentMembersRequest request = new UpdateDepartmentMembersRequest();
		UpdateDepartmentMembersResponse response = new UpdateDepartmentMembersResponse();
		
		try
		{ 
			response = departmentRemoteService.updateDepartmentMembers(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateDepartmentInfo() 
	{
		DepartmentRemoteService departmentRemoteService = new DepartmentRemoteServiceProxy();
		
		UpdateDepartmentInfoRequest request = new UpdateDepartmentInfoRequest();
		UpdateDepartmentInfoResponse response = new UpdateDepartmentInfoResponse();
		
		try
		{ 
			response = departmentRemoteService.updateDepartmentInfo(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testGetDepartmentById() 
	{
		DepartmentRemoteService departmentRemoteService = new DepartmentRemoteServiceProxy();
		
		GetDepartmentByIdRequest request = new GetDepartmentByIdRequest();
		GetDepartmentByIdResponse response = new GetDepartmentByIdResponse();
		
		try
		{ 
			response = departmentRemoteService.getDepartmentById(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    assertEquals("Result", "Successful",response.getResponse().getDescription());
	}

	//@Test
	public void testImportDepartmentFromExcel() 
	{
		DepartmentRemoteService departmentRemoteService = new DepartmentRemoteServiceProxy();
		
		ImportDepartmentFromExcelRequest request = new ImportDepartmentFromExcelRequest();
		ImportDepartmentFromExcelResponse response = new ImportDepartmentFromExcelResponse();
		
		try
		{ 
			response = departmentRemoteService.importDepartmentFromExcel(request);
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

