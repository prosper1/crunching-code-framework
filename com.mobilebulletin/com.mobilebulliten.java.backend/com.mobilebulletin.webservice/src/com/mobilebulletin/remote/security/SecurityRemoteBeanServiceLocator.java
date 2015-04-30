/**
 * SecurityRemoteBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.security;

public class SecurityRemoteBeanServiceLocator extends org.apache.axis.client.Service implements com.mobilebulletin.remote.security.SecurityRemoteBeanService {

    public SecurityRemoteBeanServiceLocator() {
    }


    public SecurityRemoteBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SecurityRemoteBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SecurityRemoteBeanPort
    private java.lang.String SecurityRemoteBeanPort_address = "http://localhost:8080/com.mobilebulletin.remote.service/SecurityRemoteBean";

    public java.lang.String getSecurityRemoteBeanPortAddress() {
        return SecurityRemoteBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SecurityRemoteBeanPortWSDDServiceName = "SecurityRemoteBeanPort";

    public java.lang.String getSecurityRemoteBeanPortWSDDServiceName() {
        return SecurityRemoteBeanPortWSDDServiceName;
    }

    public void setSecurityRemoteBeanPortWSDDServiceName(java.lang.String name) {
        SecurityRemoteBeanPortWSDDServiceName = name;
    }

    public com.mobilebulletin.remote.security.SecurityRemoteService getSecurityRemoteBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SecurityRemoteBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSecurityRemoteBeanPort(endpoint);
    }

    public com.mobilebulletin.remote.security.SecurityRemoteService getSecurityRemoteBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mobilebulletin.remote.security.SecurityRemoteBeanServiceSoapBindingStub _stub = new com.mobilebulletin.remote.security.SecurityRemoteBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSecurityRemoteBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSecurityRemoteBeanPortEndpointAddress(java.lang.String address) {
        SecurityRemoteBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mobilebulletin.remote.security.SecurityRemoteService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mobilebulletin.remote.security.SecurityRemoteBeanServiceSoapBindingStub _stub = new com.mobilebulletin.remote.security.SecurityRemoteBeanServiceSoapBindingStub(new java.net.URL(SecurityRemoteBeanPort_address), this);
                _stub.setPortName(getSecurityRemoteBeanPortWSDDServiceName());
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
        if ("SecurityRemoteBeanPort".equals(inputPortName)) {
            return getSecurityRemoteBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://security.remote.mobilebulletin.com/", "SecurityRemoteBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://security.remote.mobilebulletin.com/", "SecurityRemoteBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SecurityRemoteBeanPort".equals(portName)) {
            setSecurityRemoteBeanPortEndpointAddress(address);
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
