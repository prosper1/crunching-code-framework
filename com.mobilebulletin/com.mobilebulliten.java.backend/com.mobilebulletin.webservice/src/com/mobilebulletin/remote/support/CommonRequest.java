/**
 * CommonRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.support;

public class CommonRequest  implements java.io.Serializable {
    private java.lang.String requestCellNumber;

    private java.lang.String requestClientName;

    private java.lang.String requestCompanyId;

    private java.lang.String requestUserId;

    public CommonRequest() {
    }

    public CommonRequest(
           java.lang.String requestCellNumber,
           java.lang.String requestClientName,
           java.lang.String requestCompanyId,
           java.lang.String requestUserId) {
           this.requestCellNumber = requestCellNumber;
           this.requestClientName = requestClientName;
           this.requestCompanyId = requestCompanyId;
           this.requestUserId = requestUserId;
    }


    /**
     * Gets the requestCellNumber value for this CommonRequest.
     * 
     * @return requestCellNumber
     */
    public java.lang.String getRequestCellNumber() {
        return requestCellNumber;
    }


    /**
     * Sets the requestCellNumber value for this CommonRequest.
     * 
     * @param requestCellNumber
     */
    public void setRequestCellNumber(java.lang.String requestCellNumber) {
        this.requestCellNumber = requestCellNumber;
    }


    /**
     * Gets the requestClientName value for this CommonRequest.
     * 
     * @return requestClientName
     */
    public java.lang.String getRequestClientName() {
        return requestClientName;
    }


    /**
     * Sets the requestClientName value for this CommonRequest.
     * 
     * @param requestClientName
     */
    public void setRequestClientName(java.lang.String requestClientName) {
        this.requestClientName = requestClientName;
    }


    /**
     * Gets the requestCompanyId value for this CommonRequest.
     * 
     * @return requestCompanyId
     */
    public java.lang.String getRequestCompanyId() {
        return requestCompanyId;
    }


    /**
     * Sets the requestCompanyId value for this CommonRequest.
     * 
     * @param requestCompanyId
     */
    public void setRequestCompanyId(java.lang.String requestCompanyId) {
        this.requestCompanyId = requestCompanyId;
    }


    /**
     * Gets the requestUserId value for this CommonRequest.
     * 
     * @return requestUserId
     */
    public java.lang.String getRequestUserId() {
        return requestUserId;
    }


    /**
     * Sets the requestUserId value for this CommonRequest.
     * 
     * @param requestUserId
     */
    public void setRequestUserId(java.lang.String requestUserId) {
        this.requestUserId = requestUserId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommonRequest)) return false;
        CommonRequest other = (CommonRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.requestCellNumber==null && other.getRequestCellNumber()==null) || 
             (this.requestCellNumber!=null &&
              this.requestCellNumber.equals(other.getRequestCellNumber()))) &&
            ((this.requestClientName==null && other.getRequestClientName()==null) || 
             (this.requestClientName!=null &&
              this.requestClientName.equals(other.getRequestClientName()))) &&
            ((this.requestCompanyId==null && other.getRequestCompanyId()==null) || 
             (this.requestCompanyId!=null &&
              this.requestCompanyId.equals(other.getRequestCompanyId()))) &&
            ((this.requestUserId==null && other.getRequestUserId()==null) || 
             (this.requestUserId!=null &&
              this.requestUserId.equals(other.getRequestUserId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRequestCellNumber() != null) {
            _hashCode += getRequestCellNumber().hashCode();
        }
        if (getRequestClientName() != null) {
            _hashCode += getRequestClientName().hashCode();
        }
        if (getRequestCompanyId() != null) {
            _hashCode += getRequestCompanyId().hashCode();
        }
        if (getRequestUserId() != null) {
            _hashCode += getRequestUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommonRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://support.remote.mobilebulletin.com/", "commonRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestCellNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestCellNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestClientName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestClientName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestCompanyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestCompanyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestUserId"));
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
