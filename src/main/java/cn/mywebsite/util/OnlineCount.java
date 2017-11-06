package cn.mywebsite.util;

/**
 * ClassName:OnlineCount
 * ClassDescription:记录用户在线数量
 * @author Administrator
 * @Data 2017年11月3日 下午3:26:53
 */
public class OnlineCount {

	private static int onLineCount = 0;
	
	/**
	 * MethodDescription:添加在线数量
	 * @author 朱守明
	 * @Data 2017年11月3日 下午3:27:55
	 */
	public static synchronized void addLineCount() {
		onLineCount++;
	}

	public static synchronized void removeLineCount() {
		onLineCount--;
	}

	public static int getOnLineCount() {
		return onLineCount;
	}
	
}
