package com.sh.pengyue.arvin.serviceimpl;

import com.sh.pengyue.arvin.service.WebService;
@javax.jws.WebService(endpointInterface="com.sh.pengyue.arvin.service.WebService",serviceName="WebServiceWs")//ָ��webservice��ʵ�ֵĽӿ��Լ���������  
public class WebServiceImpl implements WebService {

	@Override
	public String sayHello(String name) {
		return "���-"+name+"-Ӵ";
	}

}
