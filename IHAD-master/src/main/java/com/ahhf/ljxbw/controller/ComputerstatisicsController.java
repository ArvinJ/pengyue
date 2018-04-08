package com.ahhf.ljxbw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahhf.ljxbw.entity.ComputerstatisicsEntity;
import com.ahhf.ljxbw.service.ComputerstatisicsService;
import com.ahhf.ljxbw.utils.PageUtils;
import com.ahhf.ljxbw.utils.Query;
import com.ahhf.ljxbw.utils.R;




/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 10:03:36
 */
@RestController
@RequestMapping("/ljxbw/computerstatisics")
public class ComputerstatisicsController {
	@Autowired
	private ComputerstatisicsService computerstatisicsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ComputerstatisicsEntity> computerstatisicsList = computerstatisicsService.queryList(query);
		int total = computerstatisicsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(computerstatisicsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ComputerstatisicsEntity computerstatisics = computerstatisicsService.queryObject(id);
		
		return R.ok().put("computerstatisics", computerstatisics);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ComputerstatisicsEntity computerstatisics){
		computerstatisicsService.save(computerstatisics);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ComputerstatisicsEntity computerstatisics){
		computerstatisicsService.update(computerstatisics);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		computerstatisicsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
