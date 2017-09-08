package cn.mywebsite.manage.service.impl;

import java.util.UUID;

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
	public int addUser() {
		String uuid = UUID.randomUUID().toString();
		int add = basicService.add(new UserInfo(uuid,"小猪", "1234", "男", "23", "安徽"));
		return add;
	}

}
