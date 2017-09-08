package cn.mywebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mywebsite.manage.service.UserManage;

@RestController
public class IndexController {
	
	@Autowired
	private UserManage userManage;
	
	@RequestMapping("/addUser")
	public String index(){
		int addUser = userManage.addUser();
		return String.valueOf(addUser);
	}
}
