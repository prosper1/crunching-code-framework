/**
 * DepartmentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mobilebulletin.remote.department;

public class DepartmentInfo  implements java.io.Serializable {
    private java.lang.String description;

    private com.mobilebulletin.remote.department.EmployeeInfo[] employeeInfoList;

    private java.lang.String id;

    private java.lang.String name;

    public DepartmentInfo() {
    }

    public DepartmentInfo(
           java.lang.String description,
           com.mobilebulletin.remote.department.EmployeeInfo[] employeeInfoList,
           java.lang.String id,
           java.lang.String name) {
           this.description = description;
           this.employeeInfoList = employeeInfoList;
           this.id = id;
           this.name = name;
    }


    /**
     * Gets the description value for this DepartmentInfo.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this DepartmentInfo.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the employeeInfoList value for this DepartmentInfo.
     * 
     * @return employeeInfoList
     */
    public com.mobilebulletin.remote.department.EmployeeInfo[] getEmployeeInfoList() {
        return employeeInfoList;
    }


    /**
     * Sets the employeeInfoList value for this DepartmentInfo.
     * 
     * @param employeeInfoList
     */
    public void setEmployeeInfoList(com.mobilebulletin.remote.department.EmployeeInfo[] employeeInfoList) {
        this.employeeInfoList = employeeInfoList;
    }

    public com.mobilebulletin.remote.department.EmployeeInfo getEmployeeInfoList(int i) {
        return this.employeeInfoList[i];
    }

    public void setEmployeeInfoList(int i, com.mobilebulletin.remote.department.EmployeeInfo _value) {
        this.employeeInfoList[i] = _value;
    }


    /**
     * Gets the id value for this DepartmentInfo.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this DepartmentInfo.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the name value for this DepartmentInfo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this DepartmentInfo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DepartmentInfo)) return false;
        DepartmentInfo other = (DepartmentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.employeeInfoList==null && other.getEmployeeInfoList()==null) || 
             (this.employeeInfoList!=null &&
              java.util.Arrays.equals(this.employeeInfoList, other.getEmployeeInfoList()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEmployeeInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEmployeeInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEmployeeInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DepartmentInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "departmentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeeInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://department.remote.mobilebulletin.com/", "employeeInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
