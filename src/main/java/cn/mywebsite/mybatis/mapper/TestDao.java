package cn.mywebsite.mybatis.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.mywebsite.SQLContent.SQLContent;

@Mapper
public interface TestDao {

	@Select(SQLContent.User.FINDUSERBYID)
	public Map<String, Object> findalluser(@Param("ID")String id);
}
