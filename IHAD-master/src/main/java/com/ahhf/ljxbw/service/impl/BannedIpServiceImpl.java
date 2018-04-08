package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.BannedIpDao;
import com.ahhf.ljxbw.entity.BannedIpEntity;
import com.ahhf.ljxbw.service.BannedIpService;



@Service("bannedIpService")
public class BannedIpServiceImpl implements BannedIpService {
	@Autowired
	private BannedIpDao bannedIpDao;
	
	@Override
	public BannedIpEntity queryObject(Integer id){
		return bannedIpDao.queryObject(id);
	}
	
	@Override
	public List<BannedIpEntity> queryList(Map<String, Object> map){
		return bannedIpDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bannedIpDao.queryTotal(map);
	}
	
	@Override
	public void save(BannedIpEntity bannedIp){
		bannedIpDao.save(bannedIp);
	}
	
	@Override
	public void update(BannedIpEntity bannedIp){
		bannedIpDao.update(bannedIp);
	}
	
	@Override
	public void delete(Integer id){
		bannedIpDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		bannedIpDao.deleteBatch(ids);
	}

	@Override
	public List<BannedIpEntity> selectAllObject() {
		return bannedIpDao.selectAllObject();
	}
	
}
