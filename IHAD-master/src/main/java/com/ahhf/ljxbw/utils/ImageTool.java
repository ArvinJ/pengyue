package com.ahhf.ljxbw.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * 
 * 
 * @Title:  ImageTool.java   
 * @Package com.ahhf.ljxbw.utils   
 * @Description:    TODO(java图片二进制相互转换)   
 * @author: wenjin.zhu    
 * @date:   2018年3月29日 下午5:51:01   
 * @version V1.0
 */
public class ImageTool {
	static sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	static sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	public static void main(String[] args) {
		//System.out.println(getImageBinary());
		base64StringToImage(getImageBinary());
	}

	/**
	 * 将图片转换成二进制
	 * 
	 * @return
	 */
	public static String getImageBinary() {
		File f = new File("D:\\file1\\abc.jpg");
		BufferedImage bi;
		try {
			bi = ImageIO.read(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
			byte[] bytes = baos.toByteArray();

			return encoder.encodeBuffer(bytes).trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将二进制转换为图片
	 * 
	 * @param base64String
	 */
	public  static void base64StringToImage(String base64String) {
		try {
			byte[] bytes1 = decoder.decodeBuffer(base64String);

			ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
			BufferedImage bi1 = ImageIO.read(bais);
			File w2 = new File("D:\\file1\\abc22.jpg");// 可以是jpg,png,gif格式
			ImageIO.write(bi1, "jpg", w2);// 不管输出什么格式图片，此处不需改动
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
