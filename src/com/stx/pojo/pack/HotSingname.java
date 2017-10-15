package com.stx.pojo.pack;

//封装了歌手唱的歌曲的数量和歌手的名字，用于查询热门歌手
public class HotSingname {
	private String singname;	//歌手名
	private String count;	//该歌手唱歌的数量
	public String getSingname() {
		return singname;
	}
	public void setSingname(String singname) {
		this.singname = singname;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
