package com.ahhf.ljxbw.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahhf.ljxbw.entity.ResultMeasures;
import com.ahhf.ljxbw.entity.ResultMeasuresData;
import com.ahhf.ljxbw.service.BannedGameService;
import com.ahhf.ljxbw.service.BannedIpService;
import com.ahhf.ljxbw.service.BannedKeywordService;
import com.ahhf.ljxbw.service.BannedNameService;
import com.ahhf.ljxbw.service.BannedUrlService;

/**
 * 
 * 
 * @Title: MeasuresController.java
 * @Package com.ahhf.ljxbw.controller
 * @Description: TODO(模拟下发屏蔽库)
 * @author: wenjin.zhu
 * @date: 2018年3月29日 下午12:34:51
 * @version V1.0
 */
@Controller
@RequestMapping("/measures")
public class MeasuresController extends BaseController{
	@Autowired
	private BannedGameService bannedGameService;
	@Autowired
	private BannedIpService bannedIpService;
	@Autowired
	private BannedKeywordService bannedKeywordService;
	@Autowired
	private BannedNameService bannedNameService;
	@Autowired
	private BannedUrlService bannedUrlService;
	
	
	@RequestMapping(value = "/shieldLibraryInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResultMeasures libraryInfo(HttpServletRequest request, HttpServletResponse response) {
		ResultMeasures resultMeasures = new ResultMeasures();
		resultMeasures.setData(new ResultMeasuresData(bannedUrlService.selectAllObject(),bannedIpService.selectAllObject(), bannedKeywordService.selectAllObject(), bannedNameService.selectAllObject(), bannedGameService.selectAllObject()));
		resultMeasures.setErr(0);
		resultMeasures.setDesc("");
		resultMeasures.setErrcode(0);
		resultMeasures.setAt("0.0029451847076416");
		resultMeasures.setT(sdf.format(new Date()));
		return resultMeasures;
	}

}
