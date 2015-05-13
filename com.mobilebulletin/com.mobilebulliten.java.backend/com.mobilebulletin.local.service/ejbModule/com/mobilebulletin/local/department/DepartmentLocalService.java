package com.mobilebulletin.local.department;



import javax.ejb.Local;

import com.mobilebulletin.request.department.AddDepartmentRequest;
import com.mobilebulletin.request.department.GetDepartmentByIdRequest;
import com.mobilebulletin.request.department.GetDepartmentsByCompanyIdRequest;
import com.mobilebulletin.request.department.ImportDepartmentFromExcelRequest;
import com.mobilebulletin.request.department.UpdateDepartmentInfoRequest;
import com.mobilebulletin.request.department.UpdateDepartmentMembersRequest;
import com.mobilebulletin.response.department.AddDepartmentReply;
import com.mobilebulletin.response.department.GetDepartmentByIdReply;
import com.mobilebulletin.response.department.GetDepartmentsByCompanyIdReply;
import com.mobilebulletin.response.department.ImportDepartmentFromExcelReply;
import com.mobilebulletin.response.department.UpdateDepartmentInfoReply;
import com.mobilebulletin.response.department.UpdateDepartmentMembersReply;




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
	


          public AddDepartmentReply addDepartment(AddDepartmentRequest request) throws Exception;

          public UpdateDepartmentMembersReply updateDepartmentMembers(UpdateDepartmentMembersRequest request) throws Exception;

          public UpdateDepartmentInfoReply updateDepartmentInfo(UpdateDepartmentInfoRequest request) throws Exception;

          public GetDepartmentByIdReply getDepartmentById(GetDepartmentByIdRequest request) throws Exception;

          public ImportDepartmentFromExcelReply importDepartmentFromExcel(ImportDepartmentFromExcelRequest request) throws Exception;
          
          public GetDepartmentsByCompanyIdReply getDepartmentsByCompanyId(GetDepartmentsByCompanyIdRequest request) throws Exception;
}	  


