package com.ahhf.ljxbw.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 10:03:36
 */
public class ComputerstatisicsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//
	private String ip;
	//
	private Integer install;
	//
	private String mac;
	//
	private String version;
	//
	private Integer status;

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

	public void setInstall(Integer install) {
		this.install = install;
	}

	public Integer getInstall() {
		return install;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMac() {
		return mac;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public ComputerstatisicsEntity() {
	}

	public ComputerstatisicsEntity(String ip, Integer install, String mac, String version, Integer status) {
		this.ip = ip;
		this.install = install;
		this.mac = mac;
		this.version = version;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ComputerstatisicsEntity [id=" + id + ", ip=" + ip + ", install=" + install + ", mac=" + mac
				+ ", version=" + version + ", status=" + status + "]";
	}

}
