package com.ahhf.ljxbw.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahhf.ljxbw.entity.ResultCode;
import com.ahhf.ljxbw.entity.ResultData;
import com.ahhf.ljxbw.utils.BodyJsonInitFactory;

import ch.qos.logback.classic.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * 
 * @Title: MessageController.java
 * @Package com.ahhf.ljxbw.controller
 * @Description: TODO(消息控制)
 * @author: wenjin.zhu
 * @date: 2018年3月28日 上午9:53:45
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private Logger logger = (Logger) LoggerFactory.getLogger(MessageController.class);

	/**
	 * 
	 * @Title: commitInfo   
	 * @Description: TODO(获取场所服务端发送过来的数据，提交到云端)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Map<String,Object>      
	 * @throws
	 */
	
	@RequestMapping(value = "/Info", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> commitInfo(HttpServletRequest request, HttpServletResponse response) {
		String msgBody = BodyJsonInitFactory.obtainRequestBody(request);
		logger.info("msgBody---" + msgBody);
		String title = request.getParameter("a");
		switch (title) {
		case "addWarning":
			logger.info(title + "-提交报警");
			break;
		case "upload":
			logger.info(title + "-上传截图");
			break;
		case "computerStatisics":
			logger.info(title + "-上传计算机扫描结果");
			break;
		case "record":
			logger.info(title + "-上传记录的信息  ");
			JSONObject json = JSONObject.fromObject(msgBody);
			JSONArray urlArray = null;
			JSONArray progArray = null;
			 if (msgBody.indexOf("url")!=-1){
				 urlArray = json.getJSONArray("url");
			 }
			 if(msgBody.indexOf("prog")!=-1) {
				 progArray = json.getJSONArray("prog"); 
			 }
			if(urlArray!=null) {
				System.err.println("urlArray--"+urlArray);
				 for (int i = 0; i < urlArray.size(); i++) {
					 JSONObject subObject1 = (JSONObject) urlArray.get(i);
					 String ip =subObject1.getString("ip");
				     String t = subObject1.getString("t");
				     String info = subObject1.getString("info");
				     System.err.println("urlArray-----ip:"+ip+"--t："+t+"--info："+info);
				  }
				
			}
			if(progArray!=null) {
				System.err.println("progArray--"+progArray);
				 for (int i = 0; i < progArray.size(); i++) {
					 JSONObject subObject2 = (JSONObject) progArray.get(i);
					 String ip =subObject2.getString("ip");
				     String t = subObject2.getString("t");
				     String info = subObject2.getString("info");
				     System.err.println("progArray-----ip:"+ip+"--t："+t+"--info："+info);
				  }
			}
			
			break;
		case "openCard":
			logger.info(title + "开卡");
			break;
		case "closeCard":
			logger.info(title + "退卡");
			break;
		case "operate":
			logger.info(title + "上机 ");
			break;
		case "deplane":
			logger.info(title + "下机 ");
			break;
		default:
			logger.info("a值的信息-"+title);
			break;
		}
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("token", "4fgrrt5343dfdf");
		m1.put("vkey", "56576767");
		m.put("data", m1);
		m.put("err", 0);
		m.put("errcode", 0);
		m.put("desc", "messageController-Info");
		m.put("t", "");
		m.put("at", "");
		return m;
	}
	/**
	 * 
	 * @Title: sendOrders   
	 * @Description: TODO(云向场所服务器发送指令)   
	 * @param: @return      
	 * @return: Map<String,Object>      
	 * @throws
	 */
	@RequestMapping(value = "/sendOrders", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendOrders() {
		Map<String, Object> m = new HashMap<String, Object>();
		// opt	string	不可以为空	 操作类型，-1=数据传输格式不正确，断开连接，0=正常连接，不做任何操作，1=关机，2=重启，3=锁定，4=解锁，5=截屏
		// ip	string	 可以	机器内网IP，opt大于0时传输
		m.put("opt", 0);
		m.put("ip", "192.168.1.222");
		return m;
	}
	
	/**
	 * 
	 * @Title: uploadImg   
	 * @Description: TODO(获取场所服务器上传的图片)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Map<String,Object>      
	 * @throws
	 */
	@RequestMapping(value = "/uploadImg",method=RequestMethod.POST)
	@ResponseBody
	public ResultCode uploadImg(HttpServletRequest request, HttpServletResponse response) {
		UUID uuid = UUID.randomUUID();
		SimpleDateFormat sdfn = new SimpleDateFormat("yyyyMMddhhmmss");
		try {
			
	        String temporaryDirectory="D:\\file\\"+"py"+uuid+sdfn.format(new Date())+".jpg" ;
			ServletInputStream inputStream = request.getInputStream();
	            FileOutputStream out = new FileOutputStream(temporaryDirectory);
	            byte[] buf = new byte[1024];
	            int len = inputStream.read(buf, 0, 1024);
	            while(len > 0 && len != -1) {
	                out.write(buf, 0, len);
	                len = inputStream.read(buf, 0, 1024);
	            }
	            out.close();
	            inputStream.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		String titleValue = request.getParameter("a");
		String ipValue = request.getParameter("ip");
		String tokenValue = request.getParameter("token");
		logger.info("titleValue:"+titleValue+"--ipValue:"+ipValue+"--tokenValue"+tokenValue);
		ResultCode rc = new ResultCode(new ResultData("4fgrrt5343dfdf",  "56576767"), 0, 0, "uploadImg", "", "");
		return rc;
	}
	
}
