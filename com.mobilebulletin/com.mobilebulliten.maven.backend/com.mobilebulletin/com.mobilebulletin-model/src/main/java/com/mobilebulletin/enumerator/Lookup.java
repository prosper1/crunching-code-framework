package com.mobilebulletin.enumerator;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Lookup implements ILookup, Serializable
{
  private int ordinal = -1;
  private String code;
  private String description;
  public Lookup() {}

  public Lookup(String code) 
  {
    this.code = code;
  }

  public Lookup(String code, String description) 
  {
    this.code = code;
    this.description = description;
  }

  public Lookup(int ordinal, String code, String description) 
  {
    this.ordinal = ordinal;
    this.code = code;
    this.description = description;
  }

  /*
   * (non-Javadoc)
   * 
   * @see za.aspire.sp.ILookup#getCode()
   */
  public String getCode() 
  {
	  return code;
  }

  /*
   * (non-Javadoc)
   * 
   * @see za.aspire.sp.ILookup#setCode()
   */
  public void setCode(String description) 
  {
	  this.code = description;
  }

  /*
   * (non-Javadoc)
   * 
   * @see za.aspire.sp.ILookup#getDescription()
   */
  public String getDescription() 
  {
	  return description;
  }

  /*
   * (non-Javadoc)
   * 
   * @see za.aspire.sp.ILookup#setDescription()
   */
  public void setDescription(String description) 
  {
	  this.description = description;
  }

  /**
   * @return Returns the ordinal.
   */
  public int ordinal() 
  {
	  return ordinal;
  }

  public boolean equals(ILookup obj) 
  {
	  if (obj == null) return false;
	  return (getCode().compareTo(obj.getCode())) == 0
        && (ordinal == obj.ordinal());
  }
}