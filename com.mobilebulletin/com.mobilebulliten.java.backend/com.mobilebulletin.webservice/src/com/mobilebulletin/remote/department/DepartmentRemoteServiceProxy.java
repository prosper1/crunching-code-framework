package com.mobilebulletin.remote.department;

public class DepartmentRemoteServiceProxy implements com.mobilebulletin.remote.department.DepartmentRemoteService {
  private String _endpoint = null;
  private com.mobilebulletin.remote.department.DepartmentRemoteService departmentRemoteService = null;
  
  public DepartmentRemoteServiceProxy() {
    _initDepartmentRemoteServiceProxy();
  }
  
  public DepartmentRemoteServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initDepartmentRemoteServiceProxy();
  }
  
  private void _initDepartmentRemoteServiceProxy() {
    try {
      departmentRemoteService = (new com.mobilebulletin.remote.department.DepartmentRemoteBeanServiceLocator()).getDepartmentRemoteBeanPort();
      if (departmentRemoteService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)departmentRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)departmentRemoteService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (departmentRemoteService != null)
      ((javax.xml.rpc.Stub)departmentRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mobilebulletin.remote.department.DepartmentRemoteService getDepartmentRemoteService() {
    if (departmentRemoteService == null)
      _initDepartmentRemoteServiceProxy();
    return departmentRemoteService;
  }
  
  public com.mobilebulletin.remote.department.GetDepartmentByIdResponse getDepartmentById(com.mobilebulletin.remote.department.GetDepartmentByIdRequest arg0) throws java.rmi.RemoteException{
    if (departmentRemoteService == null)
      _initDepartmentRemoteServiceProxy();
    return departmentRemoteService.getDepartmentById(arg0);
  }
  
  public com.mobilebulletin.remote.department.UpdateDepartmentMembersResponse updateDepartmentMembers(com.mobilebulletin.remote.department.UpdateDepartmentMembersRequest arg0) throws java.rmi.RemoteException{
    if (departmentRemoteService == null)
      _initDepartmentRemoteServiceProxy();
    return departmentRemoteService.updateDepartmentMembers(arg0);
  }
  
  public com.mobilebulletin.remote.department.UpdateDepartmentInfoResponse updateDepartmentInfo(com.mobilebulletin.remote.department.UpdateDepartmentInfoRequest arg0) throws java.rmi.RemoteException{
    if (departmentRemoteService == null)
      _initDepartmentRemoteServiceProxy();
    return departmentRemoteService.updateDepartmentInfo(arg0);
  }
  
  public com.mobilebulletin.remote.department.ImportDepartmentFromExcelResponse importDepartmentFromExcel(com.mobilebulletin.remote.department.ImportDepartmentFromExcelRequest arg0) throws java.rmi.RemoteException{
    if (departmentRemoteService == null)
      _initDepartmentRemoteServiceProxy();
    return departmentRemoteService.importDepartmentFromExcel(arg0);
  }
  
  public com.mobilebulletin.remote.department.AddDepartmentResponse addDepartment(com.mobilebulletin.remote.department.AddDepartmentRequest arg0) throws java.rmi.RemoteException{
    if (departmentRemoteService == null)
      _initDepartmentRemoteServiceProxy();
    return departmentRemoteService.addDepartment(arg0);
  }
  
  public com.mobilebulletin.remote.department.GetDepartmentsByCompanyIdResponse getDepartmentsByCompanyId(com.mobilebulletin.remote.department.GetDepartmentsByCompanyIdRequest arg0) throws java.rmi.RemoteException{
    if (departmentRemoteService == null)
      _initDepartmentRemoteServiceProxy();
    return departmentRemoteService.getDepartmentsByCompanyId(arg0);
  }
  
  
}