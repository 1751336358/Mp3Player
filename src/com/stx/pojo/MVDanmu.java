package com.stx.pojo;

public class MVDanmu {
	private int time;
	private String mvid;
	private String detail;
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getMvid() {
		return mvid;
	}
	public void setMvid(String mvid) {
		this.mvid = mvid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public MVDanmu(int time, String mvid, String detail) {
		super();
		this.time = time;
		this.mvid = mvid;
		this.detail = detail;
	}
	public MVDanmu() {
		super();
	}
	
}
