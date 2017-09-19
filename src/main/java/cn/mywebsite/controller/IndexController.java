package cn.mywebsite.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mywebsite.manage.service.UserManage;

@RestController
public class IndexController {
	
	@Autowired
	private UserManage userManage;
	
	@Autowired
    private DataSource dataSource;
	
	@RequestMapping("/addUser")
	public String index(){
		int addUser = userManage.addUser(dataSource);
		return String.valueOf(addUser);
	}
}
