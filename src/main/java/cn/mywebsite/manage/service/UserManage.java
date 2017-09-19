package cn.mywebsite.manage.service;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service
public interface UserManage {
	public int addUser(DataSource dataSource);
}
