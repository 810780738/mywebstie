package cn.mywebsite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

import cn.mywebsite.manage.service.UserManage;
import cn.mywebsite.mybatis.mapper.TestDao;


@RestController
public class IndexController {
	
	@Autowired
	private UserManage userManage;
	
	@Autowired
	private TestDao testDao;
	
	
	@RequestMapping("/addUser")
	public String index(){
//		int addUser = userManage.addUser(null);
//		return Integer.toBinaryString(addUser);
		java.util.Map<String, Object> findalluser = testDao.findalluser("0520962f-1887-4222-8780-423b50bd32a9");
		System.out.println(findalluser);
		return "嫩";
	}
	
}
