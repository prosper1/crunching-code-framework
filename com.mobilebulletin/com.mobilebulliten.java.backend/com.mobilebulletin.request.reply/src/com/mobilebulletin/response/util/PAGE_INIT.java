package com.mobilebulletin.response.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class PAGE_INIT  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  
	  public static PAGE_INIT SIGN_UP_PAGE = new PAGE_INIT(0, "SUP", "Sign Up Page.");
	   public PAGE_INIT(){}
	    public PAGE_INIT(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    
	    public static PAGE_INIT[] values() {
	      PAGE_INIT[] valueArray = new PAGE_INIT[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static PAGE_INIT getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (PAGE_INIT)obj;
	    }
	    public static PAGE_INIT getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (PAGE_INIT)obj;
	    }

}
