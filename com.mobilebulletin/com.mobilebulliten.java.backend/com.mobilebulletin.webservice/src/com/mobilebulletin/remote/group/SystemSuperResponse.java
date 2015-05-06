/**
 * SystemSuperResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.group;

public class SystemSuperResponse  implements java.io.Serializable {
    private com.mobilebulletin.remote.group.Servresponse response;

    private java.lang.String responseTo;

    private java.lang.String servValidation;

    public SystemSuperResponse() {
    }

    public SystemSuperResponse(
           com.mobilebulletin.remote.group.Servresponse response,
           java.lang.String responseTo,
           java.lang.String servValidation) {
           this.response = response;
           this.responseTo = responseTo;
           this.servValidation = servValidation;
    }


    /**
     * Gets the response value for this SystemSuperResponse.
     * 
     * @return response
     */
    public com.mobilebulletin.remote.group.Servresponse getResponse() {
        return response;
    }


    /**
     * Sets the response value for this SystemSuperResponse.
     * 
     * @param response
     */
    public void setResponse(com.mobilebulletin.remote.group.Servresponse response) {
        this.response = response;
    }


    /**
     * Gets the responseTo value for this SystemSuperResponse.
     * 
     * @return responseTo
     */
    public java.lang.String getResponseTo() {
        return responseTo;
    }


    /**
     * Sets the responseTo value for this SystemSuperResponse.
     * 
     * @param responseTo
     */
    public void setResponseTo(java.lang.String responseTo) {
        this.responseTo = responseTo;
    }


    /**
     * Gets the servValidation value for this SystemSuperResponse.
     * 
     * @return servValidation
     */
    public java.lang.String getServValidation() {
        return servValidation;
    }


    /**
     * Sets the servValidation value for this SystemSuperResponse.
     * 
     * @param servValidation
     */
    public void setServValidation(java.lang.String servValidation) {
        this.servValidation = servValidation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SystemSuperResponse)) return false;
        SystemSuperResponse other = (SystemSuperResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse()))) &&
            ((this.responseTo==null && other.getResponseTo()==null) || 
             (this.responseTo!=null &&
              this.responseTo.equals(other.getResponseTo()))) &&
            ((this.servValidation==null && other.getServValidation()==null) || 
             (this.servValidation!=null &&
              this.servValidation.equals(other.getServValidation())));
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
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        if (getResponseTo() != null) {
            _hashCode += getResponseTo().hashCode();
        }
        if (getServValidation() != null) {
            _hashCode += getServValidation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SystemSuperResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "systemSuperResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response");
        elemField.setXmlName(new javax.xml.namespace.QName("", "response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "servresponse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseTo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("servValidation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "servValidation"));
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
