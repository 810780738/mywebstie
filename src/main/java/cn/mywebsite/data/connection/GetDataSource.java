package cn.mywebsite.data.connection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class GetDataSource {
	 @Bean(name = "primaryDataSource")
	 @Qualifier("primaryDataSource")
	 @ConfigurationProperties(prefix="spring.datasource.primary")//读取配置文件中注册数据源，对@bean不熟悉的可以看我Spring文章中一个有这篇文章
	 public static DataSource primaryDataSource() {
	     return  (DataSource) DataSourceBuilder.create().build();
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
