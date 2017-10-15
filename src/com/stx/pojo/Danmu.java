package com.stx.pojo;

public class Danmu {
	private int time;	//时间
	private String musicid;	//musicid，外键
	private String detail;	//弹幕内容
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getMusicid() {
		return musicid;
	}
	public void setMusicid(String musicid) {
		this.musicid = musicid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Danmu() {
		super();
	}
	public Danmu(int time, String musicid, String detail) {
		super();
		this.time = time;
		this.musicid = musicid;
		this.detail = detail;
	}
	
}
