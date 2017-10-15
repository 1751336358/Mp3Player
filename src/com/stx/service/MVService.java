package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.stx.pojo.MV;
import com.stx.pojo.Music;
import com.stx.pojo.User;
import com.stx.pojo.pack.HotSingname;
import com.stx.pojo.pack.MusicMV;

public interface MVService {
	//����musicid��ѯmusic��mv��һЩ��Ϣ
	public MusicMV SelMvByMusicId(String musicid);
	
	//����mvid��mv��playnum+1
	public void UpdatePlaynumByMvId(String id);
	
	//����mvid��ѯ��mv����Ϣ
	public MV SelMvById(String id);
	
	//����mvid���music��mv����Ϣ
	public MusicMV SelMusicMVByMvId(String mvid);
}