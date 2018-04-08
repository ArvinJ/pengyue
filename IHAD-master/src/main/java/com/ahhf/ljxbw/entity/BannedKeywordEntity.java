package com.ahhf.ljxbw.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public class BannedKeywordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//
	private String name;
	//
	private String wtype;
	//
	private String wid;
	//
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
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：
	 */
	public void setWtype(String wtype) {
		this.wtype = wtype;
	}

	/**
	 * 获取：
	 */
	public String getWtype() {
		return wtype;
	}

	/**
	 * 设置：
	 */
	public void setWid(String wid) {
		this.wid = wid;
	}

	/**
	 * 获取：
	 */
	public String getWid() {
		return wid;
	}

	/**
	 * 设置：
	 */
	public void setHoldup(String holdup) {
		this.holdup = holdup;
	}

	/**
	 * 获取：
	 */
	public String getHoldup() {
		return holdup;
	}

	public BannedKeywordEntity() {
	}

	public BannedKeywordEntity(String name, String wtype, String wid, String holdup) {
		this.name = name;
		this.wtype = wtype;
		this.wid = wid;
		this.holdup = holdup;
	}

	@Override
	public String toString() {
		return "BannedKeywordEntity [id=" + id + ", name=" + name + ", wtype=" + wtype + ", wid=" + wid + ", holdup="
				+ holdup + "]";
	}

}
