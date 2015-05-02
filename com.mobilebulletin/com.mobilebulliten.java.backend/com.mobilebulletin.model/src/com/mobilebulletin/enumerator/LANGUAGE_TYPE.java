package com.mobilebulletin.enumerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class LANGUAGE_TYPE  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static LANGUAGE_TYPE English = new LANGUAGE_TYPE(0, "LAN_E", "English");
	  public static LANGUAGE_TYPE Sotho = new LANGUAGE_TYPE(1, "LAN_S", "Sotho");
	  public static LANGUAGE_TYPE Zulu = new LANGUAGE_TYPE(2, "LAN_Z", "Zulu");


	  public LANGUAGE_TYPE(){}
	    public LANGUAGE_TYPE(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static LANGUAGE_TYPE[] values() {
	      LANGUAGE_TYPE[] valueArray = new LANGUAGE_TYPE[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static LANGUAGE_TYPE getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (LANGUAGE_TYPE)obj;
	    }
	    public static LANGUAGE_TYPE getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (LANGUAGE_TYPE)obj;
	    }

}
