package cn.mywebsite.manage.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mywebsite.data.service.BasicServiceDao;
import cn.mywebsite.domain.UserInfo;
import cn.mywebsite.exception.SQLException;
import cn.mywebsite.manage.service.UserManageDao;
@Repository
@Service
public class UserManageDaoImpl implements UserManageDao {

	public static Log logger = LogFactory.getLog(UserManageDaoImpl.class);
	
	@Autowired
	private BasicServiceDao basicServiceDao;
	
	
	@Transactional
	@Override
	public Map<String, UserInfo> findById(String id) {
		@SuppressWarnings("unused")
		Map<String, UserInfo> findById = null;
		try {
//			findById = userManageDao.findById(id);
			@SuppressWarnings("unused")
			Map<String, Object> findUserById = basicServiceDao.findUserById(id);
		} catch (SQLException e) {
			logger.error("根据id查找出错",e);
		}
		return null;
	}

	@Override
	public boolean modifyById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserInfo> findAllUser() {
		List<UserInfo> findAllUser = null;
		try {
			findAllUser = basicServiceDao.findAllUser();
		} catch (SQLException e) {
			logger.error("查找所有用户出错",e);
		}
		System.out.println(findAllUser);
		return findAllUser;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean addUser(Map<String, Object> map) {
		try {
			basicServiceDao.addUser(map);
		} catch (SQLException e) {
			logger.error("添加用户出错",e);
		}
		return false;
	}

}
