package com.stx.pojo;

public class MV {
	private String id;	//����
	private String mvname;	//mv��,�ϴ�����Ƶ��
	private String mvpath;	//mv·��	 /a/b/xxx.mp4
	private String playnum;	//������
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPlaynum() {
		return playnum;
	}
	public void setPlaynum(String playnum) {
		this.playnum = playnum;
	}
	public MV(String id, String mvname, String mvpath, String playnum) {
		super();
		this.id = id;
		this.mvname = mvname;
		this.mvpath = mvpath;
		this.playnum = playnum;
	}
	public MV() {
		super();
	}
	
}



