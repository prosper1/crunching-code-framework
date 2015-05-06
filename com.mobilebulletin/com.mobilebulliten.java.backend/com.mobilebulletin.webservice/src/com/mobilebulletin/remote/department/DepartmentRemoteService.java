/**
 * DepartmentRemoteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.department;

public interface DepartmentRemoteService extends java.rmi.Remote {
    public com.mobilebulletin.remote.department.GetDepartmentByIdResponse getDepartmentById(com.mobilebulletin.remote.department.GetDepartmentByIdRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.department.UpdateDepartmentMembersResponse updateDepartmentMembers(com.mobilebulletin.remote.department.UpdateDepartmentMembersRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.department.UpdateDepartmentInfoResponse updateDepartmentInfo(com.mobilebulletin.remote.department.UpdateDepartmentInfoRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.department.ImportDepartmentFromExcelResponse importDepartmentFromExcel(com.mobilebulletin.remote.department.ImportDepartmentFromExcelRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.department.AddDepartmentResponse addDepartment(com.mobilebulletin.remote.department.AddDepartmentRequest arg0) throws java.rmi.RemoteException;
}
