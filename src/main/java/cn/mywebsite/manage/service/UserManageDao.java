package cn.mywebsite.manage.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import cn.mywebsite.domain.UserInfo;

/**
 * ClassName:UserManageDao
 * ClassDescription:mybatis
 * @author Administrator
 * @Data 2017年11月7日 上午10:56:39
 */
@Service
public interface UserManageDao {
	
	public Map<String, UserInfo> findById(String id);
	
	public boolean modifyById(String id);
	
	public List<UserInfo> findAllUser();

	public boolean addUser(Map<String, Object> map);
}
