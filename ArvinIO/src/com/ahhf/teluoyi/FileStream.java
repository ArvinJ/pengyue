package com.ahhf.teluoyi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @ClassName: FileStream
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wenjin.zhu
 * @date: 2018年3月30日 下午2:38:10
 */

public class FileStream {

	public static void main(String[] args) throws IOException {
		// 写 (会存在乱码)
		byte bWrite[] = { 11, 21, 3, 40, 5 };
		OutputStream os = new FileOutputStream("D:\\output.txt");
		for (int i = 0; i < bWrite.length; i++) {
			os.write(bWrite[i]);
		}
		os.close();
		
		
		
		

		// 读 (会存在乱码)
		File f = new File("D:\\output.txt");
		InputStream is = new FileInputStream(f);
		int size = is.available();
		for (int i = 0; i < size; i++) {
			 System.out.print((char)is.read() + "  ");
		}
		is.close();
	}
}
