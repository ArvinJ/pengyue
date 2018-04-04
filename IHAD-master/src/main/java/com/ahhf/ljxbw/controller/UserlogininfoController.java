package com.ahhf.ljxbw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahhf.ljxbw.entity.UserlogininfoEntity;
import com.ahhf.ljxbw.service.UserlogininfoService;
import com.ahhf.ljxbw.utils.PageUtils;
import com.ahhf.ljxbw.utils.Query;
import com.ahhf.ljxbw.utils.R;

/**
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-04 13:12:55
 */
@Controller
@RequestMapping("/userlogininfo")
public class UserlogininfoController {
	@Autowired
	private UserlogininfoService userlogininfoService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<UserlogininfoEntity> userlogininfoList = userlogininfoService.queryList(query);
		int total = userlogininfoService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userlogininfoList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@ResponseBody
	public R info(@PathVariable("id") Integer id) {
		UserlogininfoEntity userlogininfo = userlogininfoService.queryObject(id);
		return R.ok().put("userlogininfo", userlogininfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@ResponseBody
	public R save(@RequestBody UserlogininfoEntity userlogininfo) {
		userlogininfo.setStatus(1);
		userlogininfo.setType(1);
		userlogininfoService.save(userlogininfo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody UserlogininfoEntity userlogininfo) {
		userlogininfoService.update(userlogininfo);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids) {
		userlogininfoService.deleteBatch(ids);

		return R.ok();
	}

}
