package cn.mywebsite.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ClazzGetMethod
 * ClassDescription:放射获取实体类中的get方法的值
 * @author Administrator
 * @Data 2017年9月20日 上午9:45:28
 */
public class ClazzGetMethod {
	
	/**
	 * MethodDescription:其它类调用这个方法方法
	 * @author 朱守明
	 * @Data 2017年9月20日 上午10:26:09
	 * @param model
	 * @return
	 */
	public static List<Object> getClazz(Object model){
		Field[] field = model.getClass().getDeclaredFields();//获取实体类中的所有的属性返回Field数组
		//遍历所有的属性
		List<Object> arrayList = new ArrayList<Object>();
		try {
			for (int i = 0; i < field.length; i++) {
				String name = field[i].getName();
				Object invokeGet = invokeGet(model,name);
				if(invokeGet != null && !invokeGet.equals("".trim()))
					arrayList.add(invokeGet);
			}
		} catch (Exception e) {
			System.err.println("遍历获取所有属性出错"+e);
		}
		return arrayList;
	}
	
	//获取get方法
	public static <T> Method getGetMethod(Class<T> clazz,String fieldName){
		  StringBuffer sb = new StringBuffer();  
	       sb.append("get");  
	       sb.append(fieldName.substring(0, 1).toUpperCase());  
	       sb.append(fieldName.substring(1));  
	       try {  
	           return clazz.getMethod(sb.toString());  
	       } catch (Exception e) {  
	       }  
	       return null;  
	}
	
	//获取set方法
	public static <T> Method setSetMethod(Class<T> clazz,String fieldName){
		  StringBuffer sb = new StringBuffer();  
	       sb.append("set");
	       sb.append(fieldName.substring(0, 1).toUpperCase());  
	       sb.append(fieldName.substring(1));  
	       try {  
	           return clazz.getMethod(sb.toString());  
	       } catch (Exception e) {  
	       }  
	       return null;  
	}
	
	
	/**
	 * MethodDescription:获取值
	 * @author 朱守明
	 * @Data 2017年9月20日 上午10:26:58
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Object invokeGet(Object object, String fieldName) {  
        Method method = getGetMethod(object.getClass(), fieldName);  
        try {  
            return method.invoke(object, new Object[0]);  
        } catch (Exception e) {
            e.printStackTrace();  
        }  
        return null;  
    }
	
	
	
}
