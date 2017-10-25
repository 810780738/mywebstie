package cn.mywebsite.exception;

/**
 * ClassName:自定义异常处理类
 * ClassDescription:
 * @author Administrator
 * @Data 2017年10月25日 上午10:05:11
 */
public class SQLException extends Exception {

	private static final long serialVersionUID = -4904391491698069418L;

	public final static int SQL_ERROR = 100;

	public final static int DISRUPTOR_ERROR = 200;

	public final static int BUSINESS_ERROR = 300;

	public final static int CONFIG_ERROR = 400;

	private int errType;

	
	
	public SQLException(String message, int errorType) {
		super(message);
		this.errType = errorType;
	}



	public SQLException(String message) {
		super(message);
		errType = DISRUPTOR_ERROR;
	}



	public int getErrType() {
		return errType;
	}
	
}
