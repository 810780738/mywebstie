package cn.mywebsite.data.service.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.mywebsite.data.connection.TransactionManager;
import cn.mywebsite.data.service.BasicService;
import cn.mywebsite.domain.UserInfo;

@Repository
public class BasicServiceImpl implements BasicService {

	public static Log logger = LogFactory.getLog(BasicServiceImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplet;
	
	private TransactionManager transactionManager;

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
	public int add(DataSource dataSource,UserInfo userInfo) {
		if(transactionManager == null)
			transactionManager = new TransactionManager(dataSource);
		transactionManager.start();//开启事物
		int update = 0;
		String sql = "insert into userinfo(userinfo_id,username,userpassword,sex,address,age,createtime)values(?,?,?,?,?,?,?)";
		try {
			jdbcTemplet.setDataSource(dataSource);
			update = jdbcTemplet.update(sql,new Object[]{userInfo.getUser_id(),userInfo.getUserName(),userInfo.getUserPassword(),userInfo.getSex(),userInfo.getAddress(),userInfo.getAge(),userInfo.getCreateTime()});
			System.out.println(1/0);
			transactionManager.close();
		} catch (Exception e) {
			logger.error("数据模型层：通用插入数据出错！", e);
			System.err.println("插入数据发生异常：回滚");
			transactionManager.rollback();
			transactionManager.close();
		}
		return update;
	}

}
