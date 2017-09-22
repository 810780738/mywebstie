package cn.mywebsite.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ClazzGetMethod ClassDescription:
 *  放射获取实体类中的getter,setter方法的值并重新读对settter重新赋值
 * @author Administrator
 * @Data 2017年9月20日 上午9:45:28
 */
public class ClazzGetMethod {

	/**
	 * MethodDescription:其它类调用这个方法方法
	 * 
	 * @author 朱守明
	 * @Data 2017年9月20日 上午10:26:09
	 * @param model
	 * @return
	 */
	public static List<Object> getClazz(Object model) {
		Field[] field = model.getClass().getDeclaredFields();// 获取实体类中的所有的属性返回Field数组
		// 遍历所有的属性
		List<Object> arrayList = new ArrayList<Object>();
		try {
			for (int i = 0; i < field.length; i++) {
				String name = field[i].getName();
				Object invokeGet = invokeGet(model, name);
				if (invokeGet != null && !invokeGet.equals("".trim()))
					arrayList.add(invokeGet);
			}
		} catch (Exception e) {
			System.err.println("遍历获取所有属性出错" + e);
		}
		return arrayList;
	}

	// 获取get方法
	public static <T> Method getGetMethod(Class<T> clazz, String fieldName) {
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

	// 获取set方法
	public static <T> String setSetMethod(Class<T> clazz, String fieldName) {
		StringBuffer sb = new StringBuffer();
		sb.append("set");
		sb.append(fieldName.substring(0, 1).toUpperCase());
		sb.append(fieldName.substring(1));
		try {
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

	public static <T> Object setMethodValue(Object bean, Map<String, String> map) {
		Class<? extends Object> clazz = bean.getClass();

		Method[] methods = clazz.getDeclaredMethods();// 获取所有的方法

		Field[] fields = clazz.getDeclaredFields();// 获取所有的字段
		try {
			
			for (Field field : fields) {
				
				String fieldName = setSetMethod(clazz, field.getName());
				if (!checkSetMethod(methods, fieldName))
					continue;
				Method method = clazz.getMethod(fieldName, field.getType());
				String value = map.get(field.getName());
				if (value == null && "".trim().equalsIgnoreCase(value))
					continue;
				method.invoke(bean, value);
			}

		} catch (NoSuchMethodException | SecurityException  | IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
			System.err.println("反射赋值出错"+e);
		}

		
		return bean;
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

	/**
	 * 判断是否存在set方法
	 * 
	 * @param methods
	 * @param fieldName
	 * @return
	 */
	public static boolean checkSetMethod(Method[] methods, String fieldName) {
		for (Method method : methods) {
			if (fieldName.equals(method.getName()))
				return true;
		}
		return false;
	}

}
