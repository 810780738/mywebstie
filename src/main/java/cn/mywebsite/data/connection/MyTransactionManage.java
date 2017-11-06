//package cn.mywebsite.data.connection;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//@Configuration
//@PropertySource("application.properties")
//public class MyTransactionManage {
//
//	@Bean
//	@Qualifier("mysqlDB")
//	@ConfigurationProperties("spring.datasource")
//	public DataSource mysqlDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "mysqlJT")
//	public JdbcTemplate mysqlJdbcTemplate(@Qualifier("mysqlDB") DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
//
//	@Bean(name="mysqlTS")
//	public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDB") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//}
