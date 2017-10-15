package com.stx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.DanmuDao;
import com.stx.mapper.DanmuMapper;
import com.stx.pojo.Danmu;
import com.stx.pojo.DanmuMessage;
import com.stx.pojo.MVDanmu;

@Repository("danmuDao")
public class DanmuImpl extends  SqlSessionDaoSupport implements DanmuDao {
	//发送music弹幕
	public void SendDanmu(Danmu danmu) {
		this.getSqlSession().getMapper(DanmuMapper.class).SendDanmu(danmu);
		
	}
	

	//查询music弹幕，根据musicid和time
	public List<DanmuMessage> SelDanmu(Danmu danmu){
		return this.getSqlSession().getMapper(DanmuMapper.class).SelDanmu(danmu);
	}
	
	//插入mv弹幕
	public void SendMVDanmu(MVDanmu mvDanmu){
		this.getSqlSession().getMapper(DanmuMapper.class).SendMVDanmu(mvDanmu);
	}
	
	//查询mv弹幕，根据time和mvid
	public List<DanmuMessage> SelMVDanmu(MVDanmu mvDanmu){
		return this.getSqlSession().getMapper(DanmuMapper.class).SelMVDanmu(mvDanmu);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
}
