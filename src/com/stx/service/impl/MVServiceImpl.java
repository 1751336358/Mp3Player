package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.MVDao;
import com.stx.pojo.MV;
import com.stx.pojo.pack.MusicMV;
import com.stx.service.MVService;

//标记一个Service
@Service("mvService")
public class MVServiceImpl implements MVService {
	
	//根据musicid查询music和mv的一些信息
	public MusicMV SelMvByMusicId(String musicid){
		return mvDao.SelMvByMusicId(musicid);
	}
	
	//根据mvid将mv的playnum+1
	public void UpdatePlaynumByMvId(String id){
		mvDao.UpdatePlaynumByMvId(id);
	}
	
	//根据mvid查询出mv的信息
	public MV SelMvById(String id){
		return mvDao.SelMvById(id);
	}
	
	//根据mvid查出music和mv的信息
	public MusicMV SelMusicMVByMvId(String mvid){
		return mvDao.SelMusicMVByMvId(mvid);
	}
	@Resource(name="mvDao")
	private MVDao mvDao;//注入
	
}
