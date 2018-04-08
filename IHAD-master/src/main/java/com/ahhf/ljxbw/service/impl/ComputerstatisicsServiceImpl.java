package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.ComputerstatisicsDao;
import com.ahhf.ljxbw.entity.ComputerstatisicsEntity;
import com.ahhf.ljxbw.service.ComputerstatisicsService;



@Service("computerstatisicsService")
public class ComputerstatisicsServiceImpl implements ComputerstatisicsService {
	@Autowired
	private ComputerstatisicsDao computerstatisicsDao;
	
	@Override
	public ComputerstatisicsEntity queryObject(Integer id){
		return computerstatisicsDao.queryObject(id);
	}
	
	@Override
	public List<ComputerstatisicsEntity> queryList(Map<String, Object> map){
		return computerstatisicsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return computerstatisicsDao.queryTotal(map);
	}
	
	@Override
	public void save(ComputerstatisicsEntity computerstatisics){
		computerstatisicsDao.save(computerstatisics);
	}
	
	@Override
	public void update(ComputerstatisicsEntity computerstatisics){
		computerstatisicsDao.update(computerstatisics);
	}
	
	@Override
	public void delete(Integer id){
		computerstatisicsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		computerstatisicsDao.deleteBatch(ids);
	}
	
}
