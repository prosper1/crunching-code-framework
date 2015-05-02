/**
 * AddUserSupportQueryRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.support;

public class AddUserSupportQueryRequest  extends com.mobilebulletin.remote.support.CommonRequest  implements java.io.Serializable {
    private java.lang.String heading;

    private java.lang.String supportContent;

    private java.lang.String supportModule;

    public AddUserSupportQueryRequest() {
    }

    public AddUserSupportQueryRequest(
           java.lang.String requestCellNumber,
           java.lang.String requestClientName,
           java.lang.String requestCompanyId,
           java.lang.String requestUserId,
           java.lang.String heading,
           java.lang.String supportContent,
           java.lang.String supportModule) {
        super(
            requestCellNumber,
            requestClientName,
            requestCompanyId,
            requestUserId);
        this.heading = heading;
        this.supportContent = supportContent;
        this.supportModule = supportModule;
    }


    /**
     * Gets the heading value for this AddUserSupportQueryRequest.
     * 
     * @return heading
     */
    public java.lang.String getHeading() {
        return heading;
    }


    /**
     * Sets the heading value for this AddUserSupportQueryRequest.
     * 
     * @param heading
     */
    public void setHeading(java.lang.String heading) {
        this.heading = heading;
    }


    /**
     * Gets the supportContent value for this AddUserSupportQueryRequest.
     * 
     * @return supportContent
     */
    public java.lang.String getSupportContent() {
        return supportContent;
    }


    /**
     * Sets the supportContent value for this AddUserSupportQueryRequest.
     * 
     * @param supportContent
     */
    public void setSupportContent(java.lang.String supportContent) {
        this.supportContent = supportContent;
    }


    /**
     * Gets the supportModule value for this AddUserSupportQueryRequest.
     * 
     * @return supportModule
     */
    public java.lang.String getSupportModule() {
        return supportModule;
    }


    /**
     * Sets the supportModule value for this AddUserSupportQueryRequest.
     * 
     * @param supportModule
     */
    public void setSupportModule(java.lang.String supportModule) {
        this.supportModule = supportModule;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddUserSupportQueryRequest)) return false;
        AddUserSupportQueryRequest other = (AddUserSupportQueryRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.heading==null && other.getHeading()==null) || 
             (this.heading!=null &&
              this.heading.equals(other.getHeading()))) &&
            ((this.supportContent==null && other.getSupportContent()==null) || 
             (this.supportContent!=null &&
              this.supportContent.equals(other.getSupportContent()))) &&
            ((this.supportModule==null && other.getSupportModule()==null) || 
             (this.supportModule!=null &&
              this.supportModule.equals(other.getSupportModule())));
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
        if (getHeading() != null) {
            _hashCode += getHeading().hashCode();
        }
        if (getSupportContent() != null) {
            _hashCode += getSupportContent().hashCode();
        }
        if (getSupportModule() != null) {
            _hashCode += getSupportModule().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddUserSupportQueryRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://support.remote.mobilebulletin.com/", "addUserSupportQueryRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("heading");
        elemField.setXmlName(new javax.xml.namespace.QName("", "heading"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supportContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supportModule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supportModule"));
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
