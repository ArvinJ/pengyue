package com.ahhf.ljxbw.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
 * @Title: ChannelServer.java
 * @Package com.ahhf.ljxbw.controller
 * @Description: TODO(场所服务器与云服务器通道)
 * @author: wenjin.zhu
 * @date: 2018年3月29日 上午11:58:10
 * @version V1.0
 */
public class ChannelServer {
	private static Logger logger = (Logger) LoggerFactory.getLogger(ChannelServer.class);

	public static void main(String args[]) throws IOException {
		// 为了简单起见，所有的异常信息都往外抛
		int port = 8282;
		// 定义一个ServerSocket监听在端口8282上
		ServerSocket server = new ServerSocket(port);
		while (true) {
			// server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
			logger.info("服务器启动》》》");
			Socket socket = server.accept();
			// 每接收到一个Socket就建立一个新的线程来处理它
			new Thread(new Task(socket)).start();
		}
	}

	/**
	 * 用来处理Socket请求的
	 */
	static class Task implements Runnable {

		private Socket socket;

		public Task(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				handleSocket();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 跟客户端Socket进行通信
		 * 
		 * @throws Exception
		 */
		private void handleSocket() throws Exception {
			// 3.获取输入流用来读取客户端所发出的信息
			InputStream is = socket.getInputStream();// 字节输入流
			InputStreamReader isr = new InputStreamReader(is);// 将字节流转化为字符流
			// 为字符流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(socket.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String temp = null;
			int index;
			temp = br.readLine();
			logger.info("readLine()--" + temp);
			index = temp.indexOf("eof");
			logger.info("index---" + index);
			while (temp != null) {
				if (index != -1) {// 遇到eof时就结束接收
					sb.append(temp.substring(0, index));
					break;
				}
				sb.append(temp);
			}
			logger.info("Client commit body: " + sb);
			Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			if (sb.indexOf("ping")!=-1) {
				// 心跳不返回
			}else {
				// 读完后写一句
				
				Map<String, Object> m = new HashMap<String, Object>();
				// opt string 不可以为空  操作类型，-1=数据传输格式不正确，断开连接，0=正常连接，不做任何操作，1=关机，2=重启，3=锁定，4=解锁，5=截屏 ;ip string 可以 机器内网IP，opt大于0时传输
				m.put("opt", "5");
				m.put("ip", "192.168.88.106");
				JSONObject jsonObject = JSONObject.fromObject(m);
				logger.info("Server return body---" + jsonObject.toString());
				writer.write(jsonObject.toString()+"\n");
			}
			
			
			//清空缓冲区的数据流
			writer.flush();
			//writer.close();
			//br.close();
			//socket.close();
		}
	}
}