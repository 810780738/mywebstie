package cn.mywebsite.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mywebsite.data.service.BasicService;
import cn.mywebsite.domain.UserInfo;
import cn.mywebsite.manage.service.UserManage;

@Service
public class UserManageImpl implements UserManage{

	@Autowired
	private BasicService basicService;
	@Override
	public int addUser(DataSource dataSource) {
		String uuid = UUID.randomUUID().toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		int add = basicService.add(dataSource,new UserInfo(uuid,"小猪", "1234", "男", "23", "安徽",time));
		return add;
	}

}
