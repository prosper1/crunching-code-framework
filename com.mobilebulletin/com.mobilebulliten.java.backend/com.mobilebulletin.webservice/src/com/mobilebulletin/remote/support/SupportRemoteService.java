/**
 * SupportRemoteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.support;

public interface SupportRemoteService extends java.rmi.Remote {
    public com.mobilebulletin.remote.support.GetSupportTicketByIdResponse getSupportTicketById(com.mobilebulletin.remote.support.GetSupportTicketByIdRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.support.AddGuestSupportQueryResponse addGuestSupportQuery(com.mobilebulletin.remote.support.AddGuestSupportQueryRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.support.GetSupportTicketsByStatusResponse getSupportTicketsByStatus(com.mobilebulletin.remote.support.GetSupportTicketsByStatusRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.support.AddUserSupportQueryResponse addUserSupportQuery(com.mobilebulletin.remote.support.AddUserSupportQueryRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.support.UpdateSupportQueryResponse updateSupportQuery(com.mobilebulletin.remote.support.UpdateSupportQueryRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.support.GetSupportStartUpResponse getSupportStartUp(com.mobilebulletin.remote.support.GetSupportStartUpRequest arg0) throws java.rmi.RemoteException;
}
