/**
 * UpdateSupportQueryRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.support;

public class UpdateSupportQueryRequest  extends com.mobilebulletin.remote.support.CommonRequest  implements java.io.Serializable {
    private java.lang.String supportComment;

    private java.lang.String supportId;

    private java.lang.String supportStatus;

    public UpdateSupportQueryRequest() {
    }

    public UpdateSupportQueryRequest(
           java.lang.String requestCellNumber,
           java.lang.String requestClientName,
           java.lang.String requestCompanyId,
           java.lang.String requestUserId,
           java.lang.String supportComment,
           java.lang.String supportId,
           java.lang.String supportStatus) {
        super(
            requestCellNumber,
            requestClientName,
            requestCompanyId,
            requestUserId);
        this.supportComment = supportComment;
        this.supportId = supportId;
        this.supportStatus = supportStatus;
    }


    /**
     * Gets the supportComment value for this UpdateSupportQueryRequest.
     * 
     * @return supportComment
     */
    public java.lang.String getSupportComment() {
        return supportComment;
    }


    /**
     * Sets the supportComment value for this UpdateSupportQueryRequest.
     * 
     * @param supportComment
     */
    public void setSupportComment(java.lang.String supportComment) {
        this.supportComment = supportComment;
    }


    /**
     * Gets the supportId value for this UpdateSupportQueryRequest.
     * 
     * @return supportId
     */
    public java.lang.String getSupportId() {
        return supportId;
    }


    /**
     * Sets the supportId value for this UpdateSupportQueryRequest.
     * 
     * @param supportId
     */
    public void setSupportId(java.lang.String supportId) {
        this.supportId = supportId;
    }


    /**
     * Gets the supportStatus value for this UpdateSupportQueryRequest.
     * 
     * @return supportStatus
     */
    public java.lang.String getSupportStatus() {
        return supportStatus;
    }


    /**
     * Sets the supportStatus value for this UpdateSupportQueryRequest.
     * 
     * @param supportStatus
     */
    public void setSupportStatus(java.lang.String supportStatus) {
        this.supportStatus = supportStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateSupportQueryRequest)) return false;
        UpdateSupportQueryRequest other = (UpdateSupportQueryRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.supportComment==null && other.getSupportComment()==null) || 
             (this.supportComment!=null &&
              this.supportComment.equals(other.getSupportComment()))) &&
            ((this.supportId==null && other.getSupportId()==null) || 
             (this.supportId!=null &&
              this.supportId.equals(other.getSupportId()))) &&
            ((this.supportStatus==null && other.getSupportStatus()==null) || 
             (this.supportStatus!=null &&
              this.supportStatus.equals(other.getSupportStatus())));
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
        if (getSupportComment() != null) {
            _hashCode += getSupportComment().hashCode();
        }
        if (getSupportId() != null) {
            _hashCode += getSupportId().hashCode();
        }
        if (getSupportStatus() != null) {
            _hashCode += getSupportStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateSupportQueryRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://support.remote.mobilebulletin.com/", "updateSupportQueryRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportComment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supportComment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supportId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supportStatus"));
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
