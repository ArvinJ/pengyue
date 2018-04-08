package com.ahhf.ljxbw.entity;

import java.util.List;

public class ResultMeasuresData {
	private List<BannedUrlEntity> url;
	private List<BannedIpEntity> ip;
	private List<BannedKeywordEntity> keyword;
	private List<BannedNameEntity> name;
	private List<BannedGameEntity> game;

	public List<BannedUrlEntity> getUrl() {
		return url;
	}

	public void setUrl(List<BannedUrlEntity> url) {
		this.url = url;
	}

	public List<BannedIpEntity> getIp() {
		return ip;
	}

	public void setIp(List<BannedIpEntity> ip) {
		this.ip = ip;
	}

	public List<BannedKeywordEntity> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<BannedKeywordEntity> keyword) {
		this.keyword = keyword;
	}

	public List<BannedNameEntity> getName() {
		return name;
	}

	public void setName(List<BannedNameEntity> name) {
		this.name = name;
	}

	public List<BannedGameEntity> getGame() {
		return game;
	}

	public void setGame(List<BannedGameEntity> game) {
		this.game = game;
	}

	public ResultMeasuresData() {
	}

	public ResultMeasuresData(List<BannedUrlEntity> url, List<BannedIpEntity> ip, List<BannedKeywordEntity> keyword,
			List<BannedNameEntity> name, List<BannedGameEntity> game) {
		super();
		this.url = url;
		this.ip = ip;
		this.keyword = keyword;
		this.name = name;
		this.game = game;
	}
	
	
	

}
