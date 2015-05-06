/**
 * GroupMemberInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.group;

public class GroupMemberInfo  implements java.io.Serializable {
    private java.lang.String memberId;

    private java.lang.String memberRole;

    public GroupMemberInfo() {
    }

    public GroupMemberInfo(
           java.lang.String memberId,
           java.lang.String memberRole) {
           this.memberId = memberId;
           this.memberRole = memberRole;
    }


    /**
     * Gets the memberId value for this GroupMemberInfo.
     * 
     * @return memberId
     */
    public java.lang.String getMemberId() {
        return memberId;
    }


    /**
     * Sets the memberId value for this GroupMemberInfo.
     * 
     * @param memberId
     */
    public void setMemberId(java.lang.String memberId) {
        this.memberId = memberId;
    }


    /**
     * Gets the memberRole value for this GroupMemberInfo.
     * 
     * @return memberRole
     */
    public java.lang.String getMemberRole() {
        return memberRole;
    }


    /**
     * Sets the memberRole value for this GroupMemberInfo.
     * 
     * @param memberRole
     */
    public void setMemberRole(java.lang.String memberRole) {
        this.memberRole = memberRole;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GroupMemberInfo)) return false;
        GroupMemberInfo other = (GroupMemberInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.memberId==null && other.getMemberId()==null) || 
             (this.memberId!=null &&
              this.memberId.equals(other.getMemberId()))) &&
            ((this.memberRole==null && other.getMemberRole()==null) || 
             (this.memberRole!=null &&
              this.memberRole.equals(other.getMemberRole())));
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
        if (getMemberId() != null) {
            _hashCode += getMemberId().hashCode();
        }
        if (getMemberRole() != null) {
            _hashCode += getMemberRole().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GroupMemberInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "groupMemberInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberRole");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberRole"));
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
