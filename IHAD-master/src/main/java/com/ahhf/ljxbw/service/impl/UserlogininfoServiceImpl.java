package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahhf.ljxbw.dao.UserlogininfoDao;
import com.ahhf.ljxbw.entity.UserlogininfoEntity;
import com.ahhf.ljxbw.service.UserlogininfoService;

import java.util.List;
import java.util.Map;




@Service("userlogininfoService")
public class UserlogininfoServiceImpl implements UserlogininfoService {
	@Autowired
	private UserlogininfoDao userlogininfoDao;
	
	@Override
	public UserlogininfoEntity queryObject(Integer id){
		return userlogininfoDao.queryObject(id);
	}
	
	@Override
	public List<UserlogininfoEntity> queryList(Map<String, Object> map){
		return userlogininfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userlogininfoDao.queryTotal(map);
	}
	
	@Override
	public void save(UserlogininfoEntity userlogininfo){
		userlogininfoDao.save(userlogininfo);
	}
	
	@Override
	public void update(UserlogininfoEntity userlogininfo){
		userlogininfoDao.update(userlogininfo);
	}
	
	@Override
	public void delete(Integer id){
		userlogininfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		userlogininfoDao.deleteBatch(ids);
	}
	
}
