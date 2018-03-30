package com.sh.pengyue.arvin.serviceimpl;

import com.sh.pengyue.arvin.service.WebService;
@javax.jws.WebService(endpointInterface="com.sh.pengyue.arvin.service.WebService",serviceName="WebServiceWs")//指定webservice所实现的接口以及服务名称  
public class WebServiceImpl implements WebService {

	@Override
	public String sayHello(String name) {
		return "你好-"+name+"-哟";
	}

}
