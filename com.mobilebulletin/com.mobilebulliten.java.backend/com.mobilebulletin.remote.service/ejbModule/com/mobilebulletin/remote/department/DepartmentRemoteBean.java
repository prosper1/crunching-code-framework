package com.mobilebulletin.remote.department;



import com.mobilebulletin.jms.department.DepartmentRequestQueue;

import javax.ejb.Stateless;



import javax.jws.WebService;

import com.mobilebulletin.request.department.*;
import com.mobilebulletin.response.department.*;




/***************************************************************************************************
 *                                                                                                  
 * @author DepartmentRemoteUtil                                                              
 *
 * This class is used for all the Department beans for EJB Remote purposes.
 * This is the Bean class 
 ***************************************************************************************************/



@WebService(endpointInterface = "com.mobilebulletin.remote.department.DepartmentRemoteService")
@Stateless
public class DepartmentRemoteBean implements DepartmentRemoteService
{


    public AddDepartmentResponse addDepartment(AddDepartmentRequest request) throws Exception{
	    AddDepartmentResponse response = new AddDepartmentResponse();
		
		try
		{
			response = (AddDepartmentResponse) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateDepartmentMembersResponse updateDepartmentMembers(UpdateDepartmentMembersRequest request) throws Exception{
	    UpdateDepartmentMembersResponse response = new UpdateDepartmentMembersResponse();
		
		try
		{
			response = (UpdateDepartmentMembersResponse) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateDepartmentInfoResponse updateDepartmentInfo(UpdateDepartmentInfoRequest request) throws Exception{
	    UpdateDepartmentInfoResponse response = new UpdateDepartmentInfoResponse();
		
		try
		{
			response = (UpdateDepartmentInfoResponse) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetDepartmentByIdResponse getDepartmentById(GetDepartmentByIdRequest request) throws Exception{
	    GetDepartmentByIdResponse response = new GetDepartmentByIdResponse();
		
		try
		{
			response = (GetDepartmentByIdResponse) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportDepartmentFromExcelResponse importDepartmentFromExcel(ImportDepartmentFromExcelRequest request) throws Exception{
	    ImportDepartmentFromExcelResponse response = new ImportDepartmentFromExcelResponse();
		
		try
		{
			response = (ImportDepartmentFromExcelResponse) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }

	@Override
	public GetDepartmentsByCompanyIdResponse getDepartmentsByCompanyId(
			GetDepartmentsByCompanyIdRequest request) throws Exception {
		GetDepartmentsByCompanyIdResponse response = new GetDepartmentsByCompanyIdResponse();
		
		try
		{
			response = (GetDepartmentsByCompanyIdResponse) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}	  
}	  


