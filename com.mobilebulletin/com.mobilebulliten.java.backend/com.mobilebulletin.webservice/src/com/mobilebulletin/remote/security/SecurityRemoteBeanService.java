/**
 * SecurityRemoteBeanService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.security;

public interface SecurityRemoteBeanService extends javax.xml.rpc.Service {
    public java.lang.String getSecurityRemoteBeanPortAddress();

    public com.mobilebulletin.remote.security.SecurityRemoteService getSecurityRemoteBeanPort() throws javax.xml.rpc.ServiceException;

    public com.mobilebulletin.remote.security.SecurityRemoteService getSecurityRemoteBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
