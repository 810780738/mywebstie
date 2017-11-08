package cn.mywebsite.manage.service.impl;


import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mywebsite.SQLContent.SQLContent;
import cn.mywebsite.data.service.BasicService;
import cn.mywebsite.data.service.BasicServiceDao;
import cn.mywebsite.domain.UserInfo;
import cn.mywebsite.exception.SQLException;
import cn.mywebsite.manage.service.UserManage;
import cn.mywebsite.util.ClazzGetMethod;
import cn.mywebsite.util.StatusRecord;
import cn.mywebsite.util.TimeUtil;

@Service
public class UserManageImpl implements UserManage{

	public static Log logger = LogFactory.getLog(UserManageImpl.class);

	
	@Autowired
	private BasicService basicService;
	
	@Autowired
	private BasicServiceDao basicServiceDao;
	
	private UserInfo userInfos;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addUser(Map<String, Object> map) {
		if (map.size() != 0 && map != null) {
			map.remove("form-repeat-password");
			map.put("CreateTime", TimeUtil.easyTime());
			map.put("userinfo_id", UUID.randomUUID().toString());
//			String sql = "insert into userinfo (userinfo_id,username,loginname,Email,aboutuser,userpassword,createtime) values(?,?,?,?,?,?,?)";
//			String sql = SQLContent.User.INSERT_USER;
//			int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
//					Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
//			int[] types = SQLContent.User.INSERT_USER_TYPES;
			//反射将list中的数据重新放到userinfo中
			try {
				basicServiceDao.addUser(map);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		return StatusRecord.INSERT_FAILURE;
	}
	@Override
	public boolean checkUser(UserInfo userInfo,HttpSession session) {
//		String sql = "select * from userinfo where loginname=? and userpassword=?";
//		int[] types = {Types.VARCHAR,Types.VARCHAR};
		try {
//			userInfos = basicService.findForObject(SQLContent.User.CHECK_USER, UserInfo.class, SQLContent.User.CHECK_USER_TYPES, ClazzGetMethod.getClazz(userInfo).toArray());
			Map<String,Object> map = basicService.baseSelect(UserInfo.class, SQLContent.User.CHECK_USER, ClazzGetMethod.getClazz(userInfo).toArray()).get(0);
			userInfos = (UserInfo) ClazzGetMethod.setMethodValue(new UserInfo(), map);
			session.setAttribute("userInfo", userInfos);
		} catch (Exception e) {
			logger.error("校验登录出错",e);
		}
		if (userInfos != null)
			return true;
		return false;
	}
	
	
	

}
