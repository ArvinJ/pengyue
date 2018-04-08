package com.ahhf.ljxbw.entity;

/**
 * 
 * 
 * @Title: ResultMeasures.java
 * @Package com.ahhf.ljxbw.entity
 * @Description: TODO(屏蔽库对象)
 * @author: wenjin.zhu
 * @date: 2018年4月8日 下午4:13:53
 * @version V1.0
 */
public class ResultMeasures {

	
	private ResultMeasuresData data;
	private Integer err;
	private Integer errcode;
	private String desc;
	private String t;
	private String at;


	public ResultMeasuresData getData() {
		return data;
	}

	public void setData(ResultMeasuresData data) {
		this.data = data;
	}

	public Integer getErr() {
		return err;
	}

	public void setErr(Integer err) {
		this.err = err;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public ResultMeasures() {
	}

	public ResultMeasures(ResultMeasuresData data, Integer err, Integer errcode, String desc, String t, String at) {
		this.data = data;
		this.err = err;
		this.errcode = errcode;
		this.desc = desc;
		this.t = t;
		this.at = at;
	}

}
