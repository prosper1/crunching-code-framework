package com.mobilebulletin.response.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"serial","rawtypes", "unchecked"})
public class SERVRESPONSE  extends Lookup implements Serializable {
	  private static List listValues = new ArrayList();
	  private static List values = new ArrayList();
	  private static Map codes = new HashMap();
	  private static Map descriptions = new HashMap();
	  
	  public static SERVRESPONSE RegisterUserSuccessful= new SERVRESPONSE(0, "RUS", "User was successfully registered, you will shortly receive an email for your confirmation.");
	  public static SERVRESPONSE UserAlreadyExists =new SERVRESPONSE(1, "UAE", "User already exists. Please check your email address and try again.");
	  public static SERVRESPONSE ServerError =new SERVRESPONSE(2, "SRE", "Oops!, something went wrong. We are trying to fix the problem.");
	  public static SERVRESPONSE LoginSuccessful =new SERVRESPONSE(3, "LIS", "User has logged in successfully ");
	  public static SERVRESPONSE LoginFailed =new SERVRESPONSE(4, "LIF", "Username or password is incorrect or they don't match a valid user, please try again.");
	  public static SERVRESPONSE UserNotActive =new SERVRESPONSE(5, "UNA", "User is not active");
	  public static SERVRESPONSE UserNotFound =new SERVRESPONSE(6, "UNF", "The e-mail you have entered doesn't exist. To create an account under this e-mail address, click Sign-Up Or Scroll Down to the Sign Up(Register) Section");
	  public static SERVRESPONSE Successful = new SERVRESPONSE(7, "SUC", "Successful");
	  public static SERVRESPONSE InsertFailed = new SERVRESPONSE(8, "INS", "Adding to the database failed.Please Try again later.");
	  public static SERVRESPONSE UpdateFailed = new SERVRESPONSE(9, "UPD", "Modification to the database failed.Please Try again later.");
	  public static SERVRESPONSE DeleteFailed = new SERVRESPONSE(10, "DEL", "Removing information on the database failed.Please Try again later.");
	  public static SERVRESPONSE RetrieveFailed = new SERVRESPONSE(11, "RET", "Retrivieng from the database failed.Please Try again later.");
	  public static SERVRESPONSE UserAlreadyActivated =new SERVRESPONSE(12, "UAE", "User account already activated");
	  public static SERVRESPONSE CompanyAlreadyExists =new SERVRESPONSE(13, "CAE", "Company name already exists");
	  public static SERVRESPONSE CompanyNotFound =new SERVRESPONSE(14, "CNF", "Company not found");
	  public static SERVRESPONSE RescheduleFailed =new SERVRESPONSE(15, "RES_FAIL", "Rescheduling of the appointment failed. Please try again.");
	  public static SERVRESPONSE GroupNotFound =new SERVRESPONSE(16, "GNF", "Group Not Found");
	  public static SERVRESPONSE EmployeeNotFound =new SERVRESPONSE(17, "ENF", "Employee Not Found");
	  public static SERVRESPONSE PersonAlreadyOptedOut =new SERVRESPONSE(18, "PAOO", "Person Already Opted Out");
	  public static SERVRESPONSE RoleNotFound =new SERVRESPONSE(19, "RNF", "Role Not Found");
	  public static SERVRESPONSE TimeSlotExist =new SERVRESPONSE(20, "TSE", "Time Slot Exist");
	  public static SERVRESPONSE AccountNotVerified = new SERVRESPONSE(21, "ACT_NOT", "Account Not Verified");
	  public static SERVRESPONSE AccountVerified = new SERVRESPONSE(22, "ACT_VER", "Account Verified");
	 
	  public static SERVRESPONSE InvalidUsernamePassword = new SERVRESPONSE(23, "INV_USE", "Invalid Username/Password");
	  public SERVRESPONSE(){}
	    public SERVRESPONSE(int ordinal, String code, String description) {
	      super(ordinal, code, description);
	      listValues.add(description);
	      values.add(this);
	      codes.put(code, this);
	      descriptions.put(description, this);
	    }
	    
	    public static SERVRESPONSE[] values() {
	      SERVRESPONSE[] valueArray = new SERVRESPONSE[values.size()];
	      values.toArray(valueArray);
	      return valueArray;
	    }
	    public static String[] getListValues() {
	      String[] valueArray = new String[listValues.size()];
	      listValues.toArray(valueArray);
	      return valueArray;
	    }
	    public static SERVRESPONSE getByCode(String code) throws IllegalArgumentException {
	      Object obj = codes.get(code);
	      if(obj == null) throw new IllegalArgumentException("Code (" + code + ") not found");
	      return (SERVRESPONSE)obj;
	    }
	    public static SERVRESPONSE getByDescription(String desc) throws IllegalArgumentException {
	      Object obj = descriptions.get(desc);
	      if(obj == null) throw new IllegalArgumentException("Description (" + desc + ") not found");
	      return (SERVRESPONSE)obj;
	    }

}
