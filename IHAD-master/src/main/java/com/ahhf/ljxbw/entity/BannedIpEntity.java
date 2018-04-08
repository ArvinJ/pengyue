package com.ahhf.ljxbw.entity;

import java.io.Serializable;


/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public class BannedIpEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//屏蔽内容,IP地址
	private String name;
	//告警类型，1=URL访问报警，2=游戏、程序报警，3=运行报警，4=特殊人员报警，5=关键字报警，6=紧急状况，7=未成年人告警，8=上网时长告警，9=擅停告警
	private String wtype;
	//告警等级，1=一般报警，2=中等程度报警，3=严重报警
	private String wid;
	//是否拦截，0=否，1=是
	private String holdup;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：屏蔽内容,IP地址
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：屏蔽内容,IP地址
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：告警类型，1=URL访问报警，2=游戏、程序报警，3=运行报警，4=特殊人员报警，5=关键字报警，6=紧急状况，7=未成年人告警，8=上网时长告警，9=擅停告警
	 */
	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	/**
	 * 获取：告警类型，1=URL访问报警，2=游戏、程序报警，3=运行报警，4=特殊人员报警，5=关键字报警，6=紧急状况，7=未成年人告警，8=上网时长告警，9=擅停告警
	 */
	public String getWtype() {
		return wtype;
	}
	/**
	 * 设置：告警等级，1=一般报警，2=中等程度报警，3=严重报警
	 */
	public void setWid(String wid) {
		this.wid = wid;
	}
	/**
	 * 获取：告警等级，1=一般报警，2=中等程度报警，3=严重报警
	 */
	public String getWid() {
		return wid;
	}
	/**
	 * 设置：是否拦截，0=否，1=是
	 */
	public void setHoldup(String holdup) {
		this.holdup = holdup;
	}
	/**
	 * 获取：是否拦截，0=否，1=是
	 */
	public String getHoldup() {
		return holdup;
	}
	
	
	public BannedIpEntity() {
	}
	public BannedIpEntity( String name, String wtype, String wid, String holdup) {
		this.name = name;
		this.wtype = wtype;
		this.wid = wid;
		this.holdup = holdup;
	}
	@Override
	public String toString() {
		return "BannedIpEntity [id=" + id + ", name=" + name + ", wtype=" + wtype + ", wid=" + wid + ", holdup="
				+ holdup + "]";
	}
	
	
	
}
