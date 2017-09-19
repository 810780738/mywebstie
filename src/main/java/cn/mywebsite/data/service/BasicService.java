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
}
