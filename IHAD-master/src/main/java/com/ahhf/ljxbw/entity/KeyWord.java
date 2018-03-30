package com.ahhf.ljxbw.entity;


import java.io.Serializable;

/**
 * 
 * 
 * @Title:  KeyWord.java   
 * @Package com.ahhf.ljxbw.entity   
 * @Description:    TODO(t_keyword 关键字表)   
 * @author: wenjin.zhu    
 * @date:   2018年3月27日 下午5:30:27   
 * @version V1.0
 */
public class KeyWord implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
    private String keyword;
    private int alarmType;
    private int alarmRank;
    private int isBlock;
    private int deleted;
    private int verNum;
    private int isPub;

    private String updator;
    private String updateTime;
    private String operation;


    private String monitorCode;
    private String version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public int getAlarmRank() {
        return alarmRank;
    }

    public void setAlarmRank(int alarmRank) {
        this.alarmRank = alarmRank;
    }

    public int getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(int isBlock) {
        this.isBlock = isBlock;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getVerNum() {
        return verNum;
    }

    public void setVerNum(int verNum) {
        this.verNum = verNum;
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
