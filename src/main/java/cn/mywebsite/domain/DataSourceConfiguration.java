package cn.mywebsite.domain;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfiguration {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.max-idle}")
	private int maxIdel;
	
	@Value("${spring.datasource.max-wait}")
	private long maxWait;
	
	@Value("${spring.datasource.min-idle}")
	private int minIdel;
	
	@Value("${spring.datasource.initial-size}")
	private int initialSize;
	
	@Value("${spring.datasource.validation-query}")
	private String validationQuery;
	
	@Value("${spring.datasource.test-on-borrow}")
	private boolean borrow;
	
	@Value("${spring.datasource.test-while-idle}")
	private boolean whileIdle;
	
	@Value("${spring.datasource.time-between-eviction-runs-millis}")
	private long millis;
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setMaxIdle(maxIdel);
		basicDataSource.setMaxWait(maxWait);
		basicDataSource.setMinIdle(minIdel);
		basicDataSource.setInitialSize(initialSize);
		basicDataSource.setValidationQuery(validationQuery);
		basicDataSource.setTestOnBorrow(borrow);
		basicDataSource.setTestWhileIdle(whileIdle);
		basicDataSource.setTimeBetweenEvictionRunsMillis(millis);
		return basicDataSource;
	}
	
	
}
