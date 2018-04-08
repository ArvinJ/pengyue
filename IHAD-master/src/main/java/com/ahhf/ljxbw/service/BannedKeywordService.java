package com.ahhf.ljxbw.service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.entity.BannedKeywordEntity;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public interface BannedKeywordService {
	
	BannedKeywordEntity queryObject(Integer id);
	List<BannedKeywordEntity> selectAllObject();
	List<BannedKeywordEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BannedKeywordEntity bannedKeyword);
	
	void update(BannedKeywordEntity bannedKeyword);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
