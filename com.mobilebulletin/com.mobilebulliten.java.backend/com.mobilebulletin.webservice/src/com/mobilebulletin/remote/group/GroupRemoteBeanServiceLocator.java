/**
 * GroupRemoteBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.group;

public class GroupRemoteBeanServiceLocator extends org.apache.axis.client.Service implements com.mobilebulletin.remote.group.GroupRemoteBeanService {

    public GroupRemoteBeanServiceLocator() {
    }


    public GroupRemoteBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GroupRemoteBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GroupRemoteBeanPort
    private java.lang.String GroupRemoteBeanPort_address = "http://localhost:8080/com.mobilebulletin.remote.service/GroupRemoteBean";

    public java.lang.String getGroupRemoteBeanPortAddress() {
        return GroupRemoteBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GroupRemoteBeanPortWSDDServiceName = "GroupRemoteBeanPort";

    public java.lang.String getGroupRemoteBeanPortWSDDServiceName() {
        return GroupRemoteBeanPortWSDDServiceName;
    }

    public void setGroupRemoteBeanPortWSDDServiceName(java.lang.String name) {
        GroupRemoteBeanPortWSDDServiceName = name;
    }

    public com.mobilebulletin.remote.group.GroupRemoteService getGroupRemoteBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GroupRemoteBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGroupRemoteBeanPort(endpoint);
    }

    public com.mobilebulletin.remote.group.GroupRemoteService getGroupRemoteBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mobilebulletin.remote.group.GroupRemoteBeanServiceSoapBindingStub _stub = new com.mobilebulletin.remote.group.GroupRemoteBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getGroupRemoteBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGroupRemoteBeanPortEndpointAddress(java.lang.String address) {
        GroupRemoteBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mobilebulletin.remote.group.GroupRemoteService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mobilebulletin.remote.group.GroupRemoteBeanServiceSoapBindingStub _stub = new com.mobilebulletin.remote.group.GroupRemoteBeanServiceSoapBindingStub(new java.net.URL(GroupRemoteBeanPort_address), this);
                _stub.setPortName(getGroupRemoteBeanPortWSDDServiceName());
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
        if ("GroupRemoteBeanPort".equals(inputPortName)) {
            return getGroupRemoteBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "GroupRemoteBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "GroupRemoteBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GroupRemoteBeanPort".equals(portName)) {
            setGroupRemoteBeanPortEndpointAddress(address);
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
