/**
 * GetEmployeesFromCompanyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.employee;

public class GetEmployeesFromCompanyResponse  extends com.mobilebulletin.remote.employee.SystemSuperResponse  implements java.io.Serializable {
    private com.mobilebulletin.remote.employee.EmployeeInfo[] employeeInfoList;

    public GetEmployeesFromCompanyResponse() {
    }

    public GetEmployeesFromCompanyResponse(
           com.mobilebulletin.remote.employee.Servresponse response,
           java.lang.String responseTo,
           java.lang.String servValidation,
           com.mobilebulletin.remote.employee.EmployeeInfo[] employeeInfoList) {
        super(
            response,
            responseTo,
            servValidation);
        this.employeeInfoList = employeeInfoList;
    }


    /**
     * Gets the employeeInfoList value for this GetEmployeesFromCompanyResponse.
     * 
     * @return employeeInfoList
     */
    public com.mobilebulletin.remote.employee.EmployeeInfo[] getEmployeeInfoList() {
        return employeeInfoList;
    }


    /**
     * Sets the employeeInfoList value for this GetEmployeesFromCompanyResponse.
     * 
     * @param employeeInfoList
     */
    public void setEmployeeInfoList(com.mobilebulletin.remote.employee.EmployeeInfo[] employeeInfoList) {
        this.employeeInfoList = employeeInfoList;
    }

    public com.mobilebulletin.remote.employee.EmployeeInfo getEmployeeInfoList(int i) {
        return this.employeeInfoList[i];
    }

    public void setEmployeeInfoList(int i, com.mobilebulletin.remote.employee.EmployeeInfo _value) {
        this.employeeInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeesFromCompanyResponse)) return false;
        GetEmployeesFromCompanyResponse other = (GetEmployeesFromCompanyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.employeeInfoList==null && other.getEmployeeInfoList()==null) || 
             (this.employeeInfoList!=null &&
              java.util.Arrays.equals(this.employeeInfoList, other.getEmployeeInfoList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getEmployeeInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEmployeeInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEmployeeInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeesFromCompanyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "getEmployeesFromCompanyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeeInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://employee.remote.mobilebulletin.com/", "employeeInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
