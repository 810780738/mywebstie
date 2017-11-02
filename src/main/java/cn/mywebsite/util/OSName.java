package cn.mywebsite.util;

/**
 * ClassName:WinOrLinux
 * ClassDescription:判断环境相关
 * @author Administrator
 * @Data 2017年11月2日 下午4:11:53
 */
public class OSName {
	public final static String Linux= "Linux";
	public final static String Windows= "Windows";
	
	public final static String getOSName(){
		String osName = System.getProperty("os.name");
		if (osName.contains(Windows))
			return Windows;
		else
			return Linux;
	}
}
