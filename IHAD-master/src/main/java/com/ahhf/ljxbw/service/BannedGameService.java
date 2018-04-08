package com.ahhf.ljxbw.service;

import com.ahhf.ljxbw.entity.BannedGameEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public interface BannedGameService {
	
	BannedGameEntity queryObject(Integer id);
	List<BannedGameEntity> selectAllObject();
	List<BannedGameEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BannedGameEntity bannedGame);
	
	void update(BannedGameEntity bannedGame);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
