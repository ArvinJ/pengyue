package com.ahhf.ljxbw.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import net.sf.json.JSONObject;

/**
 * 
 * 
 * @Title: CafeServerSocket.java
 * @Package com.ahhf.ljxbw.controller
 * @Description: TODO(socket服务端)
 * @author: wenjin.zhu
 * @date: 2018年3月28日 下午2:55:21
 * @version V1.0
 */
public class CafeServerSocket {
	private static Logger logger = (Logger) LoggerFactory.getLogger(CafeServerSocket.class);
	/**
	 * 服务端 字段 数据格式 是否可空 字段说明 
	 * opt string 否  操作类型，-1=数据传输格式不正确，断开连接，0=正常连接，不做任何操作，1=关机，2=重启，3=锁定，4=解锁，5=截屏
	 * ip string 是    机器内网IP，opt大于0时传输
	 * 
	 * 示例 {"opt":"1","ip":"192.168.1.222"}\n'
	 * 
	 */
	public static void main(String[] args) {

		try {
			// 1.创建一个服务器端Socket，即serverSocket，指定绑定的端口，并监听此端口。
			ServerSocket serverSocket = new ServerSocket(8282);
			// 2.调用serverSocket的accept（）方法，等待客户端的连接
			logger.info("==服务器即将启动，等待客户端的连接==");
			Socket socket = serverSocket.accept();
			// 3.获取输入流用来读取客户端所发出的信息
			InputStream is = socket.getInputStream();// 字节输入流
			InputStreamReader isr = new InputStreamReader(is);// 将字节流转化为字符流
			// 为字符流添加缓冲
			BufferedReader bufferedReader = new BufferedReader(isr);
			String info = null;
			OutputStream os = socket.getOutputStream();
			// 循环读取客户端提交的信息
			while ((info = bufferedReader.readLine()) != null) {
				info = info+"\n";//手动加上回车  
	            // os.write(info.getBytes("utf-8")); 
				logger.info("我是服务器，客户端提交的信息是：" + info);
				break;
			}
			System.err.println("00000");
			socket.shutdownInput();
			// 4.获取输出流，响应客户端的请求
			
			PrintWriter pw = new PrintWriter(os);// 转化为打印流
			Map<String, Object> m = new HashMap<String, Object>();
			// opt string 不可以为空
			// 操作类型，-1=数据传输格式不正确，断开连接，0=正常连接，不做任何操作，1=关机，2=重启，3=锁定，4=解锁，5=截屏
			// ip string 可以 机器内网IP，opt大于0时传输
			m.put("opt", 5);
			m.put("ip", "192.168.88.106");
			JSONObject jsonObject = JSONObject.fromObject(m);
			System.err.println("order---" + jsonObject.toString());
			pw.write(jsonObject.toString()+"\n");
			pw.flush();// 刷新缓存
			// 5.关闭相关的资源
			bufferedReader.close();
			is.close();
			isr.close();
			socket.close();
			serverSocket.close();
			os.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
