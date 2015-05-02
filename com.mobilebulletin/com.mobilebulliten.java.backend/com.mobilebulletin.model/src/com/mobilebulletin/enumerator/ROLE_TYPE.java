package com.mobilebulletin.enumerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class ROLE_TYPE  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static ROLE_TYPE Admin = new ROLE_TYPE(0, "ROL_ADM", "Admin");
	  public static ROLE_TYPE Manager = new ROLE_TYPE(1, "ROL_MAN", "Manager");
	  public static ROLE_TYPE Employee = new ROLE_TYPE(2, "ROL_EMP", "Employee");


	  public ROLE_TYPE(){}
	    public ROLE_TYPE(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static ROLE_TYPE[] values() {
	      ROLE_TYPE[] valueArray = new ROLE_TYPE[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static ROLE_TYPE getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (ROLE_TYPE)obj;
	    }
	    public static ROLE_TYPE getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (ROLE_TYPE)obj;
	    }

}
