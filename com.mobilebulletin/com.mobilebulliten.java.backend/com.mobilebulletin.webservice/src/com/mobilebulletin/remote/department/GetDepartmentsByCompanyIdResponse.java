/**
 * GetDepartmentsByCompanyIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.department;

public class GetDepartmentsByCompanyIdResponse  extends com.mobilebulletin.remote.department.SystemSuperResponse  implements java.io.Serializable {
    private com.mobilebulletin.remote.department.LightDepartmentInfo[] departmentInfoList;

    public GetDepartmentsByCompanyIdResponse() {
    }

    public GetDepartmentsByCompanyIdResponse(
           com.mobilebulletin.remote.department.Servresponse response,
           java.lang.String responseTo,
           java.lang.String servValidation,
           com.mobilebulletin.remote.department.LightDepartmentInfo[] departmentInfoList) {
        super(
            response,
            responseTo,
            servValidation);
        this.departmentInfoList = departmentInfoList;
    }


    /**
     * Gets the departmentInfoList value for this GetDepartmentsByCompanyIdResponse.
     * 
     * @return departmentInfoList
     */
    public com.mobilebulletin.remote.department.LightDepartmentInfo[] getDepartmentInfoList() {
        return departmentInfoList;
    }


    /**
     * Sets the departmentInfoList value for this GetDepartmentsByCompanyIdResponse.
     * 
     * @param departmentInfoList
     */
    public void setDepartmentInfoList(com.mobilebulletin.remote.department.LightDepartmentInfo[] departmentInfoList) {
        this.departmentInfoList = departmentInfoList;
    }

    public com.mobilebulletin.remote.department.LightDepartmentInfo getDepartmentInfoList(int i) {
        return this.departmentInfoList[i];
    }

    public void setDepartmentInfoList(int i, com.mobilebulletin.remote.department.LightDepartmentInfo _value) {
        this.departmentInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDepartmentsByCompanyIdResponse)) return false;
        GetDepartmentsByCompanyIdResponse other = (GetDepartmentsByCompanyIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.departmentInfoList==null && other.getDepartmentInfoList()==null) || 
             (this.departmentInfoList!=null &&
              java.util.Arrays.equals(this.departmentInfoList, other.getDepartmentInfoList())));
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
        if (getDepartmentInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDepartmentInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDepartmentInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(GetDepartmentsByCompanyIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "getDepartmentsByCompanyIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "lightDepartmentInfo"));
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
