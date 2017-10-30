package cn.mywebsite.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName:this is time tool class
 * ClassDescription:
 * @author zhushouming
 * @Data 2017年10月26日 下午5:54:35
 */
public class TimeUtil {
	
	public static final String customdefault = "yyyy-MM-dd";
	
	private final static SimpleDateFormat EASY_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat CHINA_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	
	
	public final static String easyTime() {
		return EASY_DATE_FORMAT.format(Calendar.getInstance().getTime());
	}
	
	
	public final static String chinaTime(){
		return CHINA_DATE_FORMAT.format(Calendar.getInstance().getTime());
	}
	
	
	public static String customTime(String customdefault){
//		this.customdefault = customdefault;
		return null;
	}
	
	
	public static int generateDateDay(Date date){
		Calendar cal = Calendar.getInstance();
		if (date == null)date = cal.getTime();
		cal.setTime(date);
		return cal.get(Calendar.YEAR) * 10000 
				+ ((cal.get(Calendar.MONTH) + 1) * 100) 
				+ cal.get(Calendar.DAY_OF_MONTH);
	}
	
}
