/**
 * GetGroupsByCompanyIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.group;

public class GetGroupsByCompanyIdResponse  extends com.mobilebulletin.remote.group.SystemSuperResponse  implements java.io.Serializable {
    private com.mobilebulletin.remote.group.LightGroupInfo[] groupInfoList;

    public GetGroupsByCompanyIdResponse() {
    }

    public GetGroupsByCompanyIdResponse(
           com.mobilebulletin.remote.group.Servresponse response,
           java.lang.String responseTo,
           java.lang.String servValidation,
           com.mobilebulletin.remote.group.LightGroupInfo[] groupInfoList) {
        super(
            response,
            responseTo,
            servValidation);
        this.groupInfoList = groupInfoList;
    }


    /**
     * Gets the groupInfoList value for this GetGroupsByCompanyIdResponse.
     * 
     * @return groupInfoList
     */
    public com.mobilebulletin.remote.group.LightGroupInfo[] getGroupInfoList() {
        return groupInfoList;
    }


    /**
     * Sets the groupInfoList value for this GetGroupsByCompanyIdResponse.
     * 
     * @param groupInfoList
     */
    public void setGroupInfoList(com.mobilebulletin.remote.group.LightGroupInfo[] groupInfoList) {
        this.groupInfoList = groupInfoList;
    }

    public com.mobilebulletin.remote.group.LightGroupInfo getGroupInfoList(int i) {
        return this.groupInfoList[i];
    }

    public void setGroupInfoList(int i, com.mobilebulletin.remote.group.LightGroupInfo _value) {
        this.groupInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGroupsByCompanyIdResponse)) return false;
        GetGroupsByCompanyIdResponse other = (GetGroupsByCompanyIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.groupInfoList==null && other.getGroupInfoList()==null) || 
             (this.groupInfoList!=null &&
              java.util.Arrays.equals(this.groupInfoList, other.getGroupInfoList())));
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
        if (getGroupInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroupInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroupInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(GetGroupsByCompanyIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "getGroupsByCompanyIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://group.remote.mobilebulletin.com/", "lightGroupInfo"));
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
