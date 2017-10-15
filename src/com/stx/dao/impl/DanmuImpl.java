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
	//����music��Ļ
	public void SendDanmu(Danmu danmu) {
		this.getSqlSession().getMapper(DanmuMapper.class).SendDanmu(danmu);
		
	}
	

	//��ѯmusic��Ļ������musicid��time
	public List<DanmuMessage> SelDanmu(Danmu danmu){
		return this.getSqlSession().getMapper(DanmuMapper.class).SelDanmu(danmu);
	}
	
	//����mv��Ļ
	public void SendMVDanmu(MVDanmu mvDanmu){
		this.getSqlSession().getMapper(DanmuMapper.class).SendMVDanmu(mvDanmu);
	}
	
	//��ѯmv��Ļ������time��mvid
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
