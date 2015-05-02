/**
 * EmployeeRemoteBeanService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.employee;

public interface EmployeeRemoteBeanService extends javax.xml.rpc.Service {
    public java.lang.String getEmployeeRemoteBeanPortAddress();

    public com.mobilebulletin.remote.employee.EmployeeRemoteService getEmployeeRemoteBeanPort() throws javax.xml.rpc.ServiceException;

    public com.mobilebulletin.remote.employee.EmployeeRemoteService getEmployeeRemoteBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
