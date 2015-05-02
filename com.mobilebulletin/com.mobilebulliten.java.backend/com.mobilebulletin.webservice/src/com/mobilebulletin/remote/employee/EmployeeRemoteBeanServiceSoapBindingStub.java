/**
 * EmployeeRemoteBeanServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.employee;

public class EmployeeRemoteBeanServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.mobilebulletin.remote.employee.EmployeeRemoteService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addEmployee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "addEmployeeRequest"), com.mobilebulletin.remote.employee.AddEmployeeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "addEmployeeResponse"));
        oper.setReturnClass(com.mobilebulletin.remote.employee.AddEmployeeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEmployeesFromCompany");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeesFromCompanyRequest"), com.mobilebulletin.remote.employee.GetEmployeesFromCompanyRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeesFromCompanyResponse"));
        oper.setReturnClass(com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("importEmployees");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesRequest"), com.mobilebulletin.remote.employee.ImportEmployeesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesResponse"));
        oper.setReturnClass(com.mobilebulletin.remote.employee.ImportEmployeesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEmployeeById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeeByIdRequest"), com.mobilebulletin.remote.employee.GetEmployeeByIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeeByIdResponse"));
        oper.setReturnClass(com.mobilebulletin.remote.employee.GetEmployeeByIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateEmployee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "updateEmployeeRequest"), com.mobilebulletin.remote.employee.UpdateEmployeeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "updateEmployeeResponse"));
        oper.setReturnClass(com.mobilebulletin.remote.employee.UpdateEmployeeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("importEmployeesFromDatabase");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesFromDatabaseRequest"), com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesFromDatabaseResponse"));
        oper.setReturnClass(com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("removeEmployee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "removeEmployeeRequest"), com.mobilebulletin.remote.employee.RemoveEmployeeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "removeEmployeeResponse"));
        oper.setReturnClass(com.mobilebulletin.remote.employee.RemoveEmployeeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

    }

    public EmployeeRemoteBeanServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public EmployeeRemoteBeanServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public EmployeeRemoteBeanServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "addEmployeeRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.AddEmployeeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "addEmployeeResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.AddEmployeeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "commonRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.CommonRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeeByIdRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.GetEmployeeByIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeeByIdResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.GetEmployeeByIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeesFromCompanyRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.GetEmployeesFromCompanyRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeesFromCompanyResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesFromDatabaseRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesFromDatabaseResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.ImportEmployeesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.ImportEmployeesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "lookup");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.Lookup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "removeEmployeeRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.RemoveEmployeeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "removeEmployeeResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.RemoveEmployeeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "servresponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.Servresponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "systemSuperResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.SystemSuperResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "updateEmployeeRequest");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.UpdateEmployeeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "updateEmployeeResponse");
            cachedSerQNames.add(qName);
            cls = com.mobilebulletin.remote.employee.UpdateEmployeeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.mobilebulletin.remote.employee.AddEmployeeResponse addEmployee(com.mobilebulletin.remote.employee.AddEmployeeRequest arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "addEmployee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.mobilebulletin.remote.employee.AddEmployeeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.mobilebulletin.remote.employee.AddEmployeeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.mobilebulletin.remote.employee.AddEmployeeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse getEmployeesFromCompany(com.mobilebulletin.remote.employee.GetEmployeesFromCompanyRequest arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeesFromCompany"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.mobilebulletin.remote.employee.GetEmployeesFromCompanyResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.mobilebulletin.remote.employee.ImportEmployeesResponse importEmployees(com.mobilebulletin.remote.employee.ImportEmployeesRequest arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployees"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.mobilebulletin.remote.employee.ImportEmployeesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.mobilebulletin.remote.employee.ImportEmployeesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.mobilebulletin.remote.employee.ImportEmployeesResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.mobilebulletin.remote.employee.GetEmployeeByIdResponse getEmployeeById(com.mobilebulletin.remote.employee.GetEmployeeByIdRequest arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeeById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.mobilebulletin.remote.employee.GetEmployeeByIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.mobilebulletin.remote.employee.GetEmployeeByIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.mobilebulletin.remote.employee.GetEmployeeByIdResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.mobilebulletin.remote.employee.UpdateEmployeeResponse updateEmployee(com.mobilebulletin.remote.employee.UpdateEmployeeRequest arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "updateEmployee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.mobilebulletin.remote.employee.UpdateEmployeeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.mobilebulletin.remote.employee.UpdateEmployeeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.mobilebulletin.remote.employee.UpdateEmployeeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse importEmployeesFromDatabase(com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseRequest arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "importEmployeesFromDatabase"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.mobilebulletin.remote.employee.ImportEmployeesFromDatabaseResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.mobilebulletin.remote.employee.RemoveEmployeeResponse removeEmployee(com.mobilebulletin.remote.employee.RemoveEmployeeRequest arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "removeEmployee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.mobilebulletin.remote.employee.RemoveEmployeeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.mobilebulletin.remote.employee.RemoveEmployeeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.mobilebulletin.remote.employee.RemoveEmployeeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
