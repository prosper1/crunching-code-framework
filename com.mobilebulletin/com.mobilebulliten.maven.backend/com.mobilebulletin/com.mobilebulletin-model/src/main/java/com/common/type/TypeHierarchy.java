package com.common.type;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

public class TypeHierarchy  implements Serializable{
	
	private static final long serialVersionUID = -2574126054453557L;
	private long id;
	private int ordinal;
	private String description;
	private String code;
	private TypeHierarchy parent;
	private List<TypeHierarchy> children;
	public int getOrdinal() {
		return ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	//Comment and uncomment the below code for disabling an infite call to parent from child
	@XmlTransient
	public TypeHierarchy getParent() {
		return parent;
	}
	public void setParent(TypeHierarchy parent) {
		this.parent = parent;
	}
	public List<TypeHierarchy> getChildren() {
		return children;
	}
	public void setChildren(List<TypeHierarchy> children) {
		this.children = children;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	
	
}
