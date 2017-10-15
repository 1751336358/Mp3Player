package com.stx.pojo;

public class Music {
	private String id;	//����id
	private String filename;	//��ʵ�ļ���aaa.mp3
	private String musicpath;	//�ļ��ڷ�������·��	/aaa/bbb/xxx.mp3
	private String time;	//�ϴ�ʱ��
	private int downloadnum;	//������
	private String userid;	//�����userid
	private String username;	//�ϴ��û�
	private int typeid;	//���ID������id
	private String singname;	//����
	private String mvpath;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMusicpath() {
		return musicpath;
	}
	public void setMusicpath(String musicpath) {
		this.musicpath = musicpath;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getDownloadnum() {
		return downloadnum;
	}
	public void setDownloadnum(int downloadnum) {
		this.downloadnum = downloadnum;
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
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getSingname() {
		return singname;
	}
	public void setSingname(String singname) {
		this.singname = singname;
	}
	public String getMvpath() {
		return mvpath;
	}
	public void setMvpath(String mvpath) {
		this.mvpath = mvpath;
	}
	public Music(String id, String filename, String musicpath, String time,
			int downloadnum, String userid, String username, int typeid,
			String singname, String mvpath) {
		super();
		this.id = id;
		this.filename = filename;
		this.musicpath = musicpath;
		this.time = time;
		this.downloadnum = downloadnum;
		this.userid = userid;
		this.username = username;
		this.typeid = typeid;
		this.singname = singname;
		this.mvpath = mvpath;
	}
	public Music() {
		super();
	}
	
	
	
}
