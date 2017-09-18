package cn.mywebsite.data.connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;

/**
 * 事物管理
 * @author zhushouming
 *
 */
public class TransactionManager {
	private DataSource dataSource;
	
	public TransactionManager(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private Connection getConnection() {
		return SingleThreadConnectionHolder.getConnection(dataSource);
	}
	
	//开启事物
	public void start() {
		Connection connection = getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println("关闭自动提交出错:"+e);
		}
	}
	
	//回滚
	public void rollback() {
		Connection connection = null;
		try {
			connection = getConnection();
			connection.rollback();
		} catch (SQLException e) {
			System.err.println("回滚出错："+e);
		}
		
	}
	
	public void close() {
		Connection connection = getConnection();
		try {
			connection.setAutoCommit(false);
			connection.close();
		} catch (SQLException e) {
			System.err.println("关闭事物出错:"+e);
		}
		
	}
	
	
	
}
