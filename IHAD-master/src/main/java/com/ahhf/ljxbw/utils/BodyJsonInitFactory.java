package com.ahhf.ljxbw.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	public static String obtainRequestBody(HttpServletRequest request) {
		
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

}
