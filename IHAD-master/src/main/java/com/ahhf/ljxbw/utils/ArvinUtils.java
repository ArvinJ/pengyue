package com.ahhf.ljxbw.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sound.midi.SysexMessage;

/**
 * 
 * 
 * @Title: ArvinUtils.java
 * @Package com.ahhf.ljxbw.utils
 * @Description: TODO(my tools)
 * @author: wenjin.zhu
 * @date: 2018年4月3日 下午2:04:52
 * @version V1.0
 */
public class ArvinUtils {
	/**
	 * 获取指定时间对应的毫秒数
	 * 
	 * @param time
	 *            "HH:mm:ss"
	 * @return
	 */
	private static long getTimeMillis(String time) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
			Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
			return curDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public static void main(String[] args) {
		System.err.println("一共"+ArvinUtils.getTimeMillis("14:07:00")+"秒");
		 
	}
}
