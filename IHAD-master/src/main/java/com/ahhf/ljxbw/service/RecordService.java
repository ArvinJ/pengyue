package com.ahhf.ljxbw.service;

import com.ahhf.ljxbw.entity.RecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 09:29:05
 */
public interface RecordService {
	
	RecordEntity queryObject(Integer id);
	
	List<RecordEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RecordEntity record);
	
	void update(RecordEntity record);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
