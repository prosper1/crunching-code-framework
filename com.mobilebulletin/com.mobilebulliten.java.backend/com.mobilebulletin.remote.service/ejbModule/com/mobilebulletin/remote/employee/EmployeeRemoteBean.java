package com.mobilebulletin.remote.employee;



import com.mobilebulletin.jms.employee.EmployeeRequestQueue;

import javax.ejb.Stateless;



import javax.jws.HandlerChain;
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



@WebService(serviceName = "MobileBulletin", portName = "EmployeeService", targetNamespace = "mobilebulletin")
@Stateless
public class EmployeeRemoteBean implements EmployeeRemoteService
{


    public AddEmployeeReply addEmployee(AddEmployeeRequest request) throws Exception{
	    AddEmployeeReply response = new AddEmployeeReply();
		
		try
		{
			response = (AddEmployeeReply) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public RemoveEmployeeReply removeEmployee(RemoveEmployeeRequest request) throws Exception{
	    RemoveEmployeeReply response = new RemoveEmployeeReply();
		
		try
		{
			response = (RemoveEmployeeReply) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateEmployeeReply updateEmployee(UpdateEmployeeRequest request) throws Exception{
	    UpdateEmployeeReply response = new UpdateEmployeeReply();
		
		try
		{
			response = (UpdateEmployeeReply) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportEmployeesReply importEmployees(ImportEmployeesRequest request) throws Exception{
	    ImportEmployeesReply response = new ImportEmployeesReply();
		
		try
		{
			response = (ImportEmployeesReply) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportEmployeesFromDatabaseReply importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception{
	    ImportEmployeesFromDatabaseReply response = new ImportEmployeesFromDatabaseReply();
		
		try
		{
			response = (ImportEmployeesFromDatabaseReply) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetEmployeeByIdReply getEmployeeById(GetEmployeeByIdRequest request) throws Exception{
	    GetEmployeeByIdReply response = new GetEmployeeByIdReply();
		
		try
		{
			response = (GetEmployeeByIdReply) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetEmployeesFromCompanyReply getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception{
	    GetEmployeesFromCompanyReply response = new GetEmployeesFromCompanyReply();
		
		try
		{
			response = (GetEmployeesFromCompanyReply) new EmployeeRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  
}	  


