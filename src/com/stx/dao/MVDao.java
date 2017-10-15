package com.stx.dao;

import java.util.List;

import com.stx.pojo.MV;
import com.stx.pojo.pack.MusicMV;

public interface MVDao {
	//����musicid��ѯmusic��mv��һЩ��Ϣ
	public MusicMV SelMvByMusicId(String musicid);
	
	//����mvid��mv��playnum+1
	public void UpdatePlaynumByMvId(String id);
	
	//����mvid��ѯ��mv����Ϣ
	public MV SelMvById(String id);
	
	//����mvid���music��mv����Ϣ
	public MusicMV SelMusicMVByMvId(String mvid);
}
