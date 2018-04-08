package com.ahhf.ljxbw.service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.entity.BannedUrlEntity;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public interface BannedUrlService {
	
	BannedUrlEntity queryObject(Integer id);
	List<BannedUrlEntity> selectAllObject();
	List<BannedUrlEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BannedUrlEntity bannedUrl);
	
	void update(BannedUrlEntity bannedUrl);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
