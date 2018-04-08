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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahhf.ljxbw.entity.ComputerstatisicsEntity;
import com.ahhf.ljxbw.entity.RecordEntity;
import com.ahhf.ljxbw.entity.ResultCode;
import com.ahhf.ljxbw.entity.ResultData;
import com.ahhf.ljxbw.service.ComputerstatisicsService;
import com.ahhf.ljxbw.service.RecordService;
import com.ahhf.ljxbw.utils.BodyJsonInitFactory;

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
public class MessageController extends BaseController{
	
	@Autowired
	private RecordService recordService;
	@Autowired
	private ComputerstatisicsService computerstatisicsService;
	
	
	
	/**
	 * 
	 * @Title: commitInfo   
	 * @Description: TODO(获取场所服务端发送到云端的数据)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: ResultCode      
	 * @throws
	 */
	 
	@RequestMapping(value = "/Info", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode commitInfo(HttpServletRequest request, HttpServletResponse response) {
		String requestBody = BodyJsonInitFactory.obtainRequestBody(request);
		logger.info("/message/Info---requestBody---" + requestBody);
		String title = request.getParameter("a");
		if (title != null && !title.equals("")) {
			JSONObject json = JSONObject.fromObject(requestBody);
			switch (title) {
			case "addWarning":
				logger.info(title + "-提交报警");
				break;
			case "upload":
				logger.info(title + "-上传截图");
				break;
			case "computerStatisics":
				logger.info(title + "-上传计算机扫描结果");
				JSONArray computerArray = null;
				ComputerstatisicsEntity computerstatisics = null;
				if (requestBody.indexOf("list") != -1) {
					computerArray = json.getJSONArray("list");
				}
				if (computerArray != null) {
					logger.info("computerArray--" + computerArray);
					for (int i = 0; i < computerArray.size(); i++) {
						
						JSONObject subObject1 = (JSONObject) computerArray.get(i);
						String ip = subObject1.getString("ip");
						Integer install = 0;
						try {
							install = Integer.parseInt(subObject1.getString("install"));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						String mac = subObject1.getString("mac");
						String version = subObject1.getString("version");
						computerstatisics = new ComputerstatisicsEntity(ip, install, mac, version, 1);
						computerstatisicsService.save(computerstatisics);
					}

				}
				computerstatisicsService.save(computerstatisics);
				
				
				break;
			case "record":

				logger.info(title + "-上传记录的信息  ");
				JSONArray urlArray = null;
				JSONArray progArray = null;
				// url : type=1;prog : type=2
				if (requestBody.indexOf("url") != -1) {
					urlArray = json.getJSONArray("url");
				}
				if (requestBody.indexOf("prog") != -1) {
					progArray = json.getJSONArray("prog");
				}
				
				RecordEntity record = null;
				
				if (urlArray != null) {
					logger.info("urlArray--" + urlArray);
					for (int i = 0; i < urlArray.size(); i++) {
						
						JSONObject subObject1 = (JSONObject) urlArray.get(i);
						String ip = subObject1.getString("ip");
						Integer t =0;
						try {
							t = Integer.parseInt(subObject1.getString("t"));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
						String info = subObject1.getString("info");
						record = new RecordEntity(ip, t, info, 1, 1);
						recordService.save(record);
					}

				}
				if (progArray != null) {
					logger.info("progArray--" + progArray);
					for (int i = 0; i < progArray.size(); i++) {
						JSONObject subObject2 = (JSONObject) progArray.get(i);
						String ip = subObject2.getString("ip");
						Integer t = 0;
						try {
							t = Integer.parseInt(subObject2.getString("t"));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String info = subObject2.getString("info");
						record = new RecordEntity(ip, t, info, 1, 2);
						recordService.save(record);
					}
				}
				
				break;
			case "openCard":
				logger.info(title + "-开卡-"+json.toString());
				break;
			case "closeCard":
				logger.info(title + "-退卡-"+json.toString());
				break;
			case "operate":
				logger.info(title + "-上机- "+json.toString());
				break;
			case "deplane":
				logger.info(title + "-下机- "+json.toString());
				break;
			default:
				logger.info("a值的信息-" + title);
				break;
			}
		}

		ResultCode rc = new ResultCode(new ResultData("4fgrrt5343dfdf", "56576767"), 0, 0, "uploadImg", "", "");

		return rc;
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
		// opt string 不可以为空
		// 操作类型，-1=数据传输格式不正确，断开连接，0=正常连接，不做任何操作，1=关机，2=重启，3=锁定，4=解锁，5=截屏
		// ip string 可以 机器内网IP，opt大于0时传输
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

			String temporaryDirectory = "D:\\file\\" + "py" + uuid + sdfn.format(new Date()) + ".jpg";
			ServletInputStream inputStream = request.getInputStream();
			FileOutputStream out = new FileOutputStream(temporaryDirectory);
			byte[] buf = new byte[1024];
			int len = inputStream.read(buf, 0, 1024);
			while (len > 0 && len != -1) {
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
		logger.info("titleValue:" + titleValue + "--ipValue:" + ipValue + "--tokenValue" + tokenValue);
		ResultCode rc = new ResultCode(new ResultData("4fgrrt5343dfdf", "56576767"), 0, 0, "uploadImg", "", "");
		return rc;
	}

}
