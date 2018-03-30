package com.ahhf.ljxbw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahhf.ljxbw.entity.BannedUrl;

/**
 * 
 * 
 * @Title:  TeLuoYiContorller.java   
 * @Package com.system.controller   
 * @Description:    TODO(Test)   
 * @author: wenjin.zhu    
 * @date:   2018年3月28日 下午1:27:58   
 * @version V1.0
 */
@Controller
@RequestMapping(value="teluoyi")
public class TeLuoYiContorller {

	@RequestMapping("/bannedUrlInfo")
	@ResponseBody
	public BannedUrl bannedUrlInfo() {
		BannedUrl burl = new BannedUrl();
		burl.setVerNum(1);
		burl.setAlarmRank(1);
		burl.setBlock(0);
		burl.setUrlValue("www.baidu.com");
		return burl;
	}
}
