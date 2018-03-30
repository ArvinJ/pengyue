package com.ahhf.ljxbw.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * 
 * @Title: ForFile.java
 * @Package com.ahhf.ljxbw.utils
 * @Description: TODO(文件处理)
 * @author: wenjin.zhu
 * @date: 2018年3月29日 下午3:22:38
 * @version V1.0
 */
public class FileUtils {
	// 生成文件路径
	private static String path = "D:\\file1\\";

	// 文件路径+名称
	private static String filenameTemp;

	/**
	 * 
	 * @Title: createFile   
	 * @Description: TODO(创建文件)   
	 * @param: @param fileName
	 * @param: @param filecontent
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean createFile(String fileName, String filecontent) {
		//FileUtils.isNotFileDirectory(path);
		Boolean bool = false;
		filenameTemp = path + fileName + ".jpg";// 文件路径+名称+文件类型
		File file = new File(filenameTemp);
		try {
			// 如果文件不存在，则创建新的文件
			if (!file.exists()) {
				file.createNewFile();
				bool = true;
				System.out.println("success create file,the file is " + filenameTemp);
				// 创建文件成功后，写入内容到文件里
				writeFileContent(filenameTemp, filecontent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	public static boolean createAnsiFile(String fileName, String filecontent) {
		Boolean bool = false;
		try {
			filenameTemp = path + fileName + ".jpg";// 文件路径+名称+文件类型
			File f = new File(filenameTemp);
			if (!f.exists()) {
				f.createNewFile();
				bool = true;
				System.out.println("success create file,the file is " + filenameTemp);
				// 创建文件成功后，写入内容到文件里
				OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(f)), "GB2312");
				// OutputStreamWriter 是字符流通向字节流的桥梁
				// FileOutputStream此抽象类是表示输出字节流的所有类的超类。

				// 输出流接受输出字节并将这些字节发送到某个接收器。
				osw.write(filecontent);
				osw.flush();
				osw.close();
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bool;
	}
	
	
	
	/**
	 * 向文件中写入内容
	 * 
	 * @param filepath
	 *            文件路径与名称
	 * @param newstr
	 *            写入的内容
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFileContent(String filepath, String newstr) throws IOException {
		Boolean bool = false;
		String filein = newstr + "\r\n";// 新写入的行，换行
		String temp = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			File file = new File(filepath);// 文件路径(包括文件名称)
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			// 文件原有内容
			for (int i = 0; (temp = br.readLine()) != null; i++) {
				buffer.append(temp);
				// 行与行之间的分隔符 相当于“\n”
				buffer = buffer.append(System.getProperty("line.separator"));
			}
			buffer.append(filein);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			pw.flush();
			bool = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 不要忘记关闭
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return bool;
	}

	/**
	 * 删除文件
	 * 
	 * @param fileName
	 *            文件名称
	 * @return
	 */
	public static boolean delFile(String fileName) {
		Boolean bool = false;
		filenameTemp = path + fileName + ".txt";
		File file = new File(filenameTemp);
		try {
			if (file.exists()) {
				file.delete();
				bool = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}

	/**
	 * 
	 * @Title: isNotFile   
	 * @Description: TODO(判断文件是否存在，不存在创建文件)   
	 * @param: @param filename      
	 * @return: void      
	 * @throws
	 */
	public static void  isNotFile(String filename) {
		//"D:\\file\\2.htm"
		File file=new File(filename);    
		if(!file.exists())    
		{    
		    try {    
		        file.createNewFile();    
		    } catch (IOException e) {    
		        // TODO Auto-generated catch block    
		        e.printStackTrace();    
		    }    
		}
		
	}
	
	/**
	 * 
	 * @Title: isNotFileDirectory   
	 * @Description: TODO(判断文件夹是否存在，不存在创建文件夹)   
	 * @param: @param fileNameDirectory      
	 * @return: void      
	 * @throws
	 */
	public static void  isNotFileDirectory(String fileNameDirectory) {
		//"C:\\Users\\QPING\\Desktop\\JavaScript"
		File file =new File(fileNameDirectory);    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("//文件夹不存在");  
		    file .mkdir();    
		} else   
		{  
		    System.out.println("//目录存在");  
		}  
	}
	
	
	
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		SimpleDateFormat sdfn = new SimpleDateFormat("yyyyMMddhhmmss");
		String imgName ="pengyue"+uuid+sdfn.format(new Date());
		createFile(imgName, "我的梦说别停留等待,就让光芒折射泪湿的瞳孔,映出心中最想拥有的彩虹,带我奔向那片有你的天空,因为你是我的梦 我的梦");
	}

}
