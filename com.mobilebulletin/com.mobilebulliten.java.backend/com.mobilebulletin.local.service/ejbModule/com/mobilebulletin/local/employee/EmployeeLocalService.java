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
	


          public AddEmployeeReply addEmployee(AddEmployeeRequest request) throws Exception;

          public RemoveEmployeeReply removeEmployee(RemoveEmployeeRequest request) throws Exception;

          public UpdateEmployeeReply updateEmployee(UpdateEmployeeRequest request) throws Exception;

          public ImportEmployeesReply importEmployees(ImportEmployeesRequest request) throws Exception;

          public ImportEmployeesFromDatabaseReply importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception;

          public GetEmployeeByIdReply getEmployeeById(GetEmployeeByIdRequest request) throws Exception;

          public GetEmployeesFromCompanyReply getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception;
}	  


