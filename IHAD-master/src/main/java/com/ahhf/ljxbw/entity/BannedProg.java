package com.ahhf.ljxbw.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @Title: BannedProg.java
 * @Package com.ahhf.ljxbw.entity
 * @Description: TODO(禁止程序 t_banned_prog)
 * @author: wenjin.zhu
 * @date: 2018年3月27日 下午5:23:21
 * @version V1.0
 */

public class BannedProg implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String progType;
	private String progName;
	private String progFileName;
	private String progressName;
	private String featureCode;
	private String alarmType;
	private String alarmRank;
	private int isBlock;
	private int verNum;

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	private int deleteFlag;

	public String getProgMF() {
		return progMF;
	}

	public void setProgMF(String progMF) {
		this.progMF = progMF;
	}

	private int deleted;
	private int isPub;
	private String progMF;
	private String operation;

	private String monitorCode;
	private String version;

	public String getProgFileName() {
		return progFileName;
	}

	public void setProgFileName(String progFileName) {
		this.progFileName = progFileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProgType() {
		return progType;
	}

	public void setProgType(String progType) {
		this.progType = progType;
	}

	public String getProgName() {
		return progName;
	}

	public void setProgName(String progName) {
		this.progName = progName;
	}

	public String getProgressName() {
		return progressName;
	}

	public void setProgressName(String progressName) {
		this.progressName = progressName;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getAlarmRank() {
		return alarmRank;
	}

	public void setAlarmRank(String alarmRank) {
		this.alarmRank = alarmRank;
	}

	public int getIsBlock() {
		return isBlock;
	}

	public void setIsBlock(int isBlock) {
		this.isBlock = isBlock;
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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
