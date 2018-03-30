package com.ahhf.ljxbw.entity;

/**
 * 
 * 
 * @Title: ResultCode.java
 * @Package com.ahhf.ljxbw.entity
 * @Description: TODO(返回json对象)
 * @author: wenjin.zhu
 * @date: 2018年3月30日 上午11:08:01
 * @version V1.0
 */
public class ResultCode {

	private ResultData data;
	private int err;
	private int errcode;
	private String desc;
	private String t;
	private String at;

	public ResultData getData() {
		return data;
	}

	public void setData(ResultData data) {
		this.data = data;
	}

	public int getErr() {
		return err;
	}

	public void setErr(int err) {
		this.err = err;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
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

	public ResultCode() {
	}

	public ResultCode(ResultData data, int err, int errcode, String desc, String t, String at) {
		this.data = data;
		this.err = err;
		this.errcode = errcode;
		this.desc = desc;
		this.t = t;
		this.at = at;
	}

	@Override
	public String toString() {
		return "ResultCode [data=" + data + ", err=" + err + ", errcode=" + errcode + ", desc=" + desc + ", t=" + t
				+ ", at=" + at + "]";
	}

}
