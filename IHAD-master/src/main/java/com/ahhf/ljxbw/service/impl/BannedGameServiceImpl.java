package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.BannedGameDao;
import com.ahhf.ljxbw.entity.BannedGameEntity;
import com.ahhf.ljxbw.service.BannedGameService;



@Service("bannedGameService")
public class BannedGameServiceImpl implements BannedGameService {
	@Autowired
	private BannedGameDao bannedGameDao;
	
	@Override
	public BannedGameEntity queryObject(Integer id){
		return bannedGameDao.queryObject(id);
	}
	
	@Override
	public List<BannedGameEntity> queryList(Map<String, Object> map){
		return bannedGameDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bannedGameDao.queryTotal(map);
	}
	
	@Override
	public void save(BannedGameEntity bannedGame){
		bannedGameDao.save(bannedGame);
	}
	
	@Override
	public void update(BannedGameEntity bannedGame){
		bannedGameDao.update(bannedGame);
	}
	
	@Override
	public void delete(Integer id){
		bannedGameDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		bannedGameDao.deleteBatch(ids);
	}

	@Override
	public List<BannedGameEntity> selectAllObject() {
		return bannedGameDao.selectAllObject();
	}
	
}
