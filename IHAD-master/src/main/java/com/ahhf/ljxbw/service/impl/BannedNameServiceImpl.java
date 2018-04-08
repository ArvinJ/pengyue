package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.BannedNameDao;
import com.ahhf.ljxbw.entity.BannedNameEntity;
import com.ahhf.ljxbw.service.BannedNameService;



@Service("bannedNameService")
public class BannedNameServiceImpl implements BannedNameService {
	@Autowired
	private BannedNameDao bannedNameDao;
	
	@Override
	public BannedNameEntity queryObject(Integer id){
		return bannedNameDao.queryObject(id);
	}
	
	@Override
	public List<BannedNameEntity> queryList(Map<String, Object> map){
		return bannedNameDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bannedNameDao.queryTotal(map);
	}
	
	@Override
	public void save(BannedNameEntity bannedName){
		bannedNameDao.save(bannedName);
	}
	
	@Override
	public void update(BannedNameEntity bannedName){
		bannedNameDao.update(bannedName);
	}
	
	@Override
	public void delete(Integer id){
		bannedNameDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		bannedNameDao.deleteBatch(ids);
	}

	@Override
	public List<BannedNameEntity> selectAllObject() {
		return bannedNameDao.selectAllObject();
	}
	
}
