package com.ahhf.ljxbw.service;

import com.ahhf.ljxbw.entity.UserInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 14:46:39
 */
public interface UserInfoService {
	
	UserInfoEntity queryObject(Integer id);
	
	List<UserInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserInfoEntity userInfo);
	
	void update(UserInfoEntity userInfo);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
