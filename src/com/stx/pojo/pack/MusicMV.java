package com.stx.pojo.pack;

//��ת��music��MV�е�һЩ��Ϣ
public class MusicMV {
	private String musicid;
	private String musicfilename;	//������
	private String singname;	//����
	private String mvid;	//mvid
	private String mvpath;	//mv·��
	private String mvname;	//mv��
	private int playnum;	//������
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
