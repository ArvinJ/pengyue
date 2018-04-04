package com.ahhf.ljxbw.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-04 13:12:55
 */
public class UserlogininfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 主键
	private Integer id;
	// 登录用户名
	private String loginname;
	// 登录密码
	private String loginpwd;
	// 创建时间
	private Date createdatetime;
	// 状态 1为default
	private Integer status;
	// 类型 1 为default
	private Integer type;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public Date getCreatedatetime() {
		return createdatetime;
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

	public UserlogininfoEntity() {
	}

	public UserlogininfoEntity(String loginname, String loginpwd, Integer status, Integer type) {
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.status = status;
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserlogininfoEntity [id=" + id + ", loginname=" + loginname + ", loginpwd=" + loginpwd
				+ ", createdatetime=" + createdatetime + ", status=" + status + ", type=" + type + "]";
	}

}
