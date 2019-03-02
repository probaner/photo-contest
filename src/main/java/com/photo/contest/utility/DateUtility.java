package com.photo.contest.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtility {
	
	
	public boolean checkEquals(Date date1, Date date2){
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		System.out.println(fmt.format(date1).equals(fmt.format(date2)));
		return fmt.format(date1).equals(fmt.format(date2));		
		
	}
	
	@SuppressWarnings("finally")
	public Date stringTodate(String date) {
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
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
