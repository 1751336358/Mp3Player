package com.stx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.IndexDao;
import com.stx.mapper.IndexMapper;
import com.stx.pojo.Music;
import com.stx.pojo.Type;
import com.stx.pojo.pack.HotMV;

@Repository("indexDao")
public class IndexDaoImpl extends  SqlSessionDaoSupport implements IndexDao {
	

	//查询所有音乐
	public List<Music> AllMusic(){
		return this.getSqlSession().getMapper(IndexMapper.class).AllMusic();
	}
	
	//根据type.id，查询热门下载
	public List<Music> HotMusic(int typeid){
		return this.getSqlSession().getMapper(IndexMapper.class).HotMusic(typeid);
	}
	
	//查看所有的分类的type.id
	public List<Type> SelTypeId(){
		return this.getSqlSession().getMapper(IndexMapper.class).SelTypeId();
	}
	
	//根据关键字key查询
	public List<Music> SelByKey(String key){
		return this.getSqlSession().getMapper(IndexMapper.class).SelByKey(key);
	}
	
	//查询热播mv，根据playnum
	public List<HotMV> SelHotMv(){
		return this.getSqlSession().getMapper(IndexMapper.class).SelHotMv();
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
