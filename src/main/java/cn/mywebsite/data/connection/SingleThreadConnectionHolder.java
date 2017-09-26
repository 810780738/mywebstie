package cn.mywebsite.data.connection;

import java.sql.Connection;

import javax.sql.DataSource;


/**
 * 事物管理（单列模式)
 * @author zhushouming
 *
 */
public class SingleThreadConnectionHolder {
	private static volatile ThreadLocal<ConnectionHolder> threadLocal = new ThreadLocal<ConnectionHolder>();
	
	
	private SingleThreadConnectionHolder(){}
	
	private static ConnectionHolder getConnectionHolder() {
		ConnectionHolder connectionHolder = threadLocal.get();
		if (connectionHolder == null) {
			connectionHolder = new ConnectionHolder();
			threadLocal.set(connectionHolder);
		}
		return connectionHolder;
	}
	
	/**
	 * 提供公有的对外访问方法
	 * @param dataSource
	 * @return
	 */
	public static Connection getConnection(DataSource dataSource) {
		return getConnectionHolder().getConnectionDatasource(dataSource);
	}
}
