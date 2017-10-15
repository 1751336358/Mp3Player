package com.stx.dao;

import java.util.List;

import com.stx.pojo.Danmu;
import com.stx.pojo.DanmuMessage;
import com.stx.pojo.MVDanmu;

public interface DanmuDao {
	//����music��Ļ 
	public void SendDanmu(Danmu danmu);
	

	//��ѯmusic��Ļ������musicid��time
	public List<DanmuMessage> SelDanmu(Danmu danmu);
	
	//����mv��Ļ
	public void SendMVDanmu(MVDanmu mvDanmu);
	
	//��ѯmv��Ļ������time��mvid
	public List<DanmuMessage> SelMVDanmu(MVDanmu mvDanmu);
}
