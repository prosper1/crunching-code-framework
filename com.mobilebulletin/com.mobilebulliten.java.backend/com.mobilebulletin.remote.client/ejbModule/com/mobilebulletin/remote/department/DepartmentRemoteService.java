package com.mobilebulletin.remote.department;



import javax.ejb.Remote;




import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.mobilebulletin.request.department.*;
import com.mobilebulletin.response.department.*;




/***************************************************************************************************
 *                                                                                                  
 * @author DepartmentRemoteUtil                                                              
 *
 * This class is used for all the Department services for EJB Remote purposes.
 * This is the Service class 
 ***************************************************************************************************/



@WebService(portName="DepartmentServicePortType", targetNamespace="mobilebulletin")
@HandlerChain(file = "../../../../com/mobilebulletin/secure/webservices/security_handler.xml")
@Remote
public interface DepartmentRemoteService
{
	


          public AddDepartmentReply addDepartment(AddDepartmentRequest request) throws Exception;

          public UpdateDepartmentMembersReply updateDepartmentMembers(UpdateDepartmentMembersRequest request) throws Exception;

          public UpdateDepartmentInfoReply updateDepartmentInfo(UpdateDepartmentInfoRequest request) throws Exception;

          public GetDepartmentByIdReply getDepartmentById(GetDepartmentByIdRequest request) throws Exception;

          public ImportDepartmentFromExcelReply importDepartmentFromExcel(ImportDepartmentFromExcelRequest request) throws Exception;
          
          public GetDepartmentsByCompanyIdReply getDepartmentsByCompanyId(GetDepartmentsByCompanyIdRequest request) throws Exception;
}	  


