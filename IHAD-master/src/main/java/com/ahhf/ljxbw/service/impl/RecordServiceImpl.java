package com.ahhf.ljxbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ahhf.ljxbw.dao.RecordDao;
import com.ahhf.ljxbw.entity.RecordEntity;
import com.ahhf.ljxbw.service.RecordService;



@Service("recordService")
public class RecordServiceImpl implements RecordService {
	@Autowired
	private RecordDao recordDao;
	
	@Override
	public RecordEntity queryObject(Integer id){
		return recordDao.queryObject(id);
	}
	
	@Override
	public List<RecordEntity> queryList(Map<String, Object> map){
		return recordDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return recordDao.queryTotal(map);
	}
	
	@Override
	public void save(RecordEntity record){
		recordDao.save(record);
	}
	
	@Override
	public void update(RecordEntity record){
		recordDao.update(record);
	}
	
	@Override
	public void delete(Integer id){
		recordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		recordDao.deleteBatch(ids);
	}
	
}
