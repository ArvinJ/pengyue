package com.ahhf.ljxbw.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class CafeClientSocket {
	private static Logger logger = (Logger) LoggerFactory.getLogger(CafeClientSocket.class);

	/**
	 * 
	 * 客户端 字段 数据格式 是否可空 字段说明 
	 * opt string 是 操作类型，1=关机，2=重启，3=锁定，4=解锁，5=截屏 
	 * rst string 是 操作结果，0=失败，1=成功
	 * ip string 是 机器内网IP，以上三个参数在接受到控制指令且操作完成后传输结果给服务端 
	 * ping string 是心跳，传1即可(心跳每30秒发送一次) 
	 * code string 是 所属网吧CODE（此数据第一次连接（重连）时传输）
	 * 发送心跳包：'{"ping":"1"}\n' 第一次连接：'{"code":"1000010014"}\n'
	 */
	public static void main(String[] args) {
		try {
			// 1.创建客户端Socket，指定服务器地址和端口号
			Socket socket = new Socket("127.0.0.1", 8282);
			// 2.获取输出流，用来向服务器发送信息
			OutputStream os = socket.getOutputStream();// 字节输出流
			// 转换为打印流
			PrintWriter pw = new PrintWriter(os);
			pw.write("用户名：admin；密码：admin");
			pw.flush();// 刷新缓存，向服务器端输出信息
			// 关闭输出流
			socket.shutdownOutput();
			// 3.获取输入流，用来读取服务器端的响应信息
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while ((info = br.readLine()) != null) {
				logger.info("我是客户端，服务器端返回的信息是：" + info);
			}
			// 4.关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
}
