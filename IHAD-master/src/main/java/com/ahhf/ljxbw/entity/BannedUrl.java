/**
 * 上海交通大学-鹏越惊虹信息技术发展有限公司
 *         Copyright © 2003-2014
 */
package com.ahhf.ljxbw.entity;

import java.io.Serializable;
/**
 * 
 * 
 * @Title:  BannedUrl.java   
 * @Package com.ahhf.ljxbw.entity   
 * @Description:    TODO(禁止url  banned_url)   
 * @author: wenjin.zhu    
 * @date:   2018年3月27日 下午5:28:43   
 * @version V1.0
 */


public class BannedUrl implements Serializable { 

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer urlType;
	private String urlValue;
	private int alarmType;
	private int isBlock;
	private int alarmRank;
	private int verNum;
	private int deleted;
	private int isPub;

	private String updator;
	private String updateTime;
	private String operation;
	private String creator;
	private int deleteFlag;

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	private String monitorCode;
	private String version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUrlType() {
		return urlType;
	}

	public void setUrlType(Integer urlType) {
		this.urlType = urlType;
	}

	public String getUrlValue() {
		return urlValue;
	}

	public void setUrlValue(String urlValue) {
		this.urlValue = urlValue;
	}

	public int getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}

	public int isBlock() {
		return isBlock;
	}

	public void setBlock(int isBlock) {
		this.isBlock = isBlock;
	}

	public int getAlarmRank() {
		return alarmRank;
	}

	public void setAlarmRank(int alarmRank) {
		this.alarmRank = alarmRank;
	}

	public int getVerNum() {
		return verNum;
	}

	public void setVerNum(int verNum) {
		this.verNum = verNum;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getIsBlock() {
		return isBlock;
	}

	public void setIsBlock(int isBlock) {
		this.isBlock = isBlock;
	}

	public String getMonitorCode() {
		return monitorCode;
	}

	public void setMonitorCode(String monitorCode) {
		this.monitorCode = monitorCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getIsPub() {
		return isPub;
	}

	public void setIsPub(int isPub) {
		this.isPub = isPub;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
