/**
 * GetDepartmentByIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.department;

public class GetDepartmentByIdResponse  extends com.mobilebulletin.remote.department.SystemSuperResponse  implements java.io.Serializable {
    private com.mobilebulletin.remote.department.DepartmentInfo departmentInfo;

    public GetDepartmentByIdResponse() {
    }

    public GetDepartmentByIdResponse(
           com.mobilebulletin.remote.department.Servresponse response,
           java.lang.String responseTo,
           java.lang.String servValidation,
           com.mobilebulletin.remote.department.DepartmentInfo departmentInfo) {
        super(
            response,
            responseTo,
            servValidation);
        this.departmentInfo = departmentInfo;
    }


    /**
     * Gets the departmentInfo value for this GetDepartmentByIdResponse.
     * 
     * @return departmentInfo
     */
    public com.mobilebulletin.remote.department.DepartmentInfo getDepartmentInfo() {
        return departmentInfo;
    }


    /**
     * Sets the departmentInfo value for this GetDepartmentByIdResponse.
     * 
     * @param departmentInfo
     */
    public void setDepartmentInfo(com.mobilebulletin.remote.department.DepartmentInfo departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDepartmentByIdResponse)) return false;
        GetDepartmentByIdResponse other = (GetDepartmentByIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.departmentInfo==null && other.getDepartmentInfo()==null) || 
             (this.departmentInfo!=null &&
              this.departmentInfo.equals(other.getDepartmentInfo())));
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
        if (getDepartmentInfo() != null) {
            _hashCode += getDepartmentInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDepartmentByIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "getDepartmentByIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "departmentInfo"));
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
