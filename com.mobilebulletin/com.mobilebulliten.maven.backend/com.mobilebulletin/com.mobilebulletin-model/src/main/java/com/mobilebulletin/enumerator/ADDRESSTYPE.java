package com.mobilebulletin.enumerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class ADDRESSTYPE  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static ADDRESSTYPE Postal = new ADDRESSTYPE(0, "POS", "Postal");
	  public static ADDRESSTYPE Street = new ADDRESSTYPE(1, "STR", "Street");
	  public static ADDRESSTYPE Business = new ADDRESSTYPE(2, "BUS", "Business");


	  public ADDRESSTYPE(){}
	    public ADDRESSTYPE(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static ADDRESSTYPE[] values() {
	      ADDRESSTYPE[] valueArray = new ADDRESSTYPE[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static ADDRESSTYPE getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (ADDRESSTYPE)obj;
	    }
	    public static ADDRESSTYPE getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (ADDRESSTYPE)obj;
	    }

}
