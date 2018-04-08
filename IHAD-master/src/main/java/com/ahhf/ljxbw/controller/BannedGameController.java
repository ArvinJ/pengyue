package com.ahhf.ljxbw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahhf.ljxbw.entity.BannedGameEntity;
import com.ahhf.ljxbw.service.BannedGameService;
import com.ahhf.ljxbw.utils.PageUtils;
import com.ahhf.ljxbw.utils.Query;
import com.ahhf.ljxbw.utils.R;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
@RestController
@RequestMapping("/ljxbw/bannedgame")
public class BannedGameController {
	@Autowired
	private BannedGameService bannedGameService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<BannedGameEntity> bannedGameList = bannedGameService.queryList(query);
		int total = bannedGameService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(bannedGameList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id) {
		BannedGameEntity bannedGame = bannedGameService.queryObject(id);

		return R.ok().put("bannedGame", bannedGame);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody BannedGameEntity bannedGame) {
		bannedGameService.save(bannedGame);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody BannedGameEntity bannedGame) {
		bannedGameService.update(bannedGame);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids) {
		bannedGameService.deleteBatch(ids);

		return R.ok();
	}

}
