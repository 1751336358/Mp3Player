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
	

	//��ѯ��������
	public List<Music> AllMusic(){
		return this.getSqlSession().getMapper(IndexMapper.class).AllMusic();
	}
	
	//����type.id����ѯ��������
	public List<Music> HotMusic(int typeid){
		return this.getSqlSession().getMapper(IndexMapper.class).HotMusic(typeid);
	}
	
	//�鿴���еķ����type.id
	public List<Type> SelTypeId(){
		return this.getSqlSession().getMapper(IndexMapper.class).SelTypeId();
	}
	
	//���ݹؼ���key��ѯ
	public List<Music> SelByKey(String key){
		return this.getSqlSession().getMapper(IndexMapper.class).SelByKey(key);
	}
	
	//��ѯ�Ȳ�mv������playnum
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
