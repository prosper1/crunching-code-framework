/**
 * SignInResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.security;

public class SignInResponse  extends com.mobilebulletin.remote.security.SystemSuperResponse  implements java.io.Serializable {
    private java.lang.String activationStatus;

    private java.lang.String cellNo;

    private java.lang.String email;

    private java.lang.String userId;

    private java.lang.String[] userRoles;

    private java.lang.String username;

    public SignInResponse() {
    }

    public SignInResponse(
           com.mobilebulletin.remote.security.Servresponse response,
           java.lang.String responseTo,
           java.lang.String servValidation,
           java.lang.String activationStatus,
           java.lang.String cellNo,
           java.lang.String email,
           java.lang.String userId,
           java.lang.String[] userRoles,
           java.lang.String username) {
        super(
            response,
            responseTo,
            servValidation);
        this.activationStatus = activationStatus;
        this.cellNo = cellNo;
        this.email = email;
        this.userId = userId;
        this.userRoles = userRoles;
        this.username = username;
    }


    /**
     * Gets the activationStatus value for this SignInResponse.
     * 
     * @return activationStatus
     */
    public java.lang.String getActivationStatus() {
        return activationStatus;
    }


    /**
     * Sets the activationStatus value for this SignInResponse.
     * 
     * @param activationStatus
     */
    public void setActivationStatus(java.lang.String activationStatus) {
        this.activationStatus = activationStatus;
    }


    /**
     * Gets the cellNo value for this SignInResponse.
     * 
     * @return cellNo
     */
    public java.lang.String getCellNo() {
        return cellNo;
    }


    /**
     * Sets the cellNo value for this SignInResponse.
     * 
     * @param cellNo
     */
    public void setCellNo(java.lang.String cellNo) {
        this.cellNo = cellNo;
    }


    /**
     * Gets the email value for this SignInResponse.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this SignInResponse.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the userId value for this SignInResponse.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this SignInResponse.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the userRoles value for this SignInResponse.
     * 
     * @return userRoles
     */
    public java.lang.String[] getUserRoles() {
        return userRoles;
    }


    /**
     * Sets the userRoles value for this SignInResponse.
     * 
     * @param userRoles
     */
    public void setUserRoles(java.lang.String[] userRoles) {
        this.userRoles = userRoles;
    }

    public java.lang.String getUserRoles(int i) {
        return this.userRoles[i];
    }

    public void setUserRoles(int i, java.lang.String _value) {
        this.userRoles[i] = _value;
    }


    /**
     * Gets the username value for this SignInResponse.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this SignInResponse.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SignInResponse)) return false;
        SignInResponse other = (SignInResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.activationStatus==null && other.getActivationStatus()==null) || 
             (this.activationStatus!=null &&
              this.activationStatus.equals(other.getActivationStatus()))) &&
            ((this.cellNo==null && other.getCellNo()==null) || 
             (this.cellNo!=null &&
              this.cellNo.equals(other.getCellNo()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.userRoles==null && other.getUserRoles()==null) || 
             (this.userRoles!=null &&
              java.util.Arrays.equals(this.userRoles, other.getUserRoles()))) &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername())));
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
        if (getActivationStatus() != null) {
            _hashCode += getActivationStatus().hashCode();
        }
        if (getCellNo() != null) {
            _hashCode += getCellNo().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getUserRoles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserRoles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserRoles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SignInResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://security.remote.mobilebulletin.com/", "signInResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activationStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activationStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cellNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cellNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userRoles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userRoles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("", "username"));
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
