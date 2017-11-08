package cn.mywebsite.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

import cn.mywebsite.data.service.BasicServiceDao;
import cn.mywebsite.domain.UserInfo;
import cn.mywebsite.manage.service.UserManage;
import cn.mywebsite.manage.service.UserManageDao;


@RestController
public class IndexController {
	
	@Autowired
	private UserManage userManage;
	
	@Autowired
	private UserManageDao userManageDao;
	
	
	@RequestMapping("/addUser")
	public String index(){
//		int addUser = userManage.addUser(null);
//		return Integer.toBinaryString(addUser);
//		userManageDao.findById("0520962f-1887-4222-8780-423b50bd32a9");
//		List<UserInfo> findAllUser = userManageDao.findAllUser();
//		userManageDao.addUser(null);
//		System.out.println(findalluser);
		return "";
	}
	
}
