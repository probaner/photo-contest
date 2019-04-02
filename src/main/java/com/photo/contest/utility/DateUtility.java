package com.photo.contest.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtility {
	
	
	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
	 public  String getDate(){
		 Date date = new Date();
		 return fmt.format(date);		 
	 }
	
	
	/*public boolean checkEquals(Date date1, Date date2){
		return fmt.format(date1).equals(fmt.format(date2));				
	}*/
	
	public boolean checkEquals(String date1, String date2){
		return stringTodate(date1).equals(stringTodate(date2));				
	}
	
	public boolean checkBefore(String date1, String date2){
		
		return stringTodate(date1).before(stringTodate(date2));
		
		
	}
	
public boolean checkAfter(String date1, String date2){
		
		return stringTodate(date1).after(stringTodate(date2));
		
		
	}
	
	
	@SuppressWarnings("finally")
	public Date stringTodate(String date) {		
		Date toDate =null;
		try {
			 toDate = fmt.parse(date);
		    } catch (ParseException e) {
		                                 e.printStackTrace();
		                               }
		finally {
			       return toDate;   
		        }
		
	}
	
	
	

}
