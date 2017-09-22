package cn.mywebsite.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.mywebsite.domain.UserInfo;
import cn.mywebsite.manage.service.UserManage;
import cn.mywebsite.util.MapValue;



@RestController
public class LoginController {
	
	public static Log logger = LogFactory.getLog(LoginController.class);
	
	
	@Autowired
	private UserManage userManage;
	/**
	 * MethodDescription:跳转到登录页面
	 * @author 朱守明
	 * @Data 2017年9月7日 下午5:49:28
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("public/login");
	}
	
	/**
	 * MethodDescription:跳转到注册页面
	 * @author 朱守明
	 * @Data 2017年9月8日 下午3:42:38
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request){
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, String> arrayValue = MapValue.getArrayValue(parameterMap);
		int addUser = userManage.addUser(arrayValue);
		if (addUser == 1) {
			return new ModelAndView("index");
		} else if (addUser != 1) {
			System.err.println("插入数据出现异常");
		}else{
			return new ModelAndView("public/register");
		}
		return new ModelAndView("public/register");
	}
	
	
	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(@RequestParam("userName")String userName,@RequestParam("passWord")String passWord,  ModelMap map,HttpSession session){
		boolean checkUser = userManage.checkUser(new UserInfo(userName,passWord));
		if (checkUser == true)
			return new ModelAndView("index");
		else
			map.put("userName", userName);
			map.put("passWord", passWord);
			return new ModelAndView("public/login");
	}
}
