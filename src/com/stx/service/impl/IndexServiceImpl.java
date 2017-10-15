package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.IndexDao;
import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;
import com.stx.service.IndexService;

//标记一个Service
@Service("indexService")
public class IndexServiceImpl implements IndexService {
	
	//查询所有音乐
	public List<Music> AllMusic(){
		return indexDao.AllMusic();
	}
	
	//根据type.id，查询热门下载
	public List<Music> HotMusic(int typeid){
		return indexDao.HotMusic(typeid);
	}
	
	//查看所有的分类的type.id
	public List<Type> SelTypeId(){
		return indexDao.SelTypeId();
	}
	
	//根据关键字key查询
	public List<Music> SelByKey(String key){
		return indexDao.SelByKey(key);
	}
	
	//查询热播mv，根据playnum
	public List<HotMV> SelHotMv(){
		return indexDao.SelHotMv();
	}
	@Resource(name="indexDao")
	private IndexDao indexDao;//注入
	
	
	
}
