package com.sh.pengyue.arvin.test;

import java.rmi.RemoteException;

import com.sh.pengyue.arvin.service.WebServiceProxy;

public class TestService {
	public static void main(String[] args) {
		WebServiceProxy wsProxy = new WebServiceProxy();

		try {
			String s = wsProxy.sayHello("Tom");
			System.out.println("µ÷webservice:" + s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
