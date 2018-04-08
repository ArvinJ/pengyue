package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.BannedUrlDao;
import com.ahhf.ljxbw.entity.BannedUrlEntity;
import com.ahhf.ljxbw.service.BannedUrlService;



@Service("bannedUrlService")
public class BannedUrlServiceImpl implements BannedUrlService {
	@Autowired
	private BannedUrlDao bannedUrlDao;
	
	@Override
	public BannedUrlEntity queryObject(Integer id){
		return bannedUrlDao.queryObject(id);
	}
	
	@Override
	public List<BannedUrlEntity> queryList(Map<String, Object> map){
		return bannedUrlDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bannedUrlDao.queryTotal(map);
	}
	
	@Override
	public void save(BannedUrlEntity bannedUrl){
		bannedUrlDao.save(bannedUrl);
	}
	
	@Override
	public void update(BannedUrlEntity bannedUrl){
		bannedUrlDao.update(bannedUrl);
	}
	
	@Override
	public void delete(Integer id){
		bannedUrlDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		bannedUrlDao.deleteBatch(ids);
	}

	@Override
	public List<BannedUrlEntity> selectAllObject() {
		return bannedUrlDao.selectAllObject();
	}
	
}
