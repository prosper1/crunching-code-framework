package com.mobilebulletin.enumerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class SUPPORT_MODULE_TYPE  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static SUPPORT_MODULE_TYPE Dashboard = new SUPPORT_MODULE_TYPE(0, "SUP_MOD_DAS", "Dashboard");
	  public static SUPPORT_MODULE_TYPE Messages = new SUPPORT_MODULE_TYPE(1, "SUP_MOD_MES", "Messages");
	  public static SUPPORT_MODULE_TYPE Employees = new SUPPORT_MODULE_TYPE(2, "SUP_MOD_EMP", "Employees");
	  public static SUPPORT_MODULE_TYPE Departments = new SUPPORT_MODULE_TYPE(4, "SUP_MOD_DEP", "Departments");
	  public static SUPPORT_MODULE_TYPE Support = new SUPPORT_MODULE_TYPE(5, "SUP_MOD_SUP", "Support");
	  public static SUPPORT_MODULE_TYPE Settings = new SUPPORT_MODULE_TYPE(6, "SUP_MOD_SET", "Settings");

	  public SUPPORT_MODULE_TYPE(){}
	    public SUPPORT_MODULE_TYPE(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static SUPPORT_MODULE_TYPE[] values() {
	      SUPPORT_MODULE_TYPE[] valueArray = new SUPPORT_MODULE_TYPE[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static SUPPORT_MODULE_TYPE getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (SUPPORT_MODULE_TYPE)obj;
	    }
	    public static SUPPORT_MODULE_TYPE getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (SUPPORT_MODULE_TYPE)obj;
	    }

}
