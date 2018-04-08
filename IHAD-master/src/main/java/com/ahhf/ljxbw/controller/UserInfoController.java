package com.ahhf.ljxbw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahhf.ljxbw.entity.UserInfoEntity;
import com.ahhf.ljxbw.service.UserInfoService;
import com.ahhf.ljxbw.utils.PageUtils;
import com.ahhf.ljxbw.utils.Query;
import com.ahhf.ljxbw.utils.R;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 14:46:39
 */
@RestController
@RequestMapping("/ljxbw/userinfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<UserInfoEntity> userInfoList = userInfoService.queryList(query);
		int total = userInfoService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userInfoList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id) {
		UserInfoEntity userInfo = userInfoService.queryObject(id);

		return R.ok().put("userInfo", userInfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody UserInfoEntity userInfo) {
		userInfoService.save(userInfo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody UserInfoEntity userInfo) {
		userInfoService.update(userInfo);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids) {
		userInfoService.deleteBatch(ids);

		return R.ok();
	}

}
