package cn.mywebsite.data.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import cn.mywebsite.domain.UserInfo;

@Service
public interface BasicService {
	public <T> List<Map<String, Object>> getUser(String sql);
	
	public int add(DataSource dataSource, UserInfo userInfo);
	
	/**
	 * MethodDescription:jdbcTemplet通用插入方法
	 * @author 朱守明
	 * @Data 2017年9月20日 上午9:37:25
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> int insertUser(Class<T> clazz,String sql,Object... args);
	
	/**
	 * MethodDescription:通用查询方法
	 * @author 朱守明
	 * @Data 2017年9月21日 上午9:39:39
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<Map<String, Object>> baseSelect(Class<T> clazz,String sql,Object...args);
	
	/**
	 * MethodDescription:根据id查找
	 * @author 朱守明
	 * @Data 2017年9月21日 上午9:41:00
	 * @param clazz 类型
	 * @param sql SQL语句
	 * @param id 数据库表
	 * @return
	 */
	public <T> T findById(Class<T> clazz,String sql,Object id);
}
