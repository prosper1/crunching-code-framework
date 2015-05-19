package com.mobilebulletin.remote.employee;



import javax.ejb.Remote;




import javax.jws.HandlerChain;
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



@WebService(portName="EmployeeServicePortType", targetNamespace="mobilebulletin")
@HandlerChain(file = "../../../../com/mobilebulletin/secure/webservices/security_handler.xml")
@Remote
public interface EmployeeRemoteService
{
	


          public AddEmployeeReply addEmployee(AddEmployeeRequest request) throws Exception;

          public RemoveEmployeeReply removeEmployee(RemoveEmployeeRequest request) throws Exception;

          public UpdateEmployeeReply updateEmployee(UpdateEmployeeRequest request) throws Exception;

          public ImportEmployeesReply importEmployees(ImportEmployeesRequest request) throws Exception;

          public ImportEmployeesFromDatabaseReply importEmployeesFromDatabase(ImportEmployeesFromDatabaseRequest request) throws Exception;

          public GetEmployeeByIdReply getEmployeeById(GetEmployeeByIdRequest request) throws Exception;

          public GetEmployeesFromCompanyReply getEmployeesFromCompany(GetEmployeesFromCompanyRequest request) throws Exception;
}	  


