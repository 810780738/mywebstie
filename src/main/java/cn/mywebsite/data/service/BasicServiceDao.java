package cn.mywebsite.data.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.mywebsite.SQLContent.SQLContent;
import cn.mywebsite.domain.UserInfo;
import cn.mywebsite.exception.SQLException;

@Mapper
public interface BasicServiceDao {

	@Select(SQLContent.User.FINDUSERBYID)
	public Map<String, Object> findUserById(@Param("ID") String id) throws SQLException;

	@Select(SQLContent.User.FINDALLUSER)
	public List<UserInfo> findAllUser() throws SQLException;

	@Insert(SQLContent.User.INSERTUSER)
	public void addUser(Map<String, Object> paramMap) throws SQLException;
	
	@Delete(SQLContent.User.DELETEBYID)
	public void deleteById(@Param("USERID") String id) throws SQLException;
}
