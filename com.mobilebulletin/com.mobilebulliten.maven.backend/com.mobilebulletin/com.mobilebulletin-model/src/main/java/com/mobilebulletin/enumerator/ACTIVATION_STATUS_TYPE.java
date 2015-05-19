package com.mobilebulletin.enumerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class ACTIVATION_STATUS_TYPE  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static ACTIVATION_STATUS_TYPE AccountNotVerified = new ACTIVATION_STATUS_TYPE(0, "ACT_NOT", "Account Not Verified");
	  public static ACTIVATION_STATUS_TYPE AccountVerified = new ACTIVATION_STATUS_TYPE(1, "ACT_VER", "Account Verified");


	  public ACTIVATION_STATUS_TYPE(){}
	    public ACTIVATION_STATUS_TYPE(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static ACTIVATION_STATUS_TYPE[] values() {
	      ACTIVATION_STATUS_TYPE[] valueArray = new ACTIVATION_STATUS_TYPE[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static ACTIVATION_STATUS_TYPE getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (ACTIVATION_STATUS_TYPE)obj;
	    }
	    public static ACTIVATION_STATUS_TYPE getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (ACTIVATION_STATUS_TYPE)obj;
	    }

}
