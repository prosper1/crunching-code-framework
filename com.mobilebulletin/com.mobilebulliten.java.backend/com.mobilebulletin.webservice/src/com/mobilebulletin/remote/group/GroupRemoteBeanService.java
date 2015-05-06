/**
 * GroupRemoteBeanService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.group;

public interface GroupRemoteBeanService extends javax.xml.rpc.Service {
    public java.lang.String getGroupRemoteBeanPortAddress();

    public com.mobilebulletin.remote.group.GroupRemoteService getGroupRemoteBeanPort() throws javax.xml.rpc.ServiceException;

    public com.mobilebulletin.remote.group.GroupRemoteService getGroupRemoteBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
