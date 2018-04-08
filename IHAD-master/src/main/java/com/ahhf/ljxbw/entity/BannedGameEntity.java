package com.ahhf.ljxbw.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-08 16:00:19
 */
public class BannedGameEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 游戏文件名
	private String filename;
	// 进程名
	private String process;
	// 特征码
	private String code;
	// 告警类型，1=URL访问报警，2=游戏、程序报警，3=运行报警，4=特殊人员报警，5=关键字报警，6=紧急状况，7=未成年人告警，8=上网时长告警，9=擅停告警
	private String wtype;
	// 告警等级，1=一般报警，2=中等程度报警，3=严重报警
	private String wid;
	//

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
	 * 设置：游戏文件名
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * 获取：游戏文件名
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * 设置：进程名
	 */
	public void setProcess(String process) {
		this.process = process;
	}

	/**
	 * 获取：进程名
	 */
	public String getProcess() {
		return process;
	}

	/**
	 * 设置：特征码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取：特征码
	 */
	public String getCode() {
		return code;
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
	 * 设置：
	 */
	public BannedGameEntity() {
	}

	public BannedGameEntity(String filename, String process, String code, String wtype, String wid) {
		this.filename = filename;
		this.process = process;
		this.code = code;
		this.wtype = wtype;
		this.wid = wid;
	}

	@Override
	public String toString() {
		return "BannedGameEntity [id=" + id + ", filename=" + filename + ", process=" + process + ", code=" + code
				+ ", wtype=" + wtype + ", wid=" + wid + "]";
	}

}
