/**
 * DepartmentRemoteBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.department;

public class DepartmentRemoteBeanServiceLocator extends org.apache.axis.client.Service implements com.mobilebulletin.remote.department.DepartmentRemoteBeanService {

    public DepartmentRemoteBeanServiceLocator() {
    }


    public DepartmentRemoteBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DepartmentRemoteBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DepartmentRemoteBeanPort
    private java.lang.String DepartmentRemoteBeanPort_address = "http://localhost:8080/com.mobilebulletin.remote.service/DepartmentRemoteBean";

    public java.lang.String getDepartmentRemoteBeanPortAddress() {
        return DepartmentRemoteBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DepartmentRemoteBeanPortWSDDServiceName = "DepartmentRemoteBeanPort";

    public java.lang.String getDepartmentRemoteBeanPortWSDDServiceName() {
        return DepartmentRemoteBeanPortWSDDServiceName;
    }

    public void setDepartmentRemoteBeanPortWSDDServiceName(java.lang.String name) {
        DepartmentRemoteBeanPortWSDDServiceName = name;
    }

    public com.mobilebulletin.remote.department.DepartmentRemoteService getDepartmentRemoteBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DepartmentRemoteBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDepartmentRemoteBeanPort(endpoint);
    }

    public com.mobilebulletin.remote.department.DepartmentRemoteService getDepartmentRemoteBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mobilebulletin.remote.department.DepartmentRemoteBeanServiceSoapBindingStub _stub = new com.mobilebulletin.remote.department.DepartmentRemoteBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getDepartmentRemoteBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDepartmentRemoteBeanPortEndpointAddress(java.lang.String address) {
        DepartmentRemoteBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mobilebulletin.remote.department.DepartmentRemoteService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mobilebulletin.remote.department.DepartmentRemoteBeanServiceSoapBindingStub _stub = new com.mobilebulletin.remote.department.DepartmentRemoteBeanServiceSoapBindingStub(new java.net.URL(DepartmentRemoteBeanPort_address), this);
                _stub.setPortName(getDepartmentRemoteBeanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DepartmentRemoteBeanPort".equals(inputPortName)) {
            return getDepartmentRemoteBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "DepartmentRemoteBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "DepartmentRemoteBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DepartmentRemoteBeanPort".equals(portName)) {
            setDepartmentRemoteBeanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
