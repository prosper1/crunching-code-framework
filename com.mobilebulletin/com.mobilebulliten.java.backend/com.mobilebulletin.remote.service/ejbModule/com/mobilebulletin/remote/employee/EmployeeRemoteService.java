package com.mobilebulletin.remote.employee;



import javax.ejb.Remote;




import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.mobilebulletin.request.employee.*;
import com.mobilebulletin.response.employee.*;




/***************************************************************************************************
 *                                                                                                  
 * @author EmployeeRemoteUtil                                                              
 *
 * This class is used for all the Employee services for EJB Remote purposes.
 * This is the Service class 
 ***************************************************************************************************/



@WebService
@SOAPBinding(style = Style.RPC)
@Remote
public interface EmployeeRemoteService
{
	


          public AddEmployeeResponse addEmployee(AddEmployeeRequest request) throws Exception;

          public RemoveEmployeeResponse removeEmployee(RemoveEmployeeRequest request) throws Exception;

          public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request) throws Exception;

          public ImportEmployeesResponse importEmployees(ImportEmployeesRequest request) throws Exception;

          public ImportEmployeesFromDatabaseResponse importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception;

          public GetEmployeeByIdResponse getEmployeeById(GetEmployeeByIdRequest request) throws Exception;

          public GetEmployeesFromCompanyResponse getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception;
}	  


