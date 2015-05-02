package com.mobilebulletin.local.employee;



import javax.ejb.Local;




import com.mobilebulletin.request.employee.*;
import com.mobilebulletin.response.employee.*;




/***************************************************************************************************
 *                                                                                                  
 * @author EmployeeLocalUtil                                                              
 *
 * This class is used for all the Employee services for EJB Local purposes.
 * This is the Service class 
 ***************************************************************************************************/




@Local
public interface EmployeeLocalService
{
	


          public AddEmployeeResponse addEmployee(AddEmployeeRequest request) throws Exception;

          public RemoveEmployeeResponse removeEmployee(RemoveEmployeeRequest request) throws Exception;

          public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request) throws Exception;

          public ImportEmployeesResponse importEmployees(ImportEmployeesRequest request) throws Exception;

          public ImportEmployeesFromDatabaseResponse importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception;

          public GetEmployeeByIdResponse getEmployeeById(GetEmployeeByIdRequest request) throws Exception;

          public GetEmployeesFromCompanyResponse getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception;
}	  


