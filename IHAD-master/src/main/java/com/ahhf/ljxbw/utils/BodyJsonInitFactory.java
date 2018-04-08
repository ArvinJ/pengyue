package com.ahhf.ljxbw.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
/**
 * 
 * 
 * @Title:  BodyJsonInitFactory.java   
 * @Package com.ahhf.ljxbw.utils   
 * @Description:    TODO(获取request中body)   
 * @author: wenjin.zhu    
 * @date:   2018年3月28日 上午11:05:41   
 * @version V1.0
 */
public class BodyJsonInitFactory {
	
	public static String obtainRequestBody(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		 // 读取请求内容
        BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
			while((line = br.readLine())!=null){
			    sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return sb.toString();
	}

	/**
	 * 
	 * @Title: getPostParameter   
	 * @Description: TODO(根据request获取Post参数  json数据在输入流中，需反序列话才能得到)   
	 * @param: @param request
	 * @param: @return
	 * @param: @throws IOException      
	 * @return: String      
	 * @throws
	 */
	 public static String getPostParameter(HttpServletRequest request) throws IOException{  
	      BufferedInputStream buf = null;  
	      int iContentLen = request.getContentLength();  
	      byte sContent[] = new byte[iContentLen];  
	      String sContent2 = null;  
	      try {  
	          buf = new BufferedInputStream(request.getInputStream());  
	          buf.read(sContent, 0, sContent.length);  
	          sContent2 = new String(sContent,0,iContentLen,"UTF-8");  
	  
	      } catch (IOException e) {  
	          throw new IOException("Parse data error!",e);  
	      } finally  
	      {  
	          try {  
	              buf.close();  
	          } catch (IOException e) {  
	  
	          }  
	      }  
	      return sContent2;  
	  }  
}
