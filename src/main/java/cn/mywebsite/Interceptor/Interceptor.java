//package cn.mywebsite.Interceptor;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.LinkedHashSet;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//
///**
// * ClassName:InterceptorController
// * ClassDescription:基于AOP的拦截器
// * @author Administrator
// * @Data 2017年9月22日 上午10:21:50
// */
//
//@Aspect
//@Component
//public class Interceptor {
//	private static final Logger logger = Logger.getLogger(Interceptor.class);
//	
//	
//	@Value("${spring.profiles}")//注入配置文件
//	private String  evn;
//	/**
//	 * MethodDescription:拦截所有controller中requestmapping的注解方法
//	 * @author 朱守明
//	 * @Data 2017年9月22日 上午10:32:35
//	 */
//	@Pointcut("execution(* cn.mywebsite.controller..*(..)) and @annotation((org.springframework.web.bind.annotation.RequestMapping)")
//	public void controllerMethodPointcut(){}
//	
//	
//	@Around("controllerMethodPointcut()")//指定拦截器规则
//	public Object interceptor(ProceedingJoinPoint pjp){
//		long startTime = System.currentTimeMillis();
//		MethodSignature signature = (MethodSignature) pjp.getSignature();
//		Method method = signature.getMethod();//获取拦截的方法
//		String methodName = method.getName();//获取拦截的方法名
//		Set<Object> allParams = new LinkedHashSet<Object>();
//		
//		logger.info("获取到开始的请求，方法名："+methodName);
//		
//		Object result = null;
//		
//		Object[] args = pjp.getArgs();
//		
//		for (Object arg : args) {
//			if (arg instanceof Map<?, ?>) {
//				@SuppressWarnings("unchecked")
//				Map<String, Object> map = (Map<String, Object>) arg;
//				allParams.add(map);
//			}else if (arg instanceof HttpServletRequest) {
//				//校验request请求
//				HttpServletRequest request = (HttpServletRequest) arg;
//				if (isLoginRequired(method)) {
//					//校验是否登录
//					if (!isLogin(request)) {
//						//未登录
////						result = new JsonResult(ResultCode);
//						HttpServletResponse response = (HttpServletResponse) arg;
//						try {
//							response.sendRedirect("/login");
//						} catch (IOException e) {
//							logger.error("response重定向异常",e);
//						}
//					}
//				}
//				
//				Map<String, String[]> parameterMap = request.getParameterMap();
//				if (parameterMap != null && parameterMap.size() > 0) {
//					allParams.add(parameterMap);
//				}
//			}else if (arg instanceof HttpServletResponse) {
//				//do some thing
//			}else {
//				
//			}
//		}
//		
//		
//		if (result == null) {
//			try {
//				result = pjp.proceed();
//			} catch (Throwable e) {
//				logger.error("发生了一些异常",e);
//			}
//		}
//		
//		long end = System.currentTimeMillis();
//		System.out.println("请求耗时:"+(end-startTime)+"毫秒");
//		return result;
//	}
//	
//	
//	
//
//	public boolean isLoginRequired(Method method) {
//		//判断是否是生产环境
//		if (!evn.equals("prod")) {
//			return false;
//		}
//		boolean result = true;
//		
////		if (method.isAnnotationPresent(Permission.class)) {
////			
////		}
//		return result;
//	}
//	
//	//判断是否已经登陆 
//	public boolean isLogin(HttpServletRequest request){
//		Object attribute = request.getAttribute("userInfo");
//		if (attribute == null || !(attribute instanceof String)){
//			logger.info("用户未登录");
//			return false;
//		}
//		return true;
//	}
//	
//	
//}
