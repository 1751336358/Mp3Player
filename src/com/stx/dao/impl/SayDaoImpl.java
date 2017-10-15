package com.stx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.SayDao;
import com.stx.mapper.SayMapper;
import com.stx.pojo.Say;

@Repository("sayDao")
public class SayDaoImpl extends  SqlSessionDaoSupport implements SayDao {
	

	//将用户评论插入数据库
	public void addSay(Say say){
		this.getSqlSession().getMapper(SayMapper.class).addSay(say);
	}
	
	//查看所有评论，根据musicid
	public List<Say> SelAllSay(String musicid){
		return this.getSqlSession().getMapper(SayMapper.class).SelAllSay(musicid);
	}
	
	//删除评论，根据say.id
	public void delSayById(String id){
		this.getSqlSession().getMapper(SayMapper.class).delSayById(id);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
