package com.mobilebulletin.remote.department;



import com.mobilebulletin.jms.department.DepartmentRequestQueue;

import javax.ejb.Stateless;



import javax.jws.HandlerChain;
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


@WebService(serviceName = "MobileBulletin", portName = "DepartmentService", targetNamespace = "mobilebulletin")
@Stateless
public class DepartmentRemoteBean implements DepartmentRemoteService
{


    public AddDepartmentReply addDepartment(AddDepartmentRequest request) throws Exception{
	    AddDepartmentReply response = new AddDepartmentReply();
		
		try
		{
			response = (AddDepartmentReply) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateDepartmentMembersReply updateDepartmentMembers(UpdateDepartmentMembersRequest request) throws Exception{
	    UpdateDepartmentMembersReply response = new UpdateDepartmentMembersReply();
		
		try
		{
			response = (UpdateDepartmentMembersReply) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public UpdateDepartmentInfoReply updateDepartmentInfo(UpdateDepartmentInfoRequest request) throws Exception{
	    UpdateDepartmentInfoReply response = new UpdateDepartmentInfoReply();
		
		try
		{
			response = (UpdateDepartmentInfoReply) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public GetDepartmentByIdReply getDepartmentById(GetDepartmentByIdRequest request) throws Exception{
	    GetDepartmentByIdReply response = new GetDepartmentByIdReply();
		
		try
		{
			response = (GetDepartmentByIdReply) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }	  

    public ImportDepartmentFromExcelReply importDepartmentFromExcel(ImportDepartmentFromExcelRequest request) throws Exception{
	    ImportDepartmentFromExcelReply response = new ImportDepartmentFromExcelReply();
		
		try
		{
			response = (ImportDepartmentFromExcelReply) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
    }

	public GetDepartmentsByCompanyIdReply getDepartmentsByCompanyId(
			GetDepartmentsByCompanyIdRequest request) throws Exception {
		GetDepartmentsByCompanyIdReply response = new GetDepartmentsByCompanyIdReply();
		
		try
		{
			response = (GetDepartmentsByCompanyIdReply) new DepartmentRequestQueue().send2Queue(request);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}	  
}	  


