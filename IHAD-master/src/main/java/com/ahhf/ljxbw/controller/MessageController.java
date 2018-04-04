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
			switch (title) {
			case "addWarning":
				logger.info(title + "-提交报警");
				break;
			case "upload":
				logger.info(title + "-上传截图");
				break;
			case "computerStatisics":
				/**
				 * {
	"total": "15",
	"list": [{
		"ip": "192.168.88.1",
		"install": "0",
		"mac": "CC-34-29-2D-89-00",
		"version": ""
	}, {
		"ip": "192.168.88.100",
		"install": "0",
		"mac": "00-24-81-C4-D0-2A",
		"version": ""
	}, {
		"ip": "192.168.88.101",
		"install": "0",
		"mac": "80-18-44-E0-AC-70",
		"version": ""
	}, {
		"ip": "192.168.88.102",
		"install": "0",
		"mac": "64-5A-04-CF-BB-90",
		"version": ""
	}, {
		"ip": "192.168.88.106",
		"install": "1",
		"mac": "64-5A-04-CF-D5-E4",
		"version": "2.2.1.8"
	}, {
		"ip": "192.168.88.107",
		"install": "0",
		"mac": "64-5A-04-CF-D9-88",
		"version": ""
	}, {
		"ip": "192.168.88.110",
		"install": "0",
		"mac": "50-01-D9-C1-70-37",
		"version": ""
	}, {
		"ip": "192.168.88.112",
		"install": "0",
		"mac": "64-5A-04-CF-65-6A",
		"version": ""
	}, {
		"ip": "192.168.88.113",
		"install": "0",
		"mac": "0C-8F-FF-94-82-76",
		"version": ""
	}, {
		"ip": "192.168.88.118",
		"install": "0",
		"mac": "34-17-EB-6B-F2-F2",
		"version": ""
	}, {
		"ip": "192.168.88.121",
		"install": "0",
		"mac": "5C-F3-FC-20-FA-6A",
		"version": ""
	}, {
		"ip": "192.168.88.122",
		"install": "0",
		"mac": "80-18-44-E0-C1-33",
		"version": ""
	}, {
		"ip": "192.168.88.123",
		"install": "0",
		"mac": "5C-F3-FC-1C-90-5E",
		"version": ""
	}, {
		"ip": "192.168.88.173",
		"install": "0",
		"mac": "34-17-EB-64-3B-E2",
		"version": ""
	}, {
		"ip": "192.168.88.175",
		"install": "0",
		"mac": "00-0C-29-AE-B7-51",
		"version": ""
	}]
}
				 */
				logger.info(title + "-上传计算机扫描结果");
				break;
			case "record":
				/**
				 * {
	"url": [{
		"ip": "192.168.88.106",
		"t": "0",
		"info": "info.pinyin.sogou.com"
	}, {
		"ip": "192.168.88.106",
		"t": "0",
		"info": "config.pinyin.sogou.com"
	}],
	"prog": [{
		"ip": "192.168.88.106",
		"t": "0",
		"info": "SearchFilterHost.exe"
	}, {
		"ip": "192.168.88.106",
		"t": "0",
		"info": "SoftupNotify.exe"
	}, {
		"ip": "192.168.88.106",
		"t": "0",
		"info": "SGTool.exe"
	}, {
		"ip": "192.168.88.106",
		"t": "0",
		"info": "WmiApSrv.exe"
	}, {
		"ip": "192.168.88.106",
		"t": "0",
		"info": "WmiPrvSE.exe"
	}, {
		"ip": "192.168.88.106",
		"t": "0",
		"info": "SearchProtocolHost.exe"
	}]
}
				 */
				logger.info(title + "-上传记录的信息  ");
				JSONObject json = JSONObject.fromObject(requestBody);
				JSONArray urlArray = null;
				JSONArray progArray = null;
				if (requestBody.indexOf("url") != -1) {
					urlArray = json.getJSONArray("url");
				}
				if (requestBody.indexOf("prog") != -1) {
					progArray = json.getJSONArray("prog");
				}
				if (urlArray != null) {
					System.err.println("urlArray--" + urlArray);
					for (int i = 0; i < urlArray.size(); i++) {
						JSONObject subObject1 = (JSONObject) urlArray.get(i);
						String ip = subObject1.getString("ip");
						String t = subObject1.getString("t");
						String info = subObject1.getString("info");
						System.err.println("urlArray-----ip:" + ip + "--t：" + t + "--info：" + info);
					}

				}
				if (progArray != null) {
					System.err.println("progArray--" + progArray);
					for (int i = 0; i < progArray.size(); i++) {
						JSONObject subObject2 = (JSONObject) progArray.get(i);
						String ip = subObject2.getString("ip");
						String t = subObject2.getString("t");
						String info = subObject2.getString("info");
						System.err.println("progArray-----ip:" + ip + "--t：" + t + "--info：" + info);
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
