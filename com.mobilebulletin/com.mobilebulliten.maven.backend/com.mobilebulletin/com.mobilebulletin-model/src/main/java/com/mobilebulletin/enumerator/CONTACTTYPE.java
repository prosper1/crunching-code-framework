package com.mobilebulletin.enumerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class CONTACTTYPE  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static CONTACTTYPE Cell = new CONTACTTYPE(0, "CEL", "Cell");
	  public static CONTACTTYPE Email = new CONTACTTYPE(1, "EMA", "Email");
	  public static CONTACTTYPE Facebook = new CONTACTTYPE(2, "FAC", "Facebook");
	  public static CONTACTTYPE Fax = new CONTACTTYPE(3, "FAX", "Fax");
	  public static CONTACTTYPE Home = new CONTACTTYPE(4, "HOM", "Home");
	  
	  public static CONTACTTYPE Office = new CONTACTTYPE(5, "OFF", "Office");
	  public static CONTACTTYPE Twitter = new CONTACTTYPE(6, "TWI", "Twitter");
	  public static CONTACTTYPE Website = new CONTACTTYPE(7, "Web", "Website");
	  public static CONTACTTYPE Work = new CONTACTTYPE(8, "WOR", "Work");
	  
	 
	  public CONTACTTYPE(){}
	    public CONTACTTYPE(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static CONTACTTYPE[] values() {
	      CONTACTTYPE[] valueArray = new CONTACTTYPE[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static CONTACTTYPE getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (CONTACTTYPE)obj;
	    }
	    public static CONTACTTYPE getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (CONTACTTYPE)obj;
	    }

}
