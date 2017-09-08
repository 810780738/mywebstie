package cn.mywebsite.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class LoginController {
	
	public static Log logger = LogFactory.getLog(LoginController.class);
	
	/**
	 * MethodDescription:跳转到登录页面
	 * @author 朱守明
	 * @Data 2017年9月7日 下午5:49:28
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(){
		logger.info("进入登录页面。。。");
		return new ModelAndView("public/login");
	}
	
	/**
	 * MethodDescription:跳转到注册页面
	 * @author 朱守明
	 * @Data 2017年9月8日 下午3:42:38
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(){
		logger.info("进入注册页面。。。");
		return new ModelAndView("public/register");
	}
	
	
	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(@RequestParam("")String usrename,@RequestParam("password")String password,  ModelMap map){
		System.out.println(usrename+password);
		return null;
	}
}
