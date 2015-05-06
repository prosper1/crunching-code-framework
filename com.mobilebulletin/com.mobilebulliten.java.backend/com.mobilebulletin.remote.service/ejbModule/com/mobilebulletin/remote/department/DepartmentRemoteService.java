package com.mobilebulletin.remote.department;



import javax.ejb.Remote;




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



@WebService
@SOAPBinding(style = Style.RPC)
@Remote
public interface DepartmentRemoteService
{
	


          public AddDepartmentResponse addDepartment(AddDepartmentRequest request) throws Exception;

          public UpdateDepartmentMembersResponse updateDepartmentMembers(UpdateDepartmentMembersRequest request) throws Exception;

          public UpdateDepartmentInfoResponse updateDepartmentInfo(UpdateDepartmentInfoRequest request) throws Exception;

          public GetDepartmentByIdResponse getDepartmentById(GetDepartmentByIdRequest request) throws Exception;

          public ImportDepartmentFromExcelResponse importDepartmentFromExcel(ImportDepartmentFromExcelRequest request) throws Exception;
}	  


