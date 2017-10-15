package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.DanmuDao;
import com.stx.pojo.Danmu;
import com.stx.pojo.DanmuMessage;
import com.stx.pojo.MVDanmu;
import com.stx.service.DanmuService;

//���һ��Service
@Service("danmuService")
public class DanmuServiceImpl implements DanmuService {
	
	//���͵�Ļ
	public void SendDanmu(Danmu danmu) {
		danmuDao.SendDanmu(danmu);
		
	}
	

	//��ѯ��Ļ������musicid��time
	public List<DanmuMessage> SelDanmu(Danmu danmu){
		return danmuDao.SelDanmu(danmu);
	}
	
	//����mv��Ļ
	public void SendMVDanmu(MVDanmu mvDanmu){
		danmuDao.SendMVDanmu(mvDanmu);
	}
	
	//��ѯmv��Ļ������time��mvid
	public List<DanmuMessage> SelMVDanmu(MVDanmu mvDanmu){
		return danmuDao.SelMVDanmu(mvDanmu);
	}
	@Resource(name="danmuDao")
	private DanmuDao danmuDao;//ע��
	
}
