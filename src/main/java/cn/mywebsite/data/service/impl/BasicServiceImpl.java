package cn.mywebsite.data.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.mywebsite.data.service.BasicService;
import cn.mywebsite.domain.UserInfo;

@Repository
public class BasicServiceImpl implements BasicService {

	public static Log logger = LogFactory.getLog(BasicServiceImpl.class);

	@Resource(name = "mysqlJT")
	private JdbcTemplate jdbcTemplet;

	@Override
	public <T> List<Map<String, Object>> getUser(String sql) {
		return jdbcTemplet.queryForList(sql);
	}

	@Override
	public int add(DataSource dataSource, UserInfo userInfo) {
		String sql = "insert into lee(id,name,birthday)values(?,?,now())";
		return jdbcTemplet.update(sql, new Object[] { 2, "小米" });
	}

	@Override
	public <T> int insertUser(Class<T> clazz, String sql, Object... args) {
		return jdbcTemplet.update(sql, args);
	}

	@Override
	public <T> List<Map<String, Object>> baseSelect(Class<T> clazz, String sql, Object... args) {
		return jdbcTemplet.queryForList(sql, args);
	}

	@Override
	public <T> T findById(Class<T> clazz, String sql, Object id) {
		return jdbcTemplet.queryForObject(sql, new Object[] { id }, clazz);
	}

}
