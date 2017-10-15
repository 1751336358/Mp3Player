package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Danmu;
import com.stx.pojo.DanmuMessage;
import com.stx.pojo.MVDanmu;


public interface DanmuMapper {
	//插入music弹幕 
	public void SendDanmu(Danmu danmu);

	//查询music弹幕，根据musicid和time
	public List<DanmuMessage> SelDanmu(Danmu danmu);
	
	//插入mv弹幕
	public void SendMVDanmu(MVDanmu mvDanmu);
	
	//查询mv弹幕，根据time和mvid
	public List<DanmuMessage> SelMVDanmu(MVDanmu mvDanmu);
}
