package cn.mywebsite.manage.service.impl;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mywebsite.data.service.BasicService;
import cn.mywebsite.domain.UserInfo;
import cn.mywebsite.manage.service.UserManage;
import cn.mywebsite.util.ClazzGetMethod;
import cn.mywebsite.util.TimeUtil;

@Service
public class UserManageImpl implements UserManage{

	public static Log logger = LogFactory.getLog(UserManageImpl.class);

	
	@Autowired
	private BasicService basicService;
	
	@Transactional(transactionManager = "mysqlTS",rollbackFor = Exception.class)
	@Override
	public int addUser(Map<String, String> map) {
//		UserInfo userInfo = new UserInfo();
		try {
			basicService.add(null, null);
			int i = 1/0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		if (map.size() != 0 && map != null) {
//			map.remove("form-repeat-password");
//			map.put("CreateTime", TimeUtil.easyTime());
//			map.put("user_id", UUID.randomUUID().toString());
//			String sql = "insert into userinfo (userinfo_id,username,loginname,Email,aboutuser,userpassword,createtime) values(?,?,?,?,?,?,?)";
//			//反射将list中的数据重新放到userinfo中
//			return  basicService.insertUser(UserInfo.class, sql, ClazzGetMethod.getClazz(ClazzGetMethod.setMethodValue(userInfo, map)).toArray());
//		}
		return 0;
	}
	@Override
	public boolean checkUser(UserInfo userInfo) {
		String sql = "select * from userinfo where loginname=? and userpassword=?;";
		List<Map<String, Object>> baseSelect = null;
		try {
			baseSelect = basicService.baseSelect(UserInfo.class, sql, ClazzGetMethod.getClazz(userInfo).toArray());
		} catch (Exception e) {
			logger.error("校验登录出错",e);
		}
		if (baseSelect != null && baseSelect.size() == 1)
			return true;
		return false;
	}
	
	
	

}
