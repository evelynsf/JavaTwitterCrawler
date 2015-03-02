package settings;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Time stamp configuration
 * @author Evelyn
 *
 */
public class TimeStamp {
	
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DAY_FORMAT = "yyyy-MM-dd";
	public static final String DAY_FORMAT_BR = "dd-MM-yyyy";
	public static final String HOUR_FORMAT = "HH:mm:ss";
	public static final String DAY_WEEK_MONTH_YEAR = "EEE MMM d yyyy";

	private Calendar calendar; 
	private SimpleDateFormat date;
	//time when status was created
	private String createdAt;
	
	/*
	 * Constructor
	 */
	public TimeStamp(){
		calendar = Calendar.getInstance();
	}
	
    private String getDate(String format){
    	date = new SimpleDateFormat(format);
    	return date.format(calendar.getTime());
    }
    
    public String getTimeFormat(){
    	return getDate(TIME_FORMAT);
    }
    
    public String getDateFormat(){
    	return getDate(DAY_FORMAT);
    }
    
    public String getDayFormatBR(){
    	return getDate(DAY_FORMAT_BR);
    }
    
    public String getHourFormat(){
    	return getDate(HOUR_FORMAT);
    }
    
    public String getDayWeekFormat(){
    	return getDate(DAY_WEEK_MONTH_YEAR);
    }

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
