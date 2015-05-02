package com.mobilebulletin.remote.employee;



import com.mobilebulletin.jms.employee.EmployeeRequestQueue;

import javax.ejb.Stateless;



import javax.jws.WebService;

import com.mobilebulletin.request.employee.*;
import com.mobilebulletin.response.employee.*;




/***************************************************************************************************
 *                                                                                                  
 * @author EmployeeRemoteUtil                                                              
 *
 * This class is used for all the Employee beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/



@WebService(endpointInterface = "com.mobilebulletin.remote.employee.EmployeeRemoteService")
@Stateless
public class EmployeeRemoteBean implements EmployeeRemoteService
{


    public AddEmployeeResponse addEmployee(AddEmployeeRequest request) throws Exception{
	    AddEmployeeResponse response = new AddEmployeeResponse();
		
		try
		{
			response = (AddEmployeeResponse) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public RemoveEmployeeResponse removeEmployee(RemoveEmployeeRequest request) throws Exception{
	    RemoveEmployeeResponse response = new RemoveEmployeeResponse();
		
		try
		{
			response = (RemoveEmployeeResponse) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request) throws Exception{
	    UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		
		try
		{
			response = (UpdateEmployeeResponse) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportEmployeesResponse importEmployees(ImportEmployeesRequest request) throws Exception{
	    ImportEmployeesResponse response = new ImportEmployeesResponse();
		
		try
		{
			response = (ImportEmployeesResponse) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportEmployeesFromDatabaseResponse importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception{
	    ImportEmployeesFromDatabaseResponse response = new ImportEmployeesFromDatabaseResponse();
		
		try
		{
			response = (ImportEmployeesFromDatabaseResponse) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetEmployeeByIdResponse getEmployeeById(GetEmployeeByIdRequest request) throws Exception{
	    GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
		
		try
		{
			response = (GetEmployeeByIdResponse) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetEmployeesFromCompanyResponse getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception{
	    GetEmployeesFromCompanyResponse response = new GetEmployeesFromCompanyResponse();
		
		try
		{
			response = (GetEmployeesFromCompanyResponse) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


