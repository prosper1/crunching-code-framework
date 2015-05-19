package com.mobilebulletin.local.utils;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;


//import org.apache.jackrabbit.value.ValueFactoryImpl;

import com.common.cms.Person;
import com.common.log.LogActivity;
import com.common.log.LoggerUpdate;
public class LocalHelper {

	public static Timestamp getCurrentTime(){
		Date now = new Date();
		return new Timestamp(now.getTime());
	}
	
	public static String getActivationCode(){
		Random rand = new Random(); 
		int pickedNumber = rand.nextInt(100000) + 10000;
		return "MOB_BUL_CODE_"+pickedNumber;
	}
	

	public static Date getDateTimeFromRemoteString(String formattedDate){
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).parse(formattedDate);
		} catch (ParseException e) {
			try {
				date = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss aa").parse(formattedDate);
			} catch (ParseException e1) 
		    {
				try {
					date = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.ENGLISH).parse(formattedDate);
				} catch (ParseException e2) {
					try {
						date = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.ENGLISH).parse(formattedDate);
					} catch (ParseException e3) {
						try {
							date = new SimpleDateFormat("MMM dd, yyyy HH:mm").parse(formattedDate);
						} catch (ParseException e4) 
					    {
							try {
								date = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).parse(formattedDate);
							} catch (ParseException e5) {
								try {
									date = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.ENGLISH).parse(formattedDate);
								} catch (ParseException e6) {
									try {
										date = new SimpleDateFormat("yyyy-MMM-dd HH:mm", Locale.ENGLISH).parse(formattedDate);
									} catch (ParseException e7) {
										try {
											date = new SimpleDateFormat("dd MM yyyy HH:mm", Locale.ENGLISH).parse(formattedDate);
										} catch (ParseException e8) {
											
										}
									}
								}
							}
					    }
					}
				}
		    }
		}
		return date;
	}
	public static Date getDateFromExcelString(String formattedDate){
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-MMM-yy").parse(formattedDate);
		} catch (ParseException e12) 
	    {
			date = getDateFromRemoteString(formattedDate);
	    }
		return date;
	}
	public static Date getDateFromRemoteString(String formattedDate){
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(formattedDate);
		} catch (ParseException e) 
	     {
			try {
				date = new SimpleDateFormat("MMM dd, yyyy").parse(formattedDate);
			} catch (ParseException e1) 
		    {
				try {
					date = new SimpleDateFormat("dd-MMM-yyyy").parse(formattedDate);
				} catch (ParseException e2) 
			     {
					try {
						date = new SimpleDateFormat("MMMM dd, yyyy").parse(formattedDate);
					} catch (ParseException e3) 
				    {
						try {
							date = new SimpleDateFormat("dd-MMMM-yyyy").parse(formattedDate);
						} catch (ParseException e4) 
					     {
							try {
								date = new SimpleDateFormat("MM dd, yyyy").parse(formattedDate);
							} catch (ParseException e5) 
						    {
								try {
									date = new SimpleDateFormat("dd:MM:yyyy").parse(formattedDate);
								} catch (ParseException e6) 
							     {
									try {
										date = new SimpleDateFormat("MMM dd, yyyy").parse(formattedDate);
									} catch (ParseException e7) 
								    {
										try {
											date = new SimpleDateFormat("dd MMM yyyy").parse(formattedDate);
										} catch (ParseException e8) 
									    {
											try {
												date = new SimpleDateFormat("dd MMMM yyyy").parse(formattedDate);
											} catch (ParseException e9) 
										    {
												try {
													date = new SimpleDateFormat("dd-MM-yy").parse(formattedDate);
												} catch (ParseException e10) 
											    {
													try {
														date = new SimpleDateFormat("dd/MM/yy").parse(formattedDate);
													} catch (ParseException e11) 
												    {
														try {
															date = new SimpleDateFormat("dd-MMM-yy").parse(formattedDate);
														} catch (ParseException e12) 
													    {
															try {
																date = new SimpleDateFormat("dd/MMM/yy").parse(formattedDate);
															} catch (ParseException e13) 
														    {
																try {
																	date = new SimpleDateFormat("dd MMM").parse(formattedDate);
																} catch (ParseException e14) 
															    {
																	try {
																		date = new SimpleDateFormat("dd MMMM").parse(formattedDate);
																	} catch (ParseException e15) 
																    {
																		
																    }
															    }
														    }
													    }
												    }
											    }
										    }
									    }
								    }
								}
						    }
						}
				    }
				}
		    }
		}
		return date;
	}
	
	public static Date getTimeFromRemoteString(String formattedTime){
		Date date = null;
		try {
			date = new SimpleDateFormat("HH:mm").parse(formattedTime);
		} catch (ParseException e) 
	     {
			try {
				date = new SimpleDateFormat("MMM dd, yyyy HH:mm").parse("JAN 01, 1970 "+formattedTime);
			} catch (ParseException e1) 
		    {
				
		    }
		}
		return date;
	}
	public static String getTimeFromUtilDate(Date date){
		final Format formatter = new SimpleDateFormat("HH:mm");
		String time = formatter.format(date);
		return time;
	}
	
	public static String getDateStringFromUtilDate(Date date){
		final Format formatter = new SimpleDateFormat("dd MMMM yyyy");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static String getDayMonthStringFromUtilDate(Date date){
		final Format formatter = new SimpleDateFormat("dd MMMM");
		String dateString = formatter.format(date);
		return dateString;
	}
	public static LogActivity getLogActivity(Person user, LogActivity logActivity){
		if(logActivity == null){
			logActivity = new LogActivity();
			logActivity.setCreatedBy(user);
			logActivity.setCreatedOn(LocalHelper.getCurrentTime());
			
		}else{
			LoggerUpdate loggerUpdate = new LoggerUpdate();
			List<LoggerUpdate> loggerUpdates = logActivity.getLoggerUpdates();
			if(loggerUpdates == null){
				loggerUpdates = new ArrayList<LoggerUpdate>();
				logActivity.setLoggerUpdates(loggerUpdates);
			}
			loggerUpdate.setLastUpdatedBy(user);
			loggerUpdate.setLastUpdated(LocalHelper.getCurrentTime());
			loggerUpdates.add(loggerUpdate);
		}
		return logActivity;
	}
	
//	public static String getDateStringForJackRabbit(Date date){
//		Calendar cal = Calendar.getInstance();  
//		cal.setTime(date);  
//		String formattedDate = null;
//		try {
//			formattedDate = ValueFactoryImpl.getInstance().createValue(cal).getString();
//		} catch (ValueFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RepositoryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return formattedDate;
//	}

	
	public static String getTimeSpanFromDate(Date past){
		try{
		TimeAgo timeAgo = new TimeAgo();
		return timeAgo.timeAgo(past);
		}catch(Exception p){
			p.printStackTrace();
		}
		return null;
	}
	
	
}
