package cn.mywebsite.util;

public class StringUtil {
	
	/**
	 * MethodDescription:判断字符串是否为空
	 * @author 朱守明
	 * @Data 2017年10月26日 下午5:30:35
	 * @param string
	 * @return 空返回true
	 */
	public static final boolean isEmpty(String string){
		return string == null || "".equals(string) || string.length()<=0;
	}
	
}
