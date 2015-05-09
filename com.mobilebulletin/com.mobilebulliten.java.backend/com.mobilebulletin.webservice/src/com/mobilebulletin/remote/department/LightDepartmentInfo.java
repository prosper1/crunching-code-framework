/**
 * LightDepartmentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.department;

public class LightDepartmentInfo  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String name;

    private long numberOfMembers;

    private java.lang.String timeAgo;

    public LightDepartmentInfo() {
    }

    public LightDepartmentInfo(
           java.lang.String id,
           java.lang.String name,
           long numberOfMembers,
           java.lang.String timeAgo) {
           this.id = id;
           this.name = name;
           this.numberOfMembers = numberOfMembers;
           this.timeAgo = timeAgo;
    }


    /**
     * Gets the id value for this LightDepartmentInfo.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this LightDepartmentInfo.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the name value for this LightDepartmentInfo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this LightDepartmentInfo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the numberOfMembers value for this LightDepartmentInfo.
     * 
     * @return numberOfMembers
     */
    public long getNumberOfMembers() {
        return numberOfMembers;
    }


    /**
     * Sets the numberOfMembers value for this LightDepartmentInfo.
     * 
     * @param numberOfMembers
     */
    public void setNumberOfMembers(long numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }


    /**
     * Gets the timeAgo value for this LightDepartmentInfo.
     * 
     * @return timeAgo
     */
    public java.lang.String getTimeAgo() {
        return timeAgo;
    }


    /**
     * Sets the timeAgo value for this LightDepartmentInfo.
     * 
     * @param timeAgo
     */
    public void setTimeAgo(java.lang.String timeAgo) {
        this.timeAgo = timeAgo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LightDepartmentInfo)) return false;
        LightDepartmentInfo other = (LightDepartmentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.numberOfMembers == other.getNumberOfMembers() &&
            ((this.timeAgo==null && other.getTimeAgo()==null) || 
             (this.timeAgo!=null &&
              this.timeAgo.equals(other.getTimeAgo())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += new Long(getNumberOfMembers()).hashCode();
        if (getTimeAgo() != null) {
            _hashCode += getTimeAgo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LightDepartmentInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "lightDepartmentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfMembers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfMembers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeAgo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeAgo"));
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
