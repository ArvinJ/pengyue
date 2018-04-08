package com.ahhf.ljxbw.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 09:29:05
 */
public class RecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//
	private String ip;
	//
	private Integer t;
	//
	private String info;
	//
	private Integer status;
	//
	private Integer type;
	//

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setT(Integer t) {
		this.t = t;
	}

	public Integer getT() {
		return t;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public RecordEntity() {
	}

	public RecordEntity(String ip, Integer t, String info, Integer status, Integer type) {
		this.ip = ip;
		this.t = t;
		this.info = info;
		this.status = status;
		this.type = type;
	}

	@Override
	public String toString() {
		return "RecordEntity [id=" + id + ", ip=" + ip + ", t=" + t + ", info=" + info + ", status=" + status
				+ ", type=" + type + "]";
	}

}
