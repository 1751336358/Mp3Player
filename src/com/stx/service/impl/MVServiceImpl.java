package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.MVDao;
import com.stx.pojo.MV;
import com.stx.pojo.pack.MusicMV;
import com.stx.service.MVService;

//���һ��Service
@Service("mvService")
public class MVServiceImpl implements MVService {
	
	//����musicid��ѯmusic��mv��һЩ��Ϣ
	public MusicMV SelMvByMusicId(String musicid){
		return mvDao.SelMvByMusicId(musicid);
	}
	
	//����mvid��mv��playnum+1
	public void UpdatePlaynumByMvId(String id){
		mvDao.UpdatePlaynumByMvId(id);
	}
	
	//����mvid��ѯ��mv����Ϣ
	public MV SelMvById(String id){
		return mvDao.SelMvById(id);
	}
	
	//����mvid���music��mv����Ϣ
	public MusicMV SelMusicMVByMvId(String mvid){
		return mvDao.SelMusicMVByMvId(mvid);
	}
	@Resource(name="mvDao")
	private MVDao mvDao;//ע��
	
}
