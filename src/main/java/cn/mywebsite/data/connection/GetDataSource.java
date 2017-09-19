package cn.mywebsite.data.connection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class GetDataSource {
	
	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	DataSourceProperties dataSourceProperties;
	
	 public DataSource primaryDataSource() {
		 DataSource dataSource = applicationContext.getBean(DataSource.class);
	     return  dataSource;
	 }
	 
	    @Value("${spring.datasource.driver-class-name}")
	    String driverClass;
	    @Value("${spring.datasource.url}")
	    String url;
	    @Value("${spring.datasource.username}")
	    String userName;
	    @Value("${spring.datasource.password}")
	    String passWord;

	    @Bean(name = "dataSource")
	    public DataSource dataSource() {

	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(driverClass);
	    dataSource.setUrl(url);
	    dataSource.setUsername(userName);
	    dataSource.setPassword(passWord);
//	    return dataSource;
	    return null;
	    }
}
