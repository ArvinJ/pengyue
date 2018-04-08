package com.ahhf.ljxbw.service;

import com.ahhf.ljxbw.entity.ComputerstatisicsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 10:03:36
 */
public interface ComputerstatisicsService {
	
	ComputerstatisicsEntity queryObject(Integer id);
	
	List<ComputerstatisicsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComputerstatisicsEntity computerstatisics);
	
	void update(ComputerstatisicsEntity computerstatisics);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
