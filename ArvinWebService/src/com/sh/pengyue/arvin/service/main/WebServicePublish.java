package com.sh.pengyue.arvin.service.main;

import javax.xml.ws.Endpoint;

import com.sh.pengyue.arvin.serviceimpl.WebServiceImpl;

public class WebServicePublish {
	public static void main(String args[]) {
		String address = "http://192.168.88.173:8080/ArvinWebService/Webservice";
		//����Endpoint��publish��������Web Service  
		Endpoint.publish(address,new WebServiceImpl());
		System.out.println("����webservice�ɹ� ");
		System.out.println("Ȼ����������������룺http://192.168.88.173:8080/ArvinWebService/Webservice?wsdl �鿴���������ɹ���������wsdl�ĵ����ʾWeb Service��¶�ɹ���");
	}
}