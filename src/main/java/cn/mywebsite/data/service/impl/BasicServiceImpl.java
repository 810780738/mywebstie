package cn.mywebsite.data.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.mywebsite.data.service.BasicService;
import cn.mywebsite.domain.UserInfo;

@Repository
public class BasicServiceImpl implements BasicService {

	public static Log logger = LogFactory.getLog(BasicServiceImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplet;

	@Override
	public <T> List<Map<String, Object>> getUser(String sql) {
		try {
			return jdbcTemplet.queryForList(sql);
		} catch (DataAccessException e) {
			logger.error("数据模型层：通用查询出错！", e);
		}
		return null;
	}

	@Override
	public int add(UserInfo userInfo) {
		int update = 0;
		String sql = "insert into userinfo(userinfo_id,username,userpassword,sex,address,age)values(?,?,?,?,?,?)";
		try {
			update = jdbcTemplet.update(sql,new Object[]{userInfo.getUser_id(),userInfo.getUserName(),userInfo.getUserPassword(),userInfo.getSex(),userInfo.getAddress(),userInfo.getAge()});
		} catch (DataAccessException e) {
			logger.error("数据模型层：通用插入数据出错！", e);
		}
		return update;
	}

}
