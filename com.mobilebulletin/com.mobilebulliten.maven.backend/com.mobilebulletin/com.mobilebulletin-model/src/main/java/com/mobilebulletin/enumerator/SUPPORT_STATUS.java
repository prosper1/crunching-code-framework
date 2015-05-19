package com.mobilebulletin.enumerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class SUPPORT_STATUS  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  public static SUPPORT_STATUS CLOSED = new SUPPORT_STATUS(0, "CLOSED", "Support Ticket Closed");
	  public static SUPPORT_STATUS OPENED = new SUPPORT_STATUS(1, "OPENED", "Support Ticket Opened");
	  public static SUPPORT_STATUS PARKED = new SUPPORT_STATUS(2, "PARKED", "Support Ticket Parked For Further Investigations");
	  public static SUPPORT_STATUS WORKING_ON_IT = new SUPPORT_STATUS(3, "IN_PROGRESS", "Support Ticket Is Being Attended To");

	  public SUPPORT_STATUS(){}
	    public SUPPORT_STATUS(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    public static SUPPORT_STATUS[] values() {
	      SUPPORT_STATUS[] valueArray = new SUPPORT_STATUS[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static SUPPORT_STATUS getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (SUPPORT_STATUS)obj;
	    }
	    public static SUPPORT_STATUS getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (SUPPORT_STATUS)obj;
	    }

}
