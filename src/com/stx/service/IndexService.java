package com.stx.service;

import java.util.List;

import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;

public interface IndexService {
	//查询所有音乐
	public List<Music> AllMusic();
	
	//根据type.id，查询热门下载
	public List<Music> HotMusic(int typeid);
	
	//查看所有的分类的type.id
	public List<Type> SelTypeId();
	
	//根据关键字key查询
	public List<Music> SelByKey(String key);
	
	//查询热播mv，根据playnum
	public List<HotMV> SelHotMv();
}