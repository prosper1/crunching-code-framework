/**
 * GroupRemoteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.group;

public interface GroupRemoteService extends java.rmi.Remote {
    public com.mobilebulletin.remote.group.GetGroupsByCompanyIdResponse getGroupsByCompanyId(com.mobilebulletin.remote.group.GetGroupsByCompanyIdRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.group.AddGroupResponse addGroup(com.mobilebulletin.remote.group.AddGroupRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.group.UpdateGroupInfoResponse updateGroupInfo(com.mobilebulletin.remote.group.UpdateGroupInfoRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.group.UpdateGroupMembersResponse updateGroupMembers(com.mobilebulletin.remote.group.UpdateGroupMembersRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.group.ImportGroupFromExcelResponse importGroupFromExcel(com.mobilebulletin.remote.group.ImportGroupFromExcelRequest arg0) throws java.rmi.RemoteException;
    public com.mobilebulletin.remote.group.GetGroupByIdResponse getGroupById(com.mobilebulletin.remote.group.GetGroupByIdRequest arg0) throws java.rmi.RemoteException;
}
