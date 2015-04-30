/**
 * CheckUserResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.security;

public class CheckUserResponse  extends com.mobilebulletin.remote.security.SystemSuperResponse  implements java.io.Serializable {
    private java.lang.String activationCode;

    private java.lang.String activationStatus;

    private java.lang.String cellNo;

    private java.lang.String gender;

    private java.lang.String imagePath;

    private boolean userActive;

    private boolean userExist;

    private java.lang.String userFullName;

    private java.lang.String userId;

    private java.lang.String userRole;

    private java.lang.String username;

    public CheckUserResponse() {
    }

    public CheckUserResponse(
           com.mobilebulletin.remote.security.Servresponse response,
           java.lang.String responseTo,
           java.lang.String servValidation,
           java.lang.String activationCode,
           java.lang.String activationStatus,
           java.lang.String cellNo,
           java.lang.String gender,
           java.lang.String imagePath,
           boolean userActive,
           boolean userExist,
           java.lang.String userFullName,
           java.lang.String userId,
           java.lang.String userRole,
           java.lang.String username) {
        super(
            response,
            responseTo,
            servValidation);
        this.activationCode = activationCode;
        this.activationStatus = activationStatus;
        this.cellNo = cellNo;
        this.gender = gender;
        this.imagePath = imagePath;
        this.userActive = userActive;
        this.userExist = userExist;
        this.userFullName = userFullName;
        this.userId = userId;
        this.userRole = userRole;
        this.username = username;
    }


    /**
     * Gets the activationCode value for this CheckUserResponse.
     * 
     * @return activationCode
     */
    public java.lang.String getActivationCode() {
        return activationCode;
    }


    /**
     * Sets the activationCode value for this CheckUserResponse.
     * 
     * @param activationCode
     */
    public void setActivationCode(java.lang.String activationCode) {
        this.activationCode = activationCode;
    }


    /**
     * Gets the activationStatus value for this CheckUserResponse.
     * 
     * @return activationStatus
     */
    public java.lang.String getActivationStatus() {
        return activationStatus;
    }


    /**
     * Sets the activationStatus value for this CheckUserResponse.
     * 
     * @param activationStatus
     */
    public void setActivationStatus(java.lang.String activationStatus) {
        this.activationStatus = activationStatus;
    }


    /**
     * Gets the cellNo value for this CheckUserResponse.
     * 
     * @return cellNo
     */
    public java.lang.String getCellNo() {
        return cellNo;
    }


    /**
     * Sets the cellNo value for this CheckUserResponse.
     * 
     * @param cellNo
     */
    public void setCellNo(java.lang.String cellNo) {
        this.cellNo = cellNo;
    }


    /**
     * Gets the gender value for this CheckUserResponse.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this CheckUserResponse.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the imagePath value for this CheckUserResponse.
     * 
     * @return imagePath
     */
    public java.lang.String getImagePath() {
        return imagePath;
    }


    /**
     * Sets the imagePath value for this CheckUserResponse.
     * 
     * @param imagePath
     */
    public void setImagePath(java.lang.String imagePath) {
        this.imagePath = imagePath;
    }


    /**
     * Gets the userActive value for this CheckUserResponse.
     * 
     * @return userActive
     */
    public boolean isUserActive() {
        return userActive;
    }


    /**
     * Sets the userActive value for this CheckUserResponse.
     * 
     * @param userActive
     */
    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }


    /**
     * Gets the userExist value for this CheckUserResponse.
     * 
     * @return userExist
     */
    public boolean isUserExist() {
        return userExist;
    }


    /**
     * Sets the userExist value for this CheckUserResponse.
     * 
     * @param userExist
     */
    public void setUserExist(boolean userExist) {
        this.userExist = userExist;
    }


    /**
     * Gets the userFullName value for this CheckUserResponse.
     * 
     * @return userFullName
     */
    public java.lang.String getUserFullName() {
        return userFullName;
    }


    /**
     * Sets the userFullName value for this CheckUserResponse.
     * 
     * @param userFullName
     */
    public void setUserFullName(java.lang.String userFullName) {
        this.userFullName = userFullName;
    }


    /**
     * Gets the userId value for this CheckUserResponse.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this CheckUserResponse.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the userRole value for this CheckUserResponse.
     * 
     * @return userRole
     */
    public java.lang.String getUserRole() {
        return userRole;
    }


    /**
     * Sets the userRole value for this CheckUserResponse.
     * 
     * @param userRole
     */
    public void setUserRole(java.lang.String userRole) {
        this.userRole = userRole;
    }


    /**
     * Gets the username value for this CheckUserResponse.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this CheckUserResponse.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckUserResponse)) return false;
        CheckUserResponse other = (CheckUserResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.activationCode==null && other.getActivationCode()==null) || 
             (this.activationCode!=null &&
              this.activationCode.equals(other.getActivationCode()))) &&
            ((this.activationStatus==null && other.getActivationStatus()==null) || 
             (this.activationStatus!=null &&
              this.activationStatus.equals(other.getActivationStatus()))) &&
            ((this.cellNo==null && other.getCellNo()==null) || 
             (this.cellNo!=null &&
              this.cellNo.equals(other.getCellNo()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.imagePath==null && other.getImagePath()==null) || 
             (this.imagePath!=null &&
              this.imagePath.equals(other.getImagePath()))) &&
            this.userActive == other.isUserActive() &&
            this.userExist == other.isUserExist() &&
            ((this.userFullName==null && other.getUserFullName()==null) || 
             (this.userFullName!=null &&
              this.userFullName.equals(other.getUserFullName()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.userRole==null && other.getUserRole()==null) || 
             (this.userRole!=null &&
              this.userRole.equals(other.getUserRole()))) &&
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
        if (getActivationCode() != null) {
            _hashCode += getActivationCode().hashCode();
        }
        if (getActivationStatus() != null) {
            _hashCode += getActivationStatus().hashCode();
        }
        if (getCellNo() != null) {
            _hashCode += getCellNo().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getImagePath() != null) {
            _hashCode += getImagePath().hashCode();
        }
        _hashCode += (isUserActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isUserExist() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUserFullName() != null) {
            _hashCode += getUserFullName().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getUserRole() != null) {
            _hashCode += getUserRole().hashCode();
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckUserResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://security.remote.mobilebulletin.com/", "checkUserResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "activationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userActive");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userActive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userExist");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userExist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userFullName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userFullName"));
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
        elemField.setFieldName("userRole");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userRole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
