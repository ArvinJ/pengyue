package com.ahhf.ljxbw.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahhf.ljxbw.entity.ResultCode;
import com.ahhf.ljxbw.entity.ResultData;
import com.ahhf.ljxbw.entity.UserlogininfoEntity;
import com.ahhf.ljxbw.service.UserlogininfoService;
import com.ahhf.ljxbw.utils.BodyJsonInitFactory;

import ch.qos.logback.classic.Logger;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{
	@Autowired
	private UserlogininfoService userlogininfoService;

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public ResultCode login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String reqBody = BodyJsonInitFactory.getPostParameter(request);
		logger.info("/user/login--requestBody---" + reqBody);
		JSONObject json = JSONObject.fromObject(reqBody);
		String name = json.getString("name");
		String password = json.getString("pwd");
		if(name!=null&&!("").equals(name)&&password!=null &&!("").equals(password)) {
			UserlogininfoEntity userlogininfo =new UserlogininfoEntity(name, password, 1, 1);
			userlogininfoService.save(userlogininfo);
			logger.info("/user/login--userlogininfoService.save(userlogininfo)"+userlogininfo.toString());
		}
		ResultCode rc = new ResultCode(new ResultData("4fgrrt5343dfdf",  "56576767"), 0, 0, "uploadImg", "", "");
        JSONObject json2 = JSONObject.fromObject(rc);
        logger.info("/user/login--responseBody----"+json2.toString());
		return rc;
	}
	
}
