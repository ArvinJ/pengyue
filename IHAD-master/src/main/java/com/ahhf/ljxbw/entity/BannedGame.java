package com.ahhf.ljxbw.entity;
/**
 * 
 * 
 * @Title:  BannedGame.java   
 * @Package com.ahhf.ljxbw.entity   
 * @Description:    TODO(T_BANNED_GAME_VERSION 游戏屏蔽库)   
 * @author: wenjin.zhu    
 * @date:   2018年3月27日 下午5:45:10   
 * @version V1.0
 */

import java.io.Serializable;

public class BannedGame implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private int verNum;
	private String gameFileName;
	private String gameTitle;
	private String gameName;
	private String publisher;
	private String feature;
	private String alarmCode;
	private int isAlarm;
	private String alarmRank;
	private int isBlock;
	
	
}
