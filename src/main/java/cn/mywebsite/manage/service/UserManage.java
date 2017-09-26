package cn.mywebsite.manage.service;



import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.mywebsite.domain.UserInfo;

@Service
public interface UserManage {
	//添加用户
	public int addUser(Map<String, String> map);
	
	/**
	 * 用户校验
	 * @param userInfo
	 * @param session 
	 * @return
	 */
	public boolean checkUser(UserInfo userInfo, HttpSession session);
	
}
