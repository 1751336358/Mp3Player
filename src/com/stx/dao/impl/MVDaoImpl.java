package com.stx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.MVDao;
import com.stx.mapper.MVMapper;
import com.stx.pojo.MV;
import com.stx.pojo.pack.MusicMV;

@Repository("mvDao")
public class MVDaoImpl extends  SqlSessionDaoSupport implements MVDao {
	
	//����musicid��ѯmusic��mv��һЩ��Ϣ
	public MusicMV SelMvByMusicId(String musicid){
		return this.getSqlSession().getMapper(MVMapper.class).SelMvByMusicId(musicid);
	}
	
	//����mvid��mv��playnum+1
	public void UpdatePlaynumByMvId(String id){
		
		this.getSqlSession().getMapper(MVMapper.class).UpdatePlaynumByMvId(id);
	}
	
	//����mvid��ѯ��mv����Ϣ
	public MV SelMvById(String id){
		return this.getSqlSession().getMapper(MVMapper.class).SelMvById(id);
	}
	
	//����mvid���music��mv����Ϣ
	public MusicMV SelMusicMVByMvId(String mvid){
		return this.getSqlSession().getMapper(MVMapper.class).SelMusicMVByMvId(mvid);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
}
