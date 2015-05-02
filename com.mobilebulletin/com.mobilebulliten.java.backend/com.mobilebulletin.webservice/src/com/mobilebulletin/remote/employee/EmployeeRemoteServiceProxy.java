package com.mobilebulletin.remote.employee;

public class EmployeeRemoteServiceProxy implements com.mobilebulletin.remote.employee.EmployeeRemoteService {
  private String _endpoint = null;
  private com.mobilebulletin.remote.employee.EmployeeRemoteService employeeRemoteService = null;
  
  public EmployeeRemoteServiceProxy() {
    _initEmployeeRemoteServiceProxy();
  }
  
  public EmployeeRemoteServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeRemoteServiceProxy();
  }
  
  private void _initEmployeeRemoteServiceProxy() {
    try {
      employeeRemoteService = (new com.mobilebulletin.remote.employee.EmployeeRemoteBeanServiceLocator()).getEmployeeRemoteBeanPort();
      if (employeeRemoteService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeRemoteService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeRemoteService != null)
      ((javax.xml.rpc.Stub)employeeRemoteService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mobilebulletin.remote.employee.EmployeeRemoteService getEmployeeRemoteService() {
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService;
  }
  
  public com.mobilebulletin.remote.employee.AddEmployeeResponse addEmployee(com.mobilebulletin.remote.employee.AddEmployeeRequest arg0) throws java.rmi.RemoteException{
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService.addEmployee(arg0);
  }
  
  public com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse getEmployeesFromCompany(com.mobilebulletin.remote.employee.GetEmployeesFromCompanyRequest arg0) throws java.rmi.RemoteException{
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService.getEmployeesFromCompany(arg0);
  }
  
  public com.mobilebulletin.remote.employee.ImportEmployeesResponse importEmployees(com.mobilebulletin.remote.employee.ImportEmployeesRequest arg0) throws java.rmi.RemoteException{
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService.importEmployees(arg0);
  }
  
  public com.mobilebulletin.remote.employee.GetEmployeeByIdResponse getEmployeeById(com.mobilebulletin.remote.employee.GetEmployeeByIdRequest arg0) throws java.rmi.RemoteException{
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService.getEmployeeById(arg0);
  }
  
  public com.mobilebulletin.remote.employee.UpdateEmployeeResponse updateEmployee(com.mobilebulletin.remote.employee.UpdateEmployeeRequest arg0) throws java.rmi.RemoteException{
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService.updateEmployee(arg0);
  }
  
  public com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse importEmployeesFromDatabase(com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseRequest arg0) throws java.rmi.RemoteException{
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService.importEmployeesFromDatabase(arg0);
  }
  
  public com.mobilebulletin.remote.employee.RemoveEmployeeResponse removeEmployee(com.mobilebulletin.remote.employee.RemoveEmployeeRequest arg0) throws java.rmi.RemoteException{
    if (employeeRemoteService == null)
      _initEmployeeRemoteServiceProxy();
    return employeeRemoteService.removeEmployee(arg0);
  }
  
  
}