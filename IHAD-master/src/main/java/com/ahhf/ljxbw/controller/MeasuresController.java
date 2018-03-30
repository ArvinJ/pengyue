package com.ahhf.ljxbw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class MeasuresController {
	@RequestMapping(value = "/shieldLibraryInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> libraryInfo(HttpServletRequest request, HttpServletResponse response) {
		// 将资料解码
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 12);
		map.put("name", "www.baidu.com");
		map.put("wtype", 1);
		map.put("wid", 1);
		map.put("holdup", 1);
		data.add(map);

		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("url", data);
		m.put("data", m1);

		return m;
	}

}
