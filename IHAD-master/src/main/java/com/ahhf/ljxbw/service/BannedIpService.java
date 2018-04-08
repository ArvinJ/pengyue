package com.ahhf.ljxbw.service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.entity.BannedIpEntity;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public interface BannedIpService {
	
	BannedIpEntity queryObject(Integer id);
	List<BannedIpEntity> selectAllObject();
	List<BannedIpEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BannedIpEntity bannedIp);
	
	void update(BannedIpEntity bannedIp);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
