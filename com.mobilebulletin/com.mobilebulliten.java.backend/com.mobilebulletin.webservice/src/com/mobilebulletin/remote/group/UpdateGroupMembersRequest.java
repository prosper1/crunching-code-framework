/**
 * UpdateGroupMembersRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.group;

public class UpdateGroupMembersRequest  extends com.mobilebulletin.remote.group.CommonRequest  implements java.io.Serializable {
    private java.lang.String groupId;

    private com.mobilebulletin.remote.group.GroupMemberInfo[] groupMemberList;

    public UpdateGroupMembersRequest() {
    }

    public UpdateGroupMembersRequest(
           java.lang.String requestCellNumber,
           java.lang.String requestClientName,
           java.lang.String requestCompanyId,
           java.lang.String requestUserId,
           java.lang.String groupId,
           com.mobilebulletin.remote.group.GroupMemberInfo[] groupMemberList) {
        super(
            requestCellNumber,
            requestClientName,
            requestCompanyId,
            requestUserId);
        this.groupId = groupId;
        this.groupMemberList = groupMemberList;
    }


    /**
     * Gets the groupId value for this UpdateGroupMembersRequest.
     * 
     * @return groupId
     */
    public java.lang.String getGroupId() {
        return groupId;
    }


    /**
     * Sets the groupId value for this UpdateGroupMembersRequest.
     * 
     * @param groupId
     */
    public void setGroupId(java.lang.String groupId) {
        this.groupId = groupId;
    }


    /**
     * Gets the groupMemberList value for this UpdateGroupMembersRequest.
     * 
     * @return groupMemberList
     */
    public com.mobilebulletin.remote.group.GroupMemberInfo[] getGroupMemberList() {
        return groupMemberList;
    }


    /**
     * Sets the groupMemberList value for this UpdateGroupMembersRequest.
     * 
     * @param groupMemberList
     */
    public void setGroupMemberList(com.mobilebulletin.remote.group.GroupMemberInfo[] groupMemberList) {
        this.groupMemberList = groupMemberList;
    }

    public com.mobilebulletin.remote.group.GroupMemberInfo getGroupMemberList(int i) {
        return this.groupMemberList[i];
    }

    public void setGroupMemberList(int i, com.mobilebulletin.remote.group.GroupMemberInfo _value) {
        this.groupMemberList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateGroupMembersRequest)) return false;
        UpdateGroupMembersRequest other = (UpdateGroupMembersRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.groupId==null && other.getGroupId()==null) || 
             (this.groupId!=null &&
              this.groupId.equals(other.getGroupId()))) &&
            ((this.groupMemberList==null && other.getGroupMemberList()==null) || 
             (this.groupMemberList!=null &&
              java.util.Arrays.equals(this.groupMemberList, other.getGroupMemberList())));
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
        if (getGroupId() != null) {
            _hashCode += getGroupId().hashCode();
        }
        if (getGroupMemberList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroupMemberList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroupMemberList(), i);
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
        new org.apache.axis.description.TypeDesc(UpdateGroupMembersRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "updateGroupMembersRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupMemberList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupMemberList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "groupMemberInfo"));
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
