package com.mobilebulletin.remote.security;

public class SecurityRemoteServiceProxy implements com.mobilebulletin.remote.security.SecurityRemoteService {
  private String _endpoint = null;
  private com.mobilebulletin.remote.security.SecurityRemoteService securityRemoteService = null;
  
  public SecurityRemoteServiceProxy() {
    _initSecurityRemoteServiceProxy();
  }
  
  public SecurityRemoteServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSecurityRemoteServiceProxy();
  }
  
  private void _initSecurityRemoteServiceProxy() {
    try {
      securityRemoteService = (new com.mobilebulletin.remote.security.SecurityRemoteBeanServiceLocator()).getSecurityRemoteBeanPort();
      if (securityRemoteService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)securityRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)securityRemoteService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (securityRemoteService != null)
      ((javax.xml.rpc.Stub)securityRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mobilebulletin.remote.security.SecurityRemoteService getSecurityRemoteService() {
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService;
  }
  
  public com.mobilebulletin.remote.security.ActivateAccountResponse activateAccount(com.mobilebulletin.remote.security.ActivateAccountRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.activateAccount(arg0);
  }
  
  public com.mobilebulletin.remote.security.CheckUserResponse checkUser(com.mobilebulletin.remote.security.CheckUserRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.checkUser(arg0);
  }
  
  public com.mobilebulletin.remote.security.GenerateTypesResponse generateTypes(com.mobilebulletin.remote.security.GenerateTypesRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.generateTypes(arg0);
  }
  
  public com.mobilebulletin.remote.security.UpdateUserInfoResponse updateUserInfo(com.mobilebulletin.remote.security.UpdateUserInfoRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.updateUserInfo(arg0);
  }
  
  public com.mobilebulletin.remote.security.SignUpUserResponse signUpUser(com.mobilebulletin.remote.security.SignUpUserRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.signUpUser(arg0);
  }
  
  public com.mobilebulletin.remote.security.GetUserInfoResponse getUserInfo(com.mobilebulletin.remote.security.GetUserInfoRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.getUserInfo(arg0);
  }
  
  public com.mobilebulletin.remote.security.ChangePasswordResponse changePassword(com.mobilebulletin.remote.security.ChangePasswordRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.changePassword(arg0);
  }
  
  public com.mobilebulletin.remote.security.SignInResponse signIn(com.mobilebulletin.remote.security.SignInRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.signIn(arg0);
  }
  
  public com.mobilebulletin.remote.security.ForgotPasswordResponse forgotPassword(com.mobilebulletin.remote.security.ForgotPasswordRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.forgotPassword(arg0);
  }
  
  public com.mobilebulletin.remote.security.UpdateUserRoleResponse updateUserRole(com.mobilebulletin.remote.security.UpdateUserRoleRequest arg0) throws java.rmi.RemoteException{
    if (securityRemoteService == null)
      _initSecurityRemoteServiceProxy();
    return securityRemoteService.updateUserRole(arg0);
  }
  
  
}