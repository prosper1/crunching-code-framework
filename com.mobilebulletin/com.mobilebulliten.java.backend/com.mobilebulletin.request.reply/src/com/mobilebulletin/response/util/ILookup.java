package com.mobilebulletin.response.util;

import java.io.Serializable;

public interface ILookup extends Serializable {

  public int ordinal();
  
  public String getCode();

  public void setCode(String code);

  public String getDescription();

  public void setDescription(String description);
}