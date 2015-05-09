package com.mobilebulletin.remote.group;

public class GroupRemoteServiceProxy implements com.mobilebulletin.remote.group.GroupRemoteService {
  private String _endpoint = null;
  private com.mobilebulletin.remote.group.GroupRemoteService groupRemoteService = null;
  
  public GroupRemoteServiceProxy() {
    _initGroupRemoteServiceProxy();
  }
  
  public GroupRemoteServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initGroupRemoteServiceProxy();
  }
  
  private void _initGroupRemoteServiceProxy() {
    try {
      groupRemoteService = (new com.mobilebulletin.remote.group.GroupRemoteBeanServiceLocator()).getGroupRemoteBeanPort();
      if (groupRemoteService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)groupRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)groupRemoteService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (groupRemoteService != null)
      ((javax.xml.rpc.Stub)groupRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mobilebulletin.remote.group.GroupRemoteService getGroupRemoteService() {
    if (groupRemoteService == null)
      _initGroupRemoteServiceProxy();
    return groupRemoteService;
  }
  
  public com.mobilebulletin.remote.group.AddGroupResponse addGroup(com.mobilebulletin.remote.group.AddGroupRequest arg0) throws java.rmi.RemoteException{
    if (groupRemoteService == null)
      _initGroupRemoteServiceProxy();
    return groupRemoteService.addGroup(arg0);
  }
  
  public com.mobilebulletin.remote.group.UpdateGroupInfoResponse updateGroupInfo(com.mobilebulletin.remote.group.UpdateGroupInfoRequest arg0) throws java.rmi.RemoteException{
    if (groupRemoteService == null)
      _initGroupRemoteServiceProxy();
    return groupRemoteService.updateGroupInfo(arg0);
  }
  
  public com.mobilebulletin.remote.group.UpdateGroupMembersResponse updateGroupMembers(com.mobilebulletin.remote.group.UpdateGroupMembersRequest arg0) throws java.rmi.RemoteException{
    if (groupRemoteService == null)
      _initGroupRemoteServiceProxy();
    return groupRemoteService.updateGroupMembers(arg0);
  }
  
  public com.mobilebulletin.remote.group.ImportGroupFromExcelResponse importGroupFromExcel(com.mobilebulletin.remote.group.ImportGroupFromExcelRequest arg0) throws java.rmi.RemoteException{
    if (groupRemoteService == null)
      _initGroupRemoteServiceProxy();
    return groupRemoteService.importGroupFromExcel(arg0);
  }
  
  public com.mobilebulletin.remote.group.GetGroupByIdResponse getGroupById(com.mobilebulletin.remote.group.GetGroupByIdRequest arg0) throws java.rmi.RemoteException{
    if (groupRemoteService == null)
      _initGroupRemoteServiceProxy();
    return groupRemoteService.getGroupById(arg0);
  }
  
  public com.mobilebulletin.remote.group.GetGroupsByCompanyIdResponse getGroupsByCompanyId(com.mobilebulletin.remote.group.GetGroupsByCompanyIdRequest arg0) throws java.rmi.RemoteException{
    if (groupRemoteService == null)
      _initGroupRemoteServiceProxy();
    return groupRemoteService.getGroupsByCompanyId(arg0);
  }
  
  
}