package com.stx.pojo;

public class Say {
	private String id;	//主键id
	private String userid;	//评论者的id
	private String username;	//评论者的username
	private String musicid;	//音乐id
	private String detail;	//评论内容
	private String time;	//发表时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Say(String id, String userid, String username, String musicid,
			String detail, String time) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.musicid = musicid;
		this.detail = detail;
		this.time = time;
	}
	public Say() {
		super();
	}
	
	
}
