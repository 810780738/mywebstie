package cn.mywebsite.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * ClassName:this is time tool class
 * ClassDescription:
 * @author zhushouming
 * @Data 2017年10月26日 下午5:54:35
 */
public class TimeUtil {
	
	public static Log logger = LogFactory.getLog(TimeUtil.class);
	
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
	
	public static Date convertToDate(String pattern, Date defValue){
		try {
			return EASY_DATE_FORMAT.parse(pattern);
		} catch (ParseException e) {
			logger.warn(String.format("无法将[%s]字符串转化成日期格式，异常信息：%s", pattern, e.getMessage()));
			return defValue;
		}
	}
	
	public static void main(String[] args) {
		Date convertToDate = convertToDate("2017-10-23 14:48:09.0",Calendar.getInstance().getTime());
		String format = EASY_DATE_FORMAT.format(convertToDate);
		System.out.println(format);
	}
	
}
