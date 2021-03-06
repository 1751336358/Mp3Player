package com.stx.dao;

import java.util.List;

import com.stx.pojo.MV;
import com.stx.pojo.pack.MusicMV;

public interface MVDao {
	//根据musicid查询music和mv的一些信息
	public MusicMV SelMvByMusicId(String musicid);
	
	//根据mvid将mv的playnum+1
	public void UpdatePlaynumByMvId(String id);
	
	//根据mvid查询出mv的信息
	public MV SelMvById(String id);
	
	//根据mvid查出music和mv的信息
	public MusicMV SelMusicMVByMvId(String mvid);
}
