package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Calendar getTodayDateTime() {
		// get a calendar instance, which defaults to "now"
	    Calendar calendar = Calendar.getInstance();
	    
	    
	    return calendar;
	}
	
	public static Date getTomorrowDate() {
		getTodayDateTime().add(Calendar.DAY_OF_YEAR, 1);
		
		Date tomorrow = getTodayDateTime().getTime();
		
		return tomorrow;
	}
	
	public static String getFormattedDate(Date date, String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern); 
		return dateFormat.format(date);
	}

}
