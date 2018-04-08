package com.ahhf.ljxbw.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	T queryObject(Integer id);
	List<T> selectAllObject();
	List<T> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(T t);

	void update(T t);

	void delete(Integer id);

	void deleteBatch(Integer[] ids);
}
