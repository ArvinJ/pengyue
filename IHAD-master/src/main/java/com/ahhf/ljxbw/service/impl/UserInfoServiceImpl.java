package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.UserInfoDao;
import com.ahhf.ljxbw.entity.UserInfoEntity;
import com.ahhf.ljxbw.service.UserInfoService;



@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfoEntity queryObject(Integer id){
		return userInfoDao.queryObject(id);
	}
	
	@Override
	public List<UserInfoEntity> queryList(Map<String, Object> map){
		return userInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(UserInfoEntity userInfo){
		userInfoDao.save(userInfo);
	}
	
	@Override
	public void update(UserInfoEntity userInfo){
		userInfoDao.update(userInfo);
	}
	
	@Override
	public void delete(Integer id){
		userInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		userInfoDao.deleteBatch(ids);
	}
	
}
