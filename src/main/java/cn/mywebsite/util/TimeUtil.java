package cn.mywebsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

/**
 * ClassName:this is time tool class
 * ClassDescription:
 * @author zhushouming
 * @Data 2017年10月26日 下午5:54:35
 */
public class TimeUtil {
	
	public String customdefault = "yyyy-MM-dd";
	
	private final static SimpleDateFormat EASY_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat CHINA_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	
	
	public final static String easyTime() {
		return EASY_DATE_FORMAT.format(new Date());
	}
	
	
	public final static String chinaTime(){
		return CHINA_DATE_FORMAT.format(new Date());
	}
	
	
	public static String customTime(String customdefault){
		this.customdefault = customdefault;
	}

}
