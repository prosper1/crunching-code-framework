/**
 * GetDepartmentByIdRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.department;

public class GetDepartmentByIdRequest  extends com.mobilebulletin.remote.department.CommonRequest  implements java.io.Serializable {
    private java.lang.String departmentId;

    public GetDepartmentByIdRequest() {
    }

    public GetDepartmentByIdRequest(
           java.lang.String requestCellNumber,
           java.lang.String requestClientName,
           java.lang.String requestCompanyId,
           java.lang.String requestUserId,
           java.lang.String departmentId) {
        super(
            requestCellNumber,
            requestClientName,
            requestCompanyId,
            requestUserId);
        this.departmentId = departmentId;
    }


    /**
     * Gets the departmentId value for this GetDepartmentByIdRequest.
     * 
     * @return departmentId
     */
    public java.lang.String getDepartmentId() {
        return departmentId;
    }


    /**
     * Sets the departmentId value for this GetDepartmentByIdRequest.
     * 
     * @param departmentId
     */
    public void setDepartmentId(java.lang.String departmentId) {
        this.departmentId = departmentId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDepartmentByIdRequest)) return false;
        GetDepartmentByIdRequest other = (GetDepartmentByIdRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.departmentId==null && other.getDepartmentId()==null) || 
             (this.departmentId!=null &&
              this.departmentId.equals(other.getDepartmentId())));
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
        if (getDepartmentId() != null) {
            _hashCode += getDepartmentId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDepartmentByIdRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "getDepartmentByIdRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
