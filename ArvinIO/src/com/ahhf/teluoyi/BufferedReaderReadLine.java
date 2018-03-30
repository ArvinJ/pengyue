package com.ahhf.teluoyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @ClassName:  BufferedReaderReadLine   
 * @Description:TODO(字符流readLine读字符串)   
 * @author: wenjin.zhu
 * @date:   2018年3月30日 下午2:38:28
 */
public class BufferedReaderReadLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test;
		System.out.println("Enter 'end' to quit.");
		do {
			test = br.readLine();
			System.err.println(test);
		} while (!test.equals("end"));
		
	}
}
