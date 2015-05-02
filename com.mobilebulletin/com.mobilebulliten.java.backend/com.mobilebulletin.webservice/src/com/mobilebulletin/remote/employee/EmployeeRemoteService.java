/**
 * EmployeeRemoteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.employee;

public interface EmployeeRemoteService extends java.rmi.Remote {
    public com.mobilebulletin.remote.employee.AddEmployeeResponse addEmployee(com.mobilebulletin.remote.employee.AddEmployeeRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse getEmployeesFromCompany(com.mobilebulletin.remote.employee.GetEmployeesFromCompanyRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.employee.ImportEmployeesResponse importEmployees(com.mobilebulletin.remote.employee.ImportEmployeesRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.employee.GetEmployeeByIdResponse getEmployeeById(com.mobilebulletin.remote.employee.GetEmployeeByIdRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.employee.UpdateEmployeeResponse updateEmployee(com.mobilebulletin.remote.employee.UpdateEmployeeRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse importEmployeesFromDatabase(com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.employee.RemoveEmployeeResponse removeEmployee(com.mobilebulletin.remote.employee.RemoveEmployeeRequest arg0) throws java.rmi.RemoteException;
}
