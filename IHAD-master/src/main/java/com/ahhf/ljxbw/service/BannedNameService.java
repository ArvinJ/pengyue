package com.ahhf.ljxbw.service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.entity.BannedNameEntity;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public interface BannedNameService {
	
	BannedNameEntity queryObject(Integer id);
	List<BannedNameEntity> selectAllObject();
	List<BannedNameEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BannedNameEntity bannedName);
	
	void update(BannedNameEntity bannedName);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
