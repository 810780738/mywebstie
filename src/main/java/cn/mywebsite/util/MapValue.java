package cn.mywebsite.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName:MapValue
 * ClassDescription:通用获取map中的getValue的值
 * @author 朱守明
 * @param <T>
 * @param <T>
 * @Data 2017年9月21日 下午3:30:49
 */
public class MapValue {

	/**
	 * MethodDescription:获取所有的key值
	 * @author 朱守明
	 * @Data 2017年9月21日 下午3:42:16
	 * @param list
	 * @return
	 */
	public final static <T> List<Object>  getValue(List<Map<String, Object>> list){
		List<Object> mapKey = new ArrayList<Object>();
		//因为foreach循环内部使用的是迭代器进行遍历，所以保证了内部顺序的出准确性
		for (Map<String, Object> map : list) {
			for(Object obj : map.values()){
				mapKey.add(obj);
			}
		}
		return mapKey;
	}
	
}
