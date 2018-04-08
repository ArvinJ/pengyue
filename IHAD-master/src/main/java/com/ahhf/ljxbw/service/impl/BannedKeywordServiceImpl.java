package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.BannedKeywordDao;
import com.ahhf.ljxbw.entity.BannedKeywordEntity;
import com.ahhf.ljxbw.service.BannedKeywordService;



@Service("bannedKeywordService")
public class BannedKeywordServiceImpl implements BannedKeywordService {
	@Autowired
	private BannedKeywordDao bannedKeywordDao;
	
	@Override
	public BannedKeywordEntity queryObject(Integer id){
		return bannedKeywordDao.queryObject(id);
	}
	
	@Override
	public List<BannedKeywordEntity> queryList(Map<String, Object> map){
		return bannedKeywordDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bannedKeywordDao.queryTotal(map);
	}
	
	@Override
	public void save(BannedKeywordEntity bannedKeyword){
		bannedKeywordDao.save(bannedKeyword);
	}
	
	@Override
	public void update(BannedKeywordEntity bannedKeyword){
		bannedKeywordDao.update(bannedKeyword);
	}
	
	@Override
	public void delete(Integer id){
		bannedKeywordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		bannedKeywordDao.deleteBatch(ids);
	}

	@Override
	public List<BannedKeywordEntity> selectAllObject() {
		return bannedKeywordDao.selectAllObject();
	}
	
}
