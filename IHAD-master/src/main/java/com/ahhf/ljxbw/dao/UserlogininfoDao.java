package com.ahhf.ljxbw.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ahhf.ljxbw.entity.UserlogininfoEntity;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-04 13:12:55
 */
@Mapper
public interface UserlogininfoDao {

	UserlogininfoEntity queryObject(Integer id);

	List<UserlogininfoEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(UserlogininfoEntity userlogininfo);

	void update(UserlogininfoEntity userlogininfo);

	void delete(Integer id);

	void deleteBatch(Integer[] ids);
	
}
