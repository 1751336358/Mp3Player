package com.stx.pojo.pack;

//疯转了music和MV中的一些信息
public class MusicMV {
	private String musicid;
	private String musicfilename;	//音乐名
	private String singname;	//歌手
	private String mvid;	//mvid
	private String mvpath;	//mv路径
	private String mvname;	//mv名
	private int playnum;	//播放量
	public String getMusicid() {
		return musicid;
	}
	public void setMusicid(String musicid) {
		this.musicid = musicid;
	}
	public String getMusicfilename() {
		return musicfilename;
	}
	public void setMusicfilename(String musicfilename) {
		this.musicfilename = musicfilename;
	}
	public String getMvid() {
		return mvid;
	}
	public void setMvid(String mvid) {
		this.mvid = mvid;
	}
	public String getMvpath() {
		return mvpath;
	}
	public void setMvpath(String mvpath) {
		this.mvpath = mvpath;
	}
	public String getMvname() {
		return mvname;
	}
	public void setMvname(String mvname) {
		this.mvname = mvname;
	}
	public int getPlaynum() {
		return playnum;
	}
	public void setPlaynum(int playnum) {
		this.playnum = playnum;
	}
	public String getSingname() {
		return singname;
	}
	public void setSingname(String singname) {
		this.singname = singname;
	}
	
}
