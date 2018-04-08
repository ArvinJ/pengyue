package com.ahhf.ljxbw.controller;

import java.text.SimpleDateFormat;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * 
 * 
 * @Title:  BaseController.java   
 * @Package com.ahhf.ljxbw.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wenjin.zhu    
 * @date:   2018年4月8日 上午9:56:26   
 * @version V1.0
 */
public class BaseController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public Logger logger = (Logger) LoggerFactory.getLogger(getClass());
}
