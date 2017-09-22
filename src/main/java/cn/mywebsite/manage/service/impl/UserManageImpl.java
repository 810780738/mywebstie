package cn.mywebsite.manage.service.impl;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mywebsite.data.service.BasicService;
import cn.mywebsite.manage.service.UserManage;
import cn.mywebsite.util.MapValue;

@Service
public class UserManageImpl implements UserManage{

	@Autowired
	private BasicService basicService;
	@Override
	public int addUser(DataSource dataSource) {
		String sql = "select * from userinfo where userinfo_id=?";
//		 UserInfo findById = basicService.findById(UserInfo.class, sql, "0ee8cc7e-3c47-46fa-b5b1-68ec315f66f9");
		 List<Map<String, Object>> baseSelect = basicService.baseSelect(null, sql, "0ee8cc7e-3c47-46fa-b5b1-68ec315f66f9");
		 List<Object> value = MapValue.getValue(baseSelect);
		return 0;
	}
	
	
	

}
