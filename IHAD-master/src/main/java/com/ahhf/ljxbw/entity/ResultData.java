package com.ahhf.ljxbw.entity;

/**
 * 
 * 
 * @Title: ResultData.java
 * @Package com.ahhf.ljxbw.entity
 * @Description: TODO(返回data项)
 * @author: wenjin.zhu
 * @date: 2018年3月30日 下午12:17:05
 * @version V1.0
 */
public class ResultData {
	private String token;
	private String vkey;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVkey() {
		return vkey;
	}

	public void setVkey(String vkey) {
		this.vkey = vkey;
	}

	public ResultData() {
	}

	public ResultData(String token, String vkey) {
		this.token = token;
		this.vkey = vkey;
	}

	@Override
	public String toString() {
		return "ResultData [token=" + token + ", vkey=" + vkey + "]";
	}

}
