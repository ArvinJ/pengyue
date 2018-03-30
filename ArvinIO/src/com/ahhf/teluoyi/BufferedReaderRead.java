package com.ahhf.teluoyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @ClassName:  BufferedReaderRead   
 * @Description:TODO(字符流 read方法一次读一个字符)   
 * @author: wenjin.zhu
 * @date:   2018年3月30日 下午2:38:51
 */

public class BufferedReaderRead {
	public static void main(String[] args) throws IOException {
		char c;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.err.println("����q�˳�");
		do {
			c = (char)bufferedReader.read();
			System.out.println(c);
		}while(c!='q');
		
	}
}
