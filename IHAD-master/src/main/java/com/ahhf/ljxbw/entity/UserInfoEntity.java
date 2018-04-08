package com.ahhf.ljxbw.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 14:46:39
 */
public class UserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//
	private String no;
	//
	private Integer cardtype;
	//
	private String cardno;
	//
	private String name;
	//
	private String ip;
	//
	private Integer status;
	//
	private Integer type;
	//
	private String t;

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
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * 获取：
	 */
	public String getNo() {
		return no;
	}

	/**
	 * 设置：
	 */
	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}

	/**
	 * 获取：
	 */
	public Integer getCardtype() {
		return cardtype;
	}

	/**
	 * 设置：
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	/**
	 * 获取：
	 */
	public String getCardno() {
		return cardno;
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
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取：
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：
	 */
	public void setT(String t) {
		this.t = t;
	}

	/**
	 * 获取：
	 */
	public String getT() {
		return t;
	}

	public UserInfoEntity() {
	}

	public UserInfoEntity(String no, Integer cardtype, String cardno, String name, String ip, Integer status,
			Integer type, String t) {
		this.no = no;
		this.cardtype = cardtype;
		this.cardno = cardno;
		this.name = name;
		this.ip = ip;
		this.status = status;
		this.type = type;
		this.t = t;
	}

	@Override
	public String toString() {
		return "UserInfoEntity [id=" + id + ", no=" + no + ", cardtype=" + cardtype + ", cardno=" + cardno + ", name="
				+ name + ", ip=" + ip + ", status=" + status + ", type=" + type + ", t=" + t + "]";
	}
	
	
	

}
