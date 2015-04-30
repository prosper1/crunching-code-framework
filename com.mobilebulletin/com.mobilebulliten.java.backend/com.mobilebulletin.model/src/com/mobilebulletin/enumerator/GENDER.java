package com.mobilebulletin.enumerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class GENDER  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static GENDER Female = new GENDER(0, "F", "Female");
	  public static GENDER Male = new GENDER(1, "M", "Male");
	  public static GENDER Unisex = new GENDER(2, "U", "Unisex");


	  public GENDER(){}
	    public GENDER(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static GENDER[] values() {
	      GENDER[] valueArray = new GENDER[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static GENDER getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (GENDER)obj;
	    }
	    public static GENDER getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (GENDER)obj;
	    }

}
