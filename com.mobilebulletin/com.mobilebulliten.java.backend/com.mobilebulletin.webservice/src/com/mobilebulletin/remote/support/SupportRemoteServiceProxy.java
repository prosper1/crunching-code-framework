package com.mobilebulletin.remote.support;

public class SupportRemoteServiceProxy implements com.mobilebulletin.remote.support.SupportRemoteService {
  private String _endpoint = null;
  private com.mobilebulletin.remote.support.SupportRemoteService supportRemoteService = null;
  
  public SupportRemoteServiceProxy() {
    _initSupportRemoteServiceProxy();
  }
  
  public SupportRemoteServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSupportRemoteServiceProxy();
  }
  
  private void _initSupportRemoteServiceProxy() {
    try {
      supportRemoteService = (new com.mobilebulletin.remote.support.SupportRemoteBeanServiceLocator()).getSupportRemoteBeanPort();
      if (supportRemoteService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)supportRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)supportRemoteService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (supportRemoteService != null)
      ((javax.xml.rpc.Stub)supportRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mobilebulletin.remote.support.SupportRemoteService getSupportRemoteService() {
    if (supportRemoteService == null)
      _initSupportRemoteServiceProxy();
    return supportRemoteService;
  }
  
  public com.mobilebulletin.remote.support.GetSupportTicketByIdResponse getSupportTicketById(com.mobilebulletin.remote.support.GetSupportTicketByIdRequest arg0) throws java.rmi.RemoteException{
    if (supportRemoteService == null)
      _initSupportRemoteServiceProxy();
    return supportRemoteService.getSupportTicketById(arg0);
  }
  
  public com.mobilebulletin.remote.support.AddGuestSupportQueryResponse addGuestSupportQuery(com.mobilebulletin.remote.support.AddGuestSupportQueryRequest arg0) throws java.rmi.RemoteException{
    if (supportRemoteService == null)
      _initSupportRemoteServiceProxy();
    return supportRemoteService.addGuestSupportQuery(arg0);
  }
  
  public com.mobilebulletin.remote.support.GetSupportTicketsByStatusResponse getSupportTicketsByStatus(com.mobilebulletin.remote.support.GetSupportTicketsByStatusRequest arg0) throws java.rmi.RemoteException{
    if (supportRemoteService == null)
      _initSupportRemoteServiceProxy();
    return supportRemoteService.getSupportTicketsByStatus(arg0);
  }
  
  public com.mobilebulletin.remote.support.AddUserSupportQueryResponse addUserSupportQuery(com.mobilebulletin.remote.support.AddUserSupportQueryRequest arg0) throws java.rmi.RemoteException{
    if (supportRemoteService == null)
      _initSupportRemoteServiceProxy();
    return supportRemoteService.addUserSupportQuery(arg0);
  }
  
  public com.mobilebulletin.remote.support.UpdateSupportQueryResponse updateSupportQuery(com.mobilebulletin.remote.support.UpdateSupportQueryRequest arg0) throws java.rmi.RemoteException{
    if (supportRemoteService == null)
      _initSupportRemoteServiceProxy();
    return supportRemoteService.updateSupportQuery(arg0);
  }
  
  public com.mobilebulletin.remote.support.GetSupportStartUpResponse getSupportStartUp(com.mobilebulletin.remote.support.GetSupportStartUpRequest arg0) throws java.rmi.RemoteException{
    if (supportRemoteService == null)
      _initSupportRemoteServiceProxy();
    return supportRemoteService.getSupportStartUp(arg0);
  }
  
  
}