package com.sh.pengyue.arvin.service.main;

import javax.xml.ws.Endpoint;

import com.sh.pengyue.arvin.serviceimpl.WebServiceImpl;

public class WebServicePublish {
	public static void main(String args[]) {
		String address = "http://192.168.88.173:8080/ArvinWebService/Webservice";
		//调用Endpoint的publish方法发布Web Service  
		Endpoint.publish(address,new WebServiceImpl());
		System.out.println("发布webservice成功 ");
		System.out.println("然后运行浏览器，输入：http://192.168.88.173:8080/ArvinWebService/Webservice?wsdl 查看结果，如果成功生成如下wsdl文档则表示Web Service暴露成功。");
	}
}