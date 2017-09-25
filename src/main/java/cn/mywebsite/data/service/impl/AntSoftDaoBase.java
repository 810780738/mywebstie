package cn.mywebsite.data.service.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AntSoftDaoBase {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	private String tableName;

	protected AntSoftDaoBase(String tableName) {
		this.tableName = tableName;
	}

	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void clearAll() {
		getJdbcTemplate().update("DELETE FROM " + tableName);
	}
 
	public int count() {
		return getJdbcTemplate().queryForObject( "SELECT COUNT(*) FROM " + tableName, Integer.class);
	}
	
	
}
