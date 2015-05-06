package com.mobilebulletin.local.department;



import javax.ejb.Local;

import com.mobilebulletin.request.department.AddDepartmentRequest;
import com.mobilebulletin.request.department.GetDepartmentByIdRequest;
import com.mobilebulletin.request.department.GetDepartmentsByCompanyIdRequest;
import com.mobilebulletin.request.department.ImportDepartmentFromExcelRequest;
import com.mobilebulletin.request.department.UpdateDepartmentInfoRequest;
import com.mobilebulletin.request.department.UpdateDepartmentMembersRequest;
import com.mobilebulletin.response.department.AddDepartmentResponse;
import com.mobilebulletin.response.department.GetDepartmentByIdResponse;
import com.mobilebulletin.response.department.GetDepartmentsByCompanyIdResponse;
import com.mobilebulletin.response.department.ImportDepartmentFromExcelResponse;
import com.mobilebulletin.response.department.UpdateDepartmentInfoResponse;
import com.mobilebulletin.response.department.UpdateDepartmentMembersResponse;




/***************************************************************************************************
 *                                                                                                  
 * @author DepartmentLocalUtil                                                              
 *
 * This class is used for all the Department services for EJB Local purposes.
 * This is the Service class 
 ***************************************************************************************************/




@Local
public interface DepartmentLocalService
{
	


          public AddDepartmentResponse addDepartment(AddDepartmentRequest request) throws Exception;

          public UpdateDepartmentMembersResponse updateDepartmentMembers(UpdateDepartmentMembersRequest request) throws Exception;

          public UpdateDepartmentInfoResponse updateDepartmentInfo(UpdateDepartmentInfoRequest request) throws Exception;

          public GetDepartmentByIdResponse getDepartmentById(GetDepartmentByIdRequest request) throws Exception;

          public ImportDepartmentFromExcelResponse importDepartmentFromExcel(ImportDepartmentFromExcelRequest request) throws Exception;
          
          public GetDepartmentsByCompanyIdResponse getDepartmentsByCompanyId(GetDepartmentsByCompanyIdRequest request) throws Exception;
}	  


