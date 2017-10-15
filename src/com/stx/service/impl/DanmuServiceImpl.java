package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.DanmuDao;
import com.stx.pojo.Danmu;
import com.stx.pojo.DanmuMessage;
import com.stx.pojo.MVDanmu;
import com.stx.service.DanmuService;

//标记一个Service
@Service("danmuService")
public class DanmuServiceImpl implements DanmuService {
	
	//发送弹幕
	public void SendDanmu(Danmu danmu) {
		danmuDao.SendDanmu(danmu);
		
	}
	

	//查询弹幕，根据musicid和time
	public List<DanmuMessage> SelDanmu(Danmu danmu){
		return danmuDao.SelDanmu(danmu);
	}
	
	//插入mv弹幕
	public void SendMVDanmu(MVDanmu mvDanmu){
		danmuDao.SendMVDanmu(mvDanmu);
	}
	
	//查询mv弹幕，根据time和mvid
	public List<DanmuMessage> SelMVDanmu(MVDanmu mvDanmu){
		return danmuDao.SelMVDanmu(mvDanmu);
	}
	@Resource(name="danmuDao")
	private DanmuDao danmuDao;//注入
	
}
