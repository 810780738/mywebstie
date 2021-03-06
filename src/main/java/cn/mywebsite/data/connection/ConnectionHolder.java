package cn.mywebsite.data.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;



public class ConnectionHolder {
	private Map<DataSource,Connection> map = new HashMap<DataSource, Connection>();
	
	public Connection getConnectionDatasource(DataSource dataSource) {
		Connection connection = map.get(dataSource);
		try {
			if (connection == null || connection.isClosed()) {
				connection = dataSource.getConnection();
				map.put(dataSource, connection);
			}
		} catch (SQLException e) {
			System.err.println("数据管道发生异常:"+e);
		}
		return connection;
	}

}
