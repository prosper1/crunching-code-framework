package com.mobilebulletin.test;



import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.Before;

import com.mobilebulletin.remote.employee.AddEmployeeRequest;
import com.mobilebulletin.remote.employee.AddEmployeeResponse;
import com.mobilebulletin.remote.employee.EmployeeRemoteService;
import com.mobilebulletin.remote.employee.EmployeeRemoteServiceProxy;
import com.mobilebulletin.remote.employee.GetEmployeeByIdRequest;
import com.mobilebulletin.remote.employee.GetEmployeeByIdResponse;
import com.mobilebulletin.remote.employee.GetEmployeesFromCompanyRequest;
import com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse;
import com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseRequest;
import com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse;
import com.mobilebulletin.remote.employee.ImportEmployeesRequest;
import com.mobilebulletin.remote.employee.ImportEmployeesResponse;
import com.mobilebulletin.remote.employee.RemoveEmployeeRequest;
import com.mobilebulletin.remote.employee.RemoveEmployeeResponse;
import com.mobilebulletin.remote.employee.UpdateEmployeeRequest;
import com.mobilebulletin.remote.employee.UpdateEmployeeResponse;




/***************************************************************************************************
 *                                                                                                  
 * @author EmployeeTestUtil                                                              
 *
 * This class is used for all the Employee Test cases purposes.
 * This is the Test class 
 ***************************************************************************************************/



public class EmployeeServiceTest
{
	private Object obj;
	

	@Before
	public void setUp() throws Exception 
	{
		  final String jndiName = "com.mobilebulletin/EmployeeRemoteBean/remote";
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
	public void testAddEmployee() 
	{
		EmployeeRemoteService employeeRemoteService = new EmployeeRemoteServiceProxy();
		
		AddEmployeeRequest request = new AddEmployeeRequest();
		AddEmployeeResponse response = new AddEmployeeResponse();
		
		try
		{ 
			response = employeeRemoteService.addEmployee(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testRemoveEmployee() 
	{
		EmployeeRemoteService employeeRemoteService = new EmployeeRemoteServiceProxy();
		
		RemoveEmployeeRequest request = new RemoveEmployeeRequest();
		RemoveEmployeeResponse response = new RemoveEmployeeResponse();
		
		try
		{ 
			response = employeeRemoteService.removeEmployee(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testUpdateEmployee() 
	{
		EmployeeRemoteService employeeRemoteService = new EmployeeRemoteServiceProxy();
		
		UpdateEmployeeRequest request = new UpdateEmployeeRequest();
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		
		try
		{ 
			response = employeeRemoteService.updateEmployee(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testImportEmployees() 
	{
		EmployeeRemoteService employeeRemoteService = new EmployeeRemoteServiceProxy();
		
		ImportEmployeesRequest request = new ImportEmployeesRequest();
		ImportEmployeesResponse response = new ImportEmployeesResponse();
		
		try
		{ 
			response = employeeRemoteService.importEmployees(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testImportEmployeesFromDatabase() 
	{
		EmployeeRemoteService employeeRemoteService = new EmployeeRemoteServiceProxy();
		
		ImportEmployeesFromDatabaseRequest request = new ImportEmployeesFromDatabaseRequest();
		ImportEmployeesFromDatabaseResponse response = new ImportEmployeesFromDatabaseResponse();
		
		try
		{ 
			response = employeeRemoteService.importEmployeesFromDatabase(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testGetEmployeeById() 
	{
		EmployeeRemoteService employeeRemoteService = new EmployeeRemoteServiceProxy();
		
		GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
		GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
		
		try
		{ 
			response = employeeRemoteService.getEmployeeById(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	//@Test
	public void testGetEmployeesFromCompany() 
	{
		EmployeeRemoteService employeeRemoteService = new EmployeeRemoteServiceProxy();
		
		GetEmployeesFromCompanyRequest request = new GetEmployeesFromCompanyRequest();
		GetEmployeesFromCompanyResponse response = new GetEmployeesFromCompanyResponse();
		
		try
		{ 
			response = employeeRemoteService.getEmployeesFromCompany(request);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	   // assertEquals("Result", SERVRESPONSE.Successful.getDescription(),response.getResponse().getDescription());
	}

	@After
	public void tearDown() throws Exception 
	{
		obj = null;
	}

}	  

